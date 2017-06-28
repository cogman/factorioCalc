package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProcessingUnit implements Recipe {
    private static final BigDecimal CRAFTING_TIME = BigDecimal.valueOf(10);

    private final Map<Recipe, BigDecimal> requirements;

    public ProcessingUnit(ProductionCalc craftCalc, AdvancedCircuit advancedCircuit, ElectronicCircuit electronicCircuit, SulfuricAcid sulfuricAcid) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(craftCalc.getProductionCosts(CRAFTING_TIME));
        powerRequirements.put(sulfuricAcid, BigDecimal.valueOf(5));
        powerRequirements.put(electronicCircuit, BigDecimal.valueOf(20));
        powerRequirements.put(advancedCircuit, BigDecimal.valueOf(2));
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
