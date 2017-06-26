package com.cogman.dagger2.factorio.power;


import com.cogman.dagger2.factorio.Recipe;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Collections;
import java.util.Map;

public class SteamEngine implements PowerSource {
    private final Map<Recipe, BigDecimal> requirements;

    public SteamEngine(Fuel fuel) {
        this.requirements = Collections.singletonMap(fuel, BigDecimal.valueOf(2)
                .divide(fuel.joules(), MathContext.DECIMAL128));
    }

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return requirements;
    }
}
