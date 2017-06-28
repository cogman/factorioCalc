package com.cogman.dagger2.factorio;

import com.cogman.dagger2.factorio.factory.*;
import com.cogman.dagger2.factorio.power.Fuel;
import com.cogman.dagger2.factorio.power.PowerSource;
import com.cogman.dagger2.factorio.power.SteamEngine;
import com.cogman.dagger2.factorio.rawmaterial.RawWood;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module
public abstract class FactorioModule {

    @Binds abstract Fuel bindFuel(RawWood rawWood);
    @Binds abstract PowerSource bindPowerSource(SteamEngine steamEngine);

    @Provides @Named("assemblyMachine")
    static ProductionCalc getAssemblyMachineProduction(AssemblingMachine assemblingMachine, PowerSource powerSource) {
        return new ProductionCalc(assemblingMachine, powerSource);
    }

    @Provides @Named("chemPlant")
    static ProductionCalc getChemPlantProduction(ChemicalPlant chemicalPlant, PowerSource powerSource) {
        return new ProductionCalc(chemicalPlant, powerSource);
    }

    @Provides @Named("mining")
    static ProductionCalc getElectricMiner(ElectricMiner electricMiner, PowerSource powerSource) {
        return new ProductionCalc(electricMiner, powerSource);
    }

    @Provides @Named("refinery")
    static ProductionCalc getRefinery(Refinery refinery, PowerSource powerSource) {
        return new ProductionCalc(refinery, powerSource);
    }

    @Provides @Named("pumpJack")
    static ProductionCalc getPumpJack(PumpJack pumpJack, PowerSource powerSource) {
        return new ProductionCalc(pumpJack, powerSource);
    }
}
