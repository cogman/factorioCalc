package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AdvancedCircuit implements Recipe {
    private static final BigDecimal CRAFTING_TIME = BigDecimal.valueOf(6);

    private final Map<Recipe, BigDecimal> requirements;

    @Inject AdvancedCircuit(ProductionCalc plantCalc, CopperCable copperCable, ElectronicCircuit electronicCircuit, PlasticBar plasticBar) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(plantCalc.getProductionCosts(CRAFTING_TIME));
        powerRequirements.put(copperCable, BigDecimal.valueOf(4));
        powerRequirements.put(electronicCircuit, BigDecimal.valueOf(2));
        powerRequirements.put(plasticBar, BigDecimal.valueOf(2));
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
