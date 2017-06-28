package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.ElectricFurnaceFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import com.cogman.dagger2.factorio.rawmaterial.CopperOreFactory;
import java.util.function.Supplier;

public class CopperPlateFactory implements Supplier<CopperPlate>
{
	private static final CopperPlateFactory INSTANCE = new CopperPlateFactory();

	private CopperPlateFactory(){}

	public static CopperPlateFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public CopperPlate get()
	{
		return new CopperPlate(ProductionCalcFactory.instance().get(ElectricFurnaceFactory.instance()), CopperOreFactory.instance().get());
	}
}
