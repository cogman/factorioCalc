package com.cogman.dagger2.factorio.power;

import com.cogman.dagger2.factorio.Recipe;

import java.math.BigDecimal;

public interface Fuel extends Recipe {
    BigDecimal joules();
}
