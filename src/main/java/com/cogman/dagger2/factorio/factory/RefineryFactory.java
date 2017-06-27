package com.cogman.dagger2.factorio.factory;

import java.util.function.Supplier;

public class RefineryFactory implements Supplier<Refinery>
{
	private RefineryFactory(){}

	private static final RefineryFactory INSTANCE = new RefineryFactory();

	public static RefineryFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public Refinery get()
	{
		return new Refinery();
	}
}
