package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.ElectricFurnaceFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import com.cogman.dagger2.factorio.rawmaterial.IronOreFactory;
import java.util.function.Supplier;

public class IronPlateFactory implements Supplier<IronPlate>
{
	private static final IronPlateFactory INSTANCE = new IronPlateFactory();

	private IronPlateFactory(){}

	public static IronPlateFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public IronPlate get()
	{
		return new IronPlate(
				ProductionCalcFactory.instance().get(ElectricFurnaceFactory.instance()),
				IronOreFactory.instance().get());
	}
}
