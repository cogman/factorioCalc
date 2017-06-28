package com.cogman.dagger2.factorio;

import com.cogman.dagger2.factorio.factory.*;
import com.cogman.dagger2.factorio.power.Fuel;
import com.cogman.dagger2.factorio.power.PowerSource;
import com.cogman.dagger2.factorio.power.SteamEngine;
import com.cogman.dagger2.factorio.rawmaterial.RawWood;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Named;

public class FactorioModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    Fuel fuel(RawWood rawWood) {
        return rawWood;
    }

    @Provides
    PowerSource powerSource(SteamEngine steamEngine) {
        return steamEngine;
    }

    @Provides
    @Named("assemblyMachine")
    ProductionCalc assemblyMachine(AssemblingMachine assemblingMachine, PowerSource powerSource) {
        return new ProductionCalc(assemblingMachine, powerSource);
    }

    @Provides
    @Named("mining")
    ProductionCalc electricMiner(ElectricMiner electricMiner, PowerSource powerSource) {
        return new ProductionCalc(electricMiner, powerSource);
    }

    @Provides
    @Named("chemPlant")
    ProductionCalc electricMiner(ChemicalPlant chemicalPlant, PowerSource powerSource) {
        return new ProductionCalc(chemicalPlant, powerSource);
    }

    @Provides
    @Named("pumpJack")
    ProductionCalc pumpJack(PumpJack pumpJack, PowerSource powerSource) {
        return new ProductionCalc(pumpJack, powerSource);
    }

    @Provides
    @Named("refinery")
    ProductionCalc refinery(Refinery refinery, PowerSource powerSource) {
        return new ProductionCalc(refinery, powerSource);
    }
}
