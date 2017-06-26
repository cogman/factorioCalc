package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;
import com.cogman.dagger2.factorio.rawmaterial.CopperOre;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CopperPlate implements Recipe {
    private static final BigDecimal SMELTING_TIME = BigDecimal.valueOf(35, 1);

    private final Map<Recipe, BigDecimal> requirements;

    @Inject CopperPlate(ProductionCalc furnaceCale, CopperOre copperOre) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(furnaceCale.getProductionCosts(SMELTING_TIME));
        powerRequirements.put(copperOre, BigDecimal.ONE);
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
