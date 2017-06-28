package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.ChemicalPlantFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import java.util.function.Supplier;

public class BatteryFactory implements Supplier<Battery>
{
	private static final BatteryFactory INSTANCE = new BatteryFactory();

	private BatteryFactory(){}

	public static BatteryFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public Battery get()
	{
		return new Battery(ProductionCalcFactory.instance().get(ChemicalPlantFactory.instance()),
						   CopperPlateFactory.instance().get(),
						   IronPlateFactory.instance().get(),
						   SulfuricAcidFactory.instance().get());
	}
}
