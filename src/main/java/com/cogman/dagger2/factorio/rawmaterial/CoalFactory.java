package com.cogman.dagger2.factorio.rawmaterial;

import com.cogman.dagger2.factorio.factory.ElectricMinerFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import java.util.function.Supplier;

public class CoalFactory implements Supplier<Coal>
{
	private static final CoalFactory INSTANCE = new CoalFactory();

	private CoalFactory(){}

	public static CoalFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public Coal get()
	{
		return new Coal(ProductionCalcFactory.instance().get(ElectricMinerFactory.instance()));
	}
}
