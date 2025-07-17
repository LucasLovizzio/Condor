package com.condor.technologies.billetes;

import java.util.List;
import java.util.Map;

public interface PagoStrategy {

    Map<Integer, Integer> pagar(List<Billete> billetes, int monto);


}
