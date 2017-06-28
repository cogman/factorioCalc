package com.cogman.dagger2.factorio.factory;

import java.math.BigDecimal;

public class Refinery implements Factory {
    private final BigDecimal POWER_DRAW = BigDecimal.valueOf(420_000);

    @Override
    public BigDecimal powerDraw() {
        return POWER_DRAW;
    }

    @Override
    public BigDecimal productionSpeed() {
        return BigDecimal.ONE;
    }
}
