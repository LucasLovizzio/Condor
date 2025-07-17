package com.condor.technologies.billetes;

import java.util.*;

public class Caja {

    private final PagoStrategy strategy;
    private final List<Billete> billetes;

    public Caja(PagoStrategy strategy) {
        this.strategy = strategy;
        this.billetes = new ArrayList<>();
    }

    public Caja(PagoStrategy strategy, List<Billete> billetes) {
        this.strategy = strategy;
        this.billetes = billetes;
    }

    public Map<Integer, Integer> pagar(int monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }
        if (billetes.isEmpty()) {
            throw new IllegalArgumentException("La lista de billetes disponibles no puede ser nula o vacía.");
        }

        return strategy.pagar(billetes, monto);

    }

    public void agregarBilletes(int valor, int cantidad) {   // no lo pruebo, ya que no es parte del ejercicio, pero lo dejo para que se pueda agregar billetes a la caja.
        if (valor <= 0 || cantidad <= 0) {
            throw new IllegalArgumentException("El valor y la cantidad deben ser mayores que cero.");
        }
        else if (billetes.stream().anyMatch(b -> b.getValor() == valor)) {
            billetes.stream()
                    .filter(b -> b.getValor() == valor)
                    .findFirst()
                    .ifPresent(b -> b.setCantidad(b.getCantidad() + cantidad));

        } else {
            billetes.add(new Billete(valor, cantidad));
        }

    }

}
