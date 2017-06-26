package com.cogman.dagger2.factorio.rawmaterial;

import com.cogman.dagger2.factorio.power.Fuel;
import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

public class Coal implements Recipe, Fuel {
    private static final BigDecimal MINING_TIME = BigDecimal.valueOf(2);
    private static final BigDecimal JOULES = BigDecimal.valueOf(8_000_000);
    private final Map<Recipe, BigDecimal> requirements;

    @Inject Coal(ProductionCalc productionCalc) {
        requirements = Collections.unmodifiableMap(productionCalc.getProductionCosts(MINING_TIME));
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }

    @Override
    public BigDecimal joules() {
        return JOULES;
    }
}
