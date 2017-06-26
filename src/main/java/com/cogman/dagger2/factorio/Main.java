package com.cogman.dagger2.factorio;

import com.cogman.dagger2.factorio.science.HighTechSciencePack;

public class Main {
    public static void main(String[] varargs) {
        FactorioComponent factorioComponent = DaggerFactorioComponent.create();
        HighTechSciencePack highTechSciencePack = factorioComponent.getHighTechSciencePack();
        System.out.println(highTechSciencePack.getRequirements());
    }
}
