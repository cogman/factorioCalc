package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.AssemblingMachineFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import java.util.function.Supplier;

public class SpeedModuleFactory implements Supplier<SpeedModule>
{
	private static final SpeedModuleFactory INSTANCE = new SpeedModuleFactory();

	private SpeedModuleFactory(){}

	public static SpeedModuleFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public SpeedModule get()
	{
		return new SpeedModule(ProductionCalcFactory.instance().get(AssemblingMachineFactory.instance()), AdvancedCircuitFactory.instance().get(), ElectronicCircuitFactory.instance().get());
	}
}
