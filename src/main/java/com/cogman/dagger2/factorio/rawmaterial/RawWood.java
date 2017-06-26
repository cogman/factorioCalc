package com.cogman.dagger2.factorio.rawmaterial;

import com.cogman.dagger2.factorio.Recipe;
import com.cogman.dagger2.factorio.power.Fuel;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

public class RawWood implements Fuel {
    private static final BigDecimal JOULES = BigDecimal.valueOf(4_000_000);

    @Inject RawWood() {}
    
    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return Collections.emptyMap();
    }

    @Override
    public BigDecimal joules() {
        return JOULES;
    }
}
