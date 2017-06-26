package com.cogman.dagger2.factorio.rawmaterial;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

public class CopperOre implements Recipe {
    private static final BigDecimal MINING_TIME = BigDecimal.valueOf(2);

    private final Map<Recipe, BigDecimal> requirements;

    public CopperOre(ProductionCalc minerCalc) {
        requirements = Collections.unmodifiableMap(minerCalc.getProductionCosts(MINING_TIME));
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
