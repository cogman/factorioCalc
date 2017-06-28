package com.cogman.dagger2.factorio.intermediate;

import com.cogman.dagger2.factorio.factory.ChemicalPlantFactory;
import com.cogman.dagger2.factorio.factory.ProductionCalcFactory;
import java.util.function.Supplier;

public class SulfuricAcidFactory implements Supplier<SulfuricAcid>
{
	private static final SulfuricAcidFactory INSTANCE = new SulfuricAcidFactory();

	private SulfuricAcidFactory(){}

	public static SulfuricAcidFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public SulfuricAcid get()
	{
		return new SulfuricAcid(ProductionCalcFactory.instance().get(ChemicalPlantFactory.instance()), SulfurFactory.instance().get(), IronPlateFactory.instance().get());
	}
}
