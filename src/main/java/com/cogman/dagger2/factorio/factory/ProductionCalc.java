package com.cogman.dagger2.factorio.factory;

import com.cogman.dagger2.factorio.power.PowerSource;
import com.cogman.dagger2.factorio.Recipe;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class ProductionCalc {
    private final BigDecimal powerUsageRatio;
    private final PowerSource powerSource;

    @Inject ProductionCalc(Factory factory, PowerSource powerSource) {
        this.powerSource = powerSource;
        this.powerUsageRatio = factory.powerDraw().divide(factory.productionSpeed(), MathContext.DECIMAL128);
    }

    public Map<Recipe, BigDecimal> getProductionCosts(BigDecimal time) {
        Map<Recipe, BigDecimal> requirements = new HashMap<>(powerSource.getRequirements());
        BigDecimal productionCost = time.multiply(powerUsageRatio);
        requirements.replaceAll((r, b)->b.multiply(productionCost));
        return requirements;
    }
}
