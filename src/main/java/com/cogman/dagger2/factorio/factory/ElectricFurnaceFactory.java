package com.cogman.dagger2.factorio.factory;

import java.util.function.Supplier;

public class ElectricFurnaceFactory implements Supplier<ElectricFurnace>
{
	private ElectricFurnaceFactory(){}

	private static final ElectricFurnaceFactory INSTANCE = new ElectricFurnaceFactory();

	public static ElectricFurnaceFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public ElectricFurnace get()
	{
		return new ElectricFurnace();
	}

}
