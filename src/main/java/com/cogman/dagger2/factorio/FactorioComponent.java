package com.cogman.dagger2.factorio;

import com.cogman.dagger2.factorio.science.HighTechSciencePack;
import dagger.Component;

@Component(modules = FactorioModule.class)
public interface FactorioComponent {
    HighTechSciencePack getHighTechSciencePack();
}
