package com.cogman.dagger2.factorio.factory;

import com.cogman.dagger2.factorio.power.PowerSourceFactory;
import java.util.function.Supplier;

public class ProductionCalcFactory
{
	private ProductionCalcFactory(){}

	private static final ProductionCalcFactory INSTANCE = new ProductionCalcFactory();

	public static ProductionCalcFactory instance()
	{
		return INSTANCE;
	}

	public ProductionCalc get(Supplier<? extends Factory> factoryFactory)
	{
		return new ProductionCalc(factoryFactory.get(), PowerSourceFactory.instance().get());
	}
}
