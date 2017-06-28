package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.AssemblingMachineFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import java.util.function.Supplier;

public class ElectronicCircuitFactory implements Supplier<ElectronicCircuit>
{
	private static final ElectronicCircuitFactory INSTANCE = new ElectronicCircuitFactory();

	private ElectronicCircuitFactory(){}

	public static ElectronicCircuitFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public ElectronicCircuit get()
	{
		return new ElectronicCircuit(ProductionCalcFactory.instance().get(AssemblingMachineFactory.instance()), CopperCableFactory.instance().get(), IronPlateFactory.instance().get());
	}
}
