package com.cogman.dagger2.factorio;

import com.cogman.dagger2.factorio.factory.AssemblingMachine;
import com.cogman.dagger2.factorio.factory.ChemicalPlant;
import com.cogman.dagger2.factorio.factory.ElectricFurnace;
import com.cogman.dagger2.factorio.factory.ElectricMiner;
import com.cogman.dagger2.factorio.factory.Factory;
import com.cogman.dagger2.factorio.factory.ProductionCalc;
import com.cogman.dagger2.factorio.factory.PumpJack;
import com.cogman.dagger2.factorio.factory.Refinery;
import com.cogman.dagger2.factorio.intermediate.AdvancedCircuit;
import com.cogman.dagger2.factorio.intermediate.Battery;
import com.cogman.dagger2.factorio.intermediate.CopperCable;
import com.cogman.dagger2.factorio.intermediate.CopperPlate;
import com.cogman.dagger2.factorio.intermediate.ElectronicCircuit;
import com.cogman.dagger2.factorio.intermediate.IronPlate;
import com.cogman.dagger2.factorio.intermediate.PetroleumGas;
import com.cogman.dagger2.factorio.intermediate.PlasticBar;
import com.cogman.dagger2.factorio.intermediate.ProcessingUnit;
import com.cogman.dagger2.factorio.intermediate.SpeedModule;
import com.cogman.dagger2.factorio.intermediate.Sulfur;
import com.cogman.dagger2.factorio.intermediate.SulfuricAcid;
import com.cogman.dagger2.factorio.power.PowerSource;
import com.cogman.dagger2.factorio.power.SteamEngine;
import com.cogman.dagger2.factorio.rawmaterial.Coal;
import com.cogman.dagger2.factorio.rawmaterial.CopperOre;
import com.cogman.dagger2.factorio.rawmaterial.CrudeOil;
import com.cogman.dagger2.factorio.rawmaterial.IronOre;
import com.cogman.dagger2.factorio.rawmaterial.RawWood;
import com.cogman.dagger2.factorio.science.HighTechSciencePack;
import com.cogman.dagger2.factorio.science.HighTechSciencePackFactory;

public class Main {
    public static void main(String[] varargs) {
		HighTechSciencePack highTechSciencePack = getHighTechScienceTechBad();
		System.out.println(highTechSciencePack.getRequirements());

		highTechSciencePack = getHighTechScienceTechFactory();
		System.out.println(highTechSciencePack.getRequirements());
    }

	public static HighTechSciencePack getHighTechScienceTechBad()
	{
		PowerSource powerSource = new SteamEngine(new RawWood());
		Factory assemblyMachine = new AssemblingMachine();
		ProductionCalc assemblyMachineCalc = new ProductionCalc(assemblyMachine, powerSource);

		Factory checmicalPlant = new ChemicalPlant();
		ProductionCalc chemCalc = new ProductionCalc(checmicalPlant, powerSource);

		Factory furnace = new ElectricFurnace();
		ProductionCalc furnaceCalc = new ProductionCalc(furnace, powerSource);

		Factory pumpJack = new PumpJack();
		ProductionCalc pumpJackCalc = new ProductionCalc(pumpJack, powerSource);

		Factory refinery = new Refinery();
		ProductionCalc refineryCalc = new ProductionCalc(refinery, powerSource);

		Factory electricMiner = new ElectricMiner();
		ProductionCalc electricMinerCalc = new ProductionCalc(electricMiner, powerSource);

		Coal coal = new Coal(electricMinerCalc);
		IronOre ironOre = new IronOre(electricMinerCalc);
		CopperOre copperOre = new CopperOre(electricMinerCalc);
		CrudeOil crudeOil = new CrudeOil(pumpJackCalc);

		IronPlate ironPlate = new IronPlate(furnaceCalc, ironOre);
		CopperPlate copperPlate = new CopperPlate(furnaceCalc, copperOre);
		PetroleumGas petroleumGas = new PetroleumGas(refineryCalc, crudeOil);

		PlasticBar plasticBar = new PlasticBar(chemCalc, coal, petroleumGas);
		CopperCable copperCable = new CopperCable(assemblyMachineCalc, copperPlate);
		Sulfur sulfur = new Sulfur(chemCalc, petroleumGas);

		SulfuricAcid sulfuricAcid = new SulfuricAcid(chemCalc, sulfur, ironPlate);
		ElectronicCircuit electronicCircuit = new ElectronicCircuit(assemblyMachineCalc, copperCable, ironPlate);

		Battery battery = new Battery(chemCalc, copperPlate, ironPlate, sulfuricAcid);
		AdvancedCircuit advancedCircuit = new AdvancedCircuit(assemblyMachineCalc, copperCable, electronicCircuit, plasticBar);

		SpeedModule speedModule = new SpeedModule(assemblyMachineCalc, advancedCircuit, electronicCircuit);
		ProcessingUnit processingUnit = new ProcessingUnit(chemCalc, advancedCircuit, electronicCircuit, sulfuricAcid);

		return new HighTechSciencePack(assemblyMachineCalc, battery, copperCable, processingUnit, speedModule);
	}

	public static HighTechSciencePack getHighTechScienceTechFactory()
	{
		return HighTechSciencePackFactory.instance().get();
	}
}
