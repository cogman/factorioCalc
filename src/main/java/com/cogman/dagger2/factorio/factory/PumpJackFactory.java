package com.cogman.dagger2.factorio.factory;

import java.util.function.Supplier;

public class PumpJackFactory implements Supplier<PumpJack>
{
	private PumpJackFactory(){}

	private static final PumpJackFactory INSTANCE = new PumpJackFactory();

	public static PumpJackFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public PumpJack get()
	{
		return new PumpJack();
	}
}
