package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.ChemicalPlantFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import com.cogman.dagger2.factorio.rawmaterial.CoalFactory;
import java.util.function.Supplier;

public class PlasticBarFactory implements Supplier<PlasticBar>
{
	private static final PlasticBarFactory INSTANCE = new PlasticBarFactory();

	private PlasticBarFactory(){}

	public static PlasticBarFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public PlasticBar get()
	{
		return new PlasticBar(ProductionCalcFactory.instance().get(ChemicalPlantFactory.instance()), CoalFactory.instance().get(), PetroleumGasFactory.instance().get());
	}
}
