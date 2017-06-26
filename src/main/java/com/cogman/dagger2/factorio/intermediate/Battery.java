package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Battery implements Recipe {
    private static final BigDecimal COOKING_TIME = BigDecimal.valueOf(5);

    private final Map<Recipe, BigDecimal> requirements;

    public Battery(ProductionCalc chemCalc, CopperPlate copperPlate, IronPlate ironPlate, SulfuricAcid sulfuricAcid) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(chemCalc.getProductionCosts(COOKING_TIME));
        powerRequirements.put(sulfuricAcid, BigDecimal.valueOf(20));
        powerRequirements.put(ironPlate, BigDecimal.ONE);
        powerRequirements.put(copperPlate, BigDecimal.ONE);
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
