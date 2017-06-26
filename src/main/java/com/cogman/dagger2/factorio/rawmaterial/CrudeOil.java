package com.cogman.dagger2.factorio.rawmaterial;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

public class CrudeOil implements Recipe {
    private static final BigDecimal PUMP_TIME = BigDecimal.valueOf(2, 2);

    private final Map<Recipe, BigDecimal> requirements;

    public CrudeOil(ProductionCalc pumpCalc) {
        requirements = Collections.unmodifiableMap(pumpCalc.getProductionCosts(PUMP_TIME));
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
