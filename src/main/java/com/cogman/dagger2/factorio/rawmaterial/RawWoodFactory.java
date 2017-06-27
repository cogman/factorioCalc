package com.cogman.dagger2.factorio.rawmaterial;

import java.util.function.Supplier;

public class RawWoodFactory implements Supplier<RawWood>
{
	private static RawWoodFactory INSTANCE = new RawWoodFactory();

	private RawWoodFactory(){}

	public static RawWoodFactory instance() {
		return INSTANCE;
	}

	@Override
	public RawWood get()
	{
		return new RawWood();
	}

}
