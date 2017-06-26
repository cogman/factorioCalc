package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;
import com.cogman.dagger2.factorio.rawmaterial.Coal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PlasticBar implements Recipe {
    private static final BigDecimal CRAFTING_TIME = BigDecimal.ONE;

    private final Map<Recipe, BigDecimal> requirements;

    public PlasticBar(ProductionCalc chemCalc, Coal coal, PetroleumGas petroleumGas) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(chemCalc.getProductionCosts(CRAFTING_TIME));
        powerRequirements.compute(coal, (recipe, v)->{
            if (v == null)
                return BigDecimal.ONE;
            else
                return v.add(BigDecimal.ONE);
        });
        powerRequirements.put(petroleumGas, BigDecimal.valueOf(20));
        powerRequirements.replaceAll((recipe, v) -> v.divide(BigDecimal.valueOf(2), MathContext.DECIMAL128));
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
