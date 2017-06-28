package com.cogman.dagger2.factorio.factory;

import java.util.function.Supplier;

public class ElectricMinerFactory implements Supplier<ElectricMiner>
{
	private ElectricMinerFactory(){}

	private static final ElectricMinerFactory INSTANCE = new ElectricMinerFactory();

	public static ElectricMinerFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public ElectricMiner get()
	{
		return new ElectricMiner();
	}
}
