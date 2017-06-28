package com.cogman.dagger2.factorio.factory;

import java.math.BigDecimal;

public class PumpJack implements Factory {
    private static final BigDecimal POWER_DRAW = BigDecimal.valueOf(90_000);
    private static final BigDecimal PRODUCTION_SPEED = BigDecimal.ONE;

    @Override
    public BigDecimal powerDraw() {
        return POWER_DRAW;
    }

    @Override
    public BigDecimal productionSpeed() {
        return PRODUCTION_SPEED;
    }
}
