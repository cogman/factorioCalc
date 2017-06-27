package com.cogman.dagger2.factorio.science;

import com.cogman.dagger2.factorio.factory.ProductionCalc;
import com.cogman.dagger2.factorio.intermediate.Battery;
import com.cogman.dagger2.factorio.intermediate.CopperCable;
import com.cogman.dagger2.factorio.intermediate.ProcessingUnit;
import com.cogman.dagger2.factorio.intermediate.SpeedModule;
import java.util.function.Supplier;

public class HighTechSciencePackFactory implements Supplier<HighTechSciencePack>
{
	private final Supplier<ProductionCalc> productionCalcSupplier;
	private final Supplier<Battery> batterySupplier;
	private final Supplier<CopperCable> copperCableSupplier;
	private final Supplier<ProcessingUnit> processingUnitSupplier;
	private final Supplier<SpeedModule> speedModuleSupplier;

	public HighTechSciencePackFactory(Supplier<ProductionCalc> productionCalcSupplier, Supplier<Battery> batterySupplier, Supplier<CopperCable> copperCableSupplier, Supplier<ProcessingUnit> processingUnitSupplier, Supplier<SpeedModule> speedModuleSupplier)
	{
		this.productionCalcSupplier = productionCalcSupplier;
		this.batterySupplier = batterySupplier;
		this.copperCableSupplier = copperCableSupplier;
		this.processingUnitSupplier = processingUnitSupplier;
		this.speedModuleSupplier = speedModuleSupplier;
	}

	@Override
	public HighTechSciencePack get()
	{
		return new HighTechSciencePack(productionCalcSupplier.get(), batterySupplier.get(), copperCableSupplier.get(), processingUnitSupplier.get(), speedModuleSupplier.get());
	}
}
