package com.cogman.dagger2.factorio.factory;

import java.math.BigDecimal;

public class ElectricMiner implements Factory {
    private static final BigDecimal POWER_DRAW = BigDecimal.valueOf(90_000);
    private static final BigDecimal MINING_SPEED = BigDecimal.ONE.divide(BigDecimal.valueOf(2));

    public BigDecimal powerDraw() {
        return POWER_DRAW;
    }

    public BigDecimal productionSpeed() {
        return MINING_SPEED;
    }
}
