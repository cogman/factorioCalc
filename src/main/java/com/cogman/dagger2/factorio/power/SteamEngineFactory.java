package com.cogman.dagger2.factorio.power;

import java.util.function.Supplier;

public class SteamEngineFactory implements Supplier<SteamEngine>
{
	private static final SteamEngineFactory INSTANCE = new SteamEngineFactory();

	private SteamEngineFactory(){}

	public static SteamEngineFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public SteamEngine get()
	{
		return new SteamEngine(FuelFactory.instance().get());
	}

}
