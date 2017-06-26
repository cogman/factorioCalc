package com.cogman.dagger2.factorio.factory;

import java.math.BigDecimal;

public class ChemicalPlant implements Factory {
    private static final BigDecimal POWER_DRAW = BigDecimal.valueOf(210_000);
    private static final BigDecimal PRODUCTION_SPEED = BigDecimal.valueOf(125, 2);

    @Override
    public BigDecimal powerDraw() {
        return POWER_DRAW;
    }

    @Override
    public BigDecimal productionSpeed() {
        return PRODUCTION_SPEED;
    }
}
