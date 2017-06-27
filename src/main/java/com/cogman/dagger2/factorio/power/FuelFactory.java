package com.cogman.dagger2.factorio.power;

import com.cogman.dagger2.factorio.rawmaterial.RawWoodFactory;
import java.util.function.Supplier;

public class FuelFactory implements Supplier<Fuel>
{
	private static final FuelFactory INSTANCE = new FuelFactory();

	private FuelFactory(){}

	public static FuelFactory instance(){
		return INSTANCE;
	}

	@Override
	public Fuel get()
	{
		return RawWoodFactory.instance().get();
	}
}
