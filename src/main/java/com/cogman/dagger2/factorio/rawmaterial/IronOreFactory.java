package com.cogman.dagger2.factorio.rawmaterial;

import com.cogman.dagger2.factorio.factory.ElectricMinerFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import java.util.function.Supplier;

public class IronOreFactory implements Supplier<IronOre>
{
	private static final IronOreFactory INSTANCE = new IronOreFactory();

	private IronOreFactory(){}

	public static IronOreFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public IronOre get()
	{
		return new IronOre(ProductionCalcFactory.instance().get(ElectricMinerFactory.instance()));
	}
}
