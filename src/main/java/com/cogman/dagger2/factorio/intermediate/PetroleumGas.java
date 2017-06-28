package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.factory.ProductionCalc;
import com.cogman.dagger2.factorio.rawmaterial.CrudeOil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PetroleumGas implements Recipe {
    private static final BigDecimal GAS_TIME = BigDecimal.valueOf(5);

    private final Map<Recipe, BigDecimal> requirements;

    public PetroleumGas(ProductionCalc refineryCalc, CrudeOil crudeOil) {
        Map<Recipe, BigDecimal> powerRequirements = new HashMap<>(refineryCalc.getProductionCosts(GAS_TIME));
        powerRequirements.put(crudeOil, BigDecimal.valueOf(100));
        powerRequirements.replaceAll((r, b)->b.divide(BigDecimal.valueOf(55), MathContext.DECIMAL128));
        requirements = Collections.unmodifiableMap(powerRequirements);
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
