package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CopperCable implements Recipe {
    private static final BigDecimal CRAFTING_TIME = BigDecimal.valueOf(5, 1);

    private final Map<Recipe, BigDecimal> requirements;

    public CopperCable(ProductionCalc craftCalc, CopperPlate copperOre) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(craftCalc.getProductionCosts(CRAFTING_TIME));
        powerRequirements.put(copperOre, BigDecimal.ONE);
        powerRequirements.replaceAll((r, b)->b.divide(BigDecimal.valueOf(2), MathContext.DECIMAL128));
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
