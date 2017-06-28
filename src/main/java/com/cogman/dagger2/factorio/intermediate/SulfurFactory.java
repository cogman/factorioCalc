package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.ChemicalPlantFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import java.util.function.Supplier;

public class SulfurFactory implements Supplier<Sulfur>
{
	private static final SulfurFactory INSTANCE = new SulfurFactory();

	private SulfurFactory(){}

	public static SulfurFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public Sulfur get()
	{
		return new Sulfur(ProductionCalcFactory.instance().get(ChemicalPlantFactory.instance()), PetroleumGasFactory.instance().get());
	}
}
