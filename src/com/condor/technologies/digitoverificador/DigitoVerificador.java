package com.condor.technologies.digitoverificador;

public class DigitoVerificador {

    private final DigitoVerificadorStrategy strategy;

    public DigitoVerificador(DigitoVerificadorStrategy strategy) {
        this.strategy = strategy;
    }

    public int calcular(int numero) {
        return strategy.calcular(numero);
    }

}
