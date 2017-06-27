package com.cogman.dagger2.factorio.rawmaterial;

import com.cogman.dagger2.factorio.factory.ProductionCalc;
import java.util.function.Supplier;

public class CoalFactory implements Supplier<Coal>
{
	private final Supplier<ProductionCalc> productionCalcSupplier;

	public CoalFactory(Supplier<ProductionCalc> productionCalcSupplier)
	{
		this.productionCalcSupplier = productionCalcSupplier;
	}

	@Override
	public Coal get()
	{
		return new Coal(productionCalcSupplier.get());
	}
}
