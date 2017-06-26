package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Sulfur implements Recipe {
    private static final BigDecimal COOKING_TIME = BigDecimal.ONE;

    private final Map<Recipe, BigDecimal> requirements;

    @Inject Sulfur(ProductionCalc chemCalc, PetroleumGas petroleumGas) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(chemCalc.getProductionCosts(COOKING_TIME));
        powerRequirements.put(petroleumGas, BigDecimal.valueOf(30));
        powerRequirements.replaceAll((r,b)->b.divide(BigDecimal.valueOf(2), MathContext.DECIMAL128));
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
