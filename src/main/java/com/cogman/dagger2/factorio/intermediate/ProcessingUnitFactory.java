package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.AssemblingMachineFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import java.util.function.Supplier;

public class ProcessingUnitFactory implements Supplier<ProcessingUnit>
{
	private static final ProcessingUnitFactory INSTANCE = new ProcessingUnitFactory();

	private ProcessingUnitFactory(){}

	public static ProcessingUnitFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public ProcessingUnit get()
	{
		return new ProcessingUnit(ProductionCalcFactory.instance().get(AssemblingMachineFactory.instance()), AdvancedCircuitFactory.instance().get(), ElectronicCircuitFactory.instance().get(), SulfuricAcidFactory.instance().get());
	}
}
