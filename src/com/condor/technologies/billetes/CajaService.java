package com.condor.technologies.billetes;

import java.util.List;
import java.util.Map;


public class CajaService {

    private final Caja caja;

    public CajaService(PagoStrategy strategy) {
        this.caja = new Caja(strategy);
    }

    public CajaService(PagoStrategy strategy, List<Billete> billetes) {
        this.caja = new Caja(strategy, billetes);
    }

    public void ejecutar(int monto) {

        try {

            Map<Integer, Integer> resultado = caja.pagar(monto);
            System.out.println("Pago realizado con éxito.");

            System.out.println("Billetes utilizados:");

            for (Map.Entry<Integer, Integer> entry : resultado.entrySet()) {
                System.out.println("$" + entry.getKey() + " - cantidad :  " + entry.getValue());
            }

        } catch (IllegalArgumentException e) {

            System.err.println("Error: " + e.getMessage());

        }
    }

    public void agregarBilletes(int valor, int cantidad) {
        if (valor <= 0 || cantidad <= 0) {
            throw new IllegalArgumentException("El valor y la cantidad deben ser mayores que cero.");
        } else {
            caja.agregarBilletes(valor, cantidad);
        }
    }
}