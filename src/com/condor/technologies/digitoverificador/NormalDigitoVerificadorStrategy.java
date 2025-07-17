package com.condor.technologies.digitoverificador;

public class NormalDigitoVerificadorStrategy implements DigitoVerificadorStrategy {

    private final int[] secuencia = {2, 3, 4, 5, 6, 7};

    @Override
    public int calcular(int numero) {

        if (numero < 0) {   // verifico que el numero no sea negativo.
            throw new IllegalArgumentException("El numero no puede ser negativo");
        }

        int suma = 0;

        // El numero no necesito invertirlo, ya que voy a ir sacando los digitos de derecha a izquierda.

        for (int i = 0; numero != 0  ; i++) {
            int digito = numero % 10;
            numero /= 10;                          // resuelve la suma de digito * numero de la secuencia.
            suma += digito * secuencia[i % secuencia.length];
        }

        return 11 - (suma % 11);    // calcula el digito verificador.

    }

}