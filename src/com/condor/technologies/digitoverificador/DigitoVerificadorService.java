package com.condor.technologies.digitoverificador;

public class DigitoVerificadorService {

    public void ejecutar(int numero) {

        DigitoVerificadorStrategy strategy = new NormalDigitoVerificadorStrategy();
        DigitoVerificador digitoVerificador = new DigitoVerificador(strategy);

        try {
            int resultado = digitoVerificador.calcular(numero);
            System.out.println("El digito verificador es: " + resultado);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

}

