package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import com.cogman.dagger2.factorio.factory.RefineryFactory;
import com.cogman.dagger2.factorio.rawmaterial.CrudeOilFactory;
import java.util.function.Supplier;

public class PetroleumGasFactory implements Supplier<PetroleumGas>
{
	private static final PetroleumGasFactory INSTANCE = new PetroleumGasFactory();

	private PetroleumGasFactory(){}

	public static PetroleumGasFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public PetroleumGas get()
	{
		return new PetroleumGas(ProductionCalcFactory.instance().get(RefineryFactory.instance()), CrudeOilFactory.instance().get());
	}
}
