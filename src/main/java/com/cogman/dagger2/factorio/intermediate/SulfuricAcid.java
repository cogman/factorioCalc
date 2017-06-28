package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SulfuricAcid implements Recipe {
    private static final BigDecimal COOKING_TIME = BigDecimal.ONE;

    private final Map<Recipe, BigDecimal> requirements;

    @Inject SulfuricAcid(@Named("chemPlant") ProductionCalc chemCalc, Sulfur sulfur, IronPlate ironPlate) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(chemCalc.getProductionCosts(COOKING_TIME));
        powerRequirements.put(sulfur, BigDecimal.valueOf(5));
        powerRequirements.put(ironPlate, BigDecimal.ONE);
        powerRequirements.replaceAll((r,b)->b.divide(BigDecimal.valueOf(50), MathContext.DECIMAL128));
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
