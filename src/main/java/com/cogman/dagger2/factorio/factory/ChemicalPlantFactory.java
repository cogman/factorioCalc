package com.cogman.dagger2.factorio.factory;

import java.util.function.Supplier;

public class ChemicalPlantFactory implements Supplier<ChemicalPlant>
{
	private static final ChemicalPlantFactory INSTANCE = new ChemicalPlantFactory();

	private ChemicalPlantFactory(){}

	public static ChemicalPlantFactory instance() {
		return INSTANCE;
	}

	@Override
	public ChemicalPlant get()
	{
		return new ChemicalPlant();
	}
}
