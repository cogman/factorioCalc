package com.cogman.dagger2.factorio.rawmaterial;

import com.cogman.dagger2.factorio.factory.ElectricMinerFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import java.util.function.Supplier;

public class CopperOreFactory implements Supplier<CopperOre>
{
	private static final CopperOreFactory INSTANCE = new CopperOreFactory();

	private CopperOreFactory(){}

	public static CopperOreFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public CopperOre get()
	{
		return new CopperOre(ProductionCalcFactory.instance().get(ElectricMinerFactory.instance()));
	}
}
