package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SpeedModule implements Recipe {
    private static final BigDecimal CRAFTING_TIME = BigDecimal.valueOf(15);

    private final Map<Recipe, BigDecimal> requirements;

    public SpeedModule(ProductionCalc craftCalc, AdvancedCircuit advancedCircuit, ElectronicCircuit electronicCircuit) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(craftCalc.getProductionCosts(CRAFTING_TIME));
        powerRequirements.put(electronicCircuit, BigDecimal.valueOf(5));
        powerRequirements.put(advancedCircuit, BigDecimal.valueOf(5));
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
