package com.cogman.dagger2.factorio.factory;

import java.util.function.Supplier;

public class AssemblingMachineFactory implements Supplier<AssemblingMachine>
{
	private static final AssemblingMachineFactory INSTANCE = new AssemblingMachineFactory();

	private AssemblingMachineFactory(){}

	public static AssemblingMachineFactory instance()
	{
		return INSTANCE;
	}

	@Override
	public AssemblingMachine get()
	{
		return new AssemblingMachine();
	}
}
