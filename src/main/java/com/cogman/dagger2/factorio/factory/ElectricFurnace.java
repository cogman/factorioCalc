package com.cogman.dagger2.factorio.factory;

import javax.inject.Inject;
import java.math.BigDecimal;

public class ElectricFurnace implements Factory {
    private static final BigDecimal POWER_DRAW = BigDecimal.valueOf(180_000);
    private static final BigDecimal PRODUCTION_SPEED = BigDecimal.valueOf(2);

    @Inject ElectricFurnace(){}

    @Override
    public BigDecimal powerDraw() {
        return POWER_DRAW;
    }

    @Override
    public BigDecimal productionSpeed() {
        return PRODUCTION_SPEED;
    }
}
