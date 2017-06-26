package com.cogman.dagger2.factorio;

import com.cogman.dagger2.factorio.science.HighTechSciencePack;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] varargs) {
        Injector injector = Guice.createInjector(new FactorioModule());
        HighTechSciencePack sciencePack = injector.getInstance(HighTechSciencePack.class);
        System.out.println(sciencePack.getRequirements());
    }
}
