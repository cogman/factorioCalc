package com.cogman.dagger2.factorio.science;

import com.cogman.dagger2.factorio.factory.AssemblingMachineFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import com.cogman.dagger2.factorio.intermediate.BatteryFactory;
import com.cogman.dagger2.factorio.intermediate.CopperCableFactory;
import com.cogman.dagger2.factorio.intermediate.ProcessingUnitFactory;
import com.cogman.dagger2.factorio.intermediate.SpeedModuleFactory;
import java.util.function.Supplier;

public class HighTechSciencePackFactory implements Supplier<HighTechSciencePack>
{
	private static final HighTechSciencePackFactory INSTANCE = new HighTechSciencePackFactory();

	private HighTechSciencePackFactory(){}

	public static HighTechSciencePackFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public HighTechSciencePack get()
	{
		return new HighTechSciencePack(ProductionCalcFactory.instance().get(AssemblingMachineFactory.instance()), 
				BatteryFactory.instance().get(),
				CopperCableFactory.instance().get(),
				ProcessingUnitFactory.instance().get(),
				SpeedModuleFactory.instance().get());
	}
}
