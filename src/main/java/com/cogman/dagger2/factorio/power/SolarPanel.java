package com.cogman.dagger2.factorio.power;

import com.cogman.dagger2.factorio.Recipe;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;

public class SolarPanel implements PowerSource {
    @Inject SolarPanel(){}

    @Override
    public Map<Recipe, BigDecimal> getRequirements() {
        return Collections.emptyMap();
    }
}
