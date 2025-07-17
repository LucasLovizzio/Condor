package com.condor.technologies.billetes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MenorCantidadBilletesPagoStrategy implements PagoStrategy {

    @Override
    public Map<Integer, Integer> pagar(List<Billete> billetes, int monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }
        if (billetes.isEmpty()) {
            throw new IllegalArgumentException("La lista de billetes disponibles no puede ser nula o vacía.");
        }

        billetes.sort((b1, b2) -> b2.getValor() - b1.getValor());

        Map<Integer, Integer> resultado = new LinkedHashMap<>();

        int restante = monto;

        for (Billete billete : billetes) {

            int valor = billete.getValor();
            int maxDisponibles = billete.getCantidad();
            int cantidadNecesaria = restante / valor;

            int cantidadAUsar = Math.min(cantidadNecesaria, maxDisponibles);

            if (cantidadAUsar > 0) {
                resultado.put(valor, cantidadAUsar);
                restante -= cantidadAUsar * valor;
            }
        }

        if (restante > 0) {
            throw new IllegalArgumentException("No es posible pagar el monto solicitado con los billetes disponibles.");
        }

        return resultado;

    }

}
