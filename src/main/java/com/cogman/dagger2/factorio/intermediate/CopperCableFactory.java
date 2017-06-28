package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.AssemblingMachineFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import java.util.function.Supplier;

public class CopperCableFactory implements Supplier<CopperCable>
{
	private static final CopperCableFactory INSTANCE = new CopperCableFactory();

	private CopperCableFactory(){}

	public static CopperCableFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public CopperCable get()
	{
		return new CopperCable(ProductionCalcFactory.instance().get(AssemblingMachineFactory.instance()), CopperPlateFactory.instance().get());
	}
}
