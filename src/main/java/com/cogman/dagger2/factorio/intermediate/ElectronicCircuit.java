package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ElectronicCircuit implements Recipe {
    private static final BigDecimal CRAFTING_TIME = BigDecimal.valueOf(5, 1);

    private final Map<Recipe, BigDecimal> requirements;

    @Inject ElectronicCircuit(@Named("assemblyMachine") ProductionCalc plantCalc, CopperCable copperCable, IronPlate ironPlate) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(plantCalc.getProductionCosts(CRAFTING_TIME));
        powerRequirements.put(copperCable, BigDecimal.valueOf(3));
        powerRequirements.put(ironPlate, BigDecimal.ONE);
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
