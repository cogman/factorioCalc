package com.cogman.dagger2.factorio.factory;

import javax.inject.Inject;
import java.math.BigDecimal;

public class ChemicalPlant implements Factory {
    private static final BigDecimal POWER_DRAW = BigDecimal.valueOf(210_000);
    private static final BigDecimal PRODUCTION_SPEED = BigDecimal.valueOf(125, 2);

    @Inject ChemicalPlant(){}

    @Override
    public BigDecimal powerDraw() {
        return POWER_DRAW;
    }

    @Override
    public BigDecimal productionSpeed() {
        return PRODUCTION_SPEED;
    }
}
