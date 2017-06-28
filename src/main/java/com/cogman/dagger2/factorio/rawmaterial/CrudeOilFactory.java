package com.cogman.dagger2.factorio.rawmaterial;

import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import com.cogman.dagger2.factorio.factory.PumpJackFactory;
import java.util.function.Supplier;

public class CrudeOilFactory implements Supplier<CrudeOil>
{
	private static final CrudeOilFactory INSTANCE = new CrudeOilFactory();

	private CrudeOilFactory(){}

	public static CrudeOilFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public CrudeOil get()
	{
		return new CrudeOil(ProductionCalcFactory.instance().get(PumpJackFactory.instance()));
	}
}
