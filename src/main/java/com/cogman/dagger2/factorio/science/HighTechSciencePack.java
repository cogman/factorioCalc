package com.cogman.dagger2.factorio.science;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;
import com.cogman.dagger2.factorio.intermediate.Battery;
import com.cogman.dagger2.factorio.intermediate.CopperCable;
import com.cogman.dagger2.factorio.intermediate.ProcessingUnit;
import com.cogman.dagger2.factorio.intermediate.SpeedModule;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HighTechSciencePack implements Recipe {
    private static final BigDecimal CRAFTING_TIME = BigDecimal.valueOf(14);

    private final Map<Recipe, BigDecimal> requirements;

    public HighTechSciencePack(ProductionCalc craftCalc, Battery battery, CopperCable copperCable, ProcessingUnit processingUnit, SpeedModule speedModule) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(craftCalc.getProductionCosts(CRAFTING_TIME));
        powerRequirements.put(processingUnit, BigDecimal.valueOf(3));
        powerRequirements.put(copperCable, BigDecimal.valueOf(30));
        powerRequirements.put(battery, BigDecimal.ONE);
        powerRequirements.put(speedModule, BigDecimal.ONE);
        powerRequirements.replaceAll((recipe, v) -> v.divide(BigDecimal.valueOf(2), MathContext.DECIMAL128));
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
