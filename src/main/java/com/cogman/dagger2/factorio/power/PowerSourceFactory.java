package com.cogman.dagger2.factorio.power;

import java.util.function.Supplier;

public class PowerSourceFactory implements Supplier<PowerSource>
{
	private static final PowerSourceFactory INSTANCE = new PowerSourceFactory();

	private PowerSourceFactory(){}

	public static PowerSourceFactory instance() {
		return INSTANCE;
	}

	@Override
	public PowerSource get()
	{
		return SteamEngineFactory.instance().get();
	}
}
