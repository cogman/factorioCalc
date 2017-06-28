package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.AssemblingMachineFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import java.util.function.Supplier;

public class AdvancedCircuitFactory implements Supplier<AdvancedCircuit>
{
	private static final AdvancedCircuitFactory INSTANCE = new AdvancedCircuitFactory();

	private AdvancedCircuitFactory(){}

	public static AdvancedCircuitFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public AdvancedCircuit get()
	{
		return new AdvancedCircuit(ProductionCalcFactory.instance().get(AssemblingMachineFactory.instance()),
				CopperCableFactory.instance().get(),
				ElectronicCircuitFactory.instance().get(),
				PlasticBarFactory.instance().get());
	}
}
