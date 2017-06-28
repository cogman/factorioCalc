package com.cogman.dagger2.factorio;

import java.math.BigDecimal;
import java.util.Map;

public interface Recipe {
    Map<Recipe, BigDecimal> getRequirements();
}
