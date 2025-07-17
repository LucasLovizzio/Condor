package com.condor.technologies;

import com.condor.technologies.billetes.Billete;
import com.condor.technologies.billetes.CajaService;
import com.condor.technologies.billetes.MenorCantidadBilletesPagoStrategy;
import com.condor.technologies.billetes.PagoStrategy;
import com.condor.technologies.digitoverificador.DigitoVerificadorService;
import com.condor.technologies.mails.Mail;
import com.condor.technologies.mails.MailOrderService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Servicio de dígito verificador.
        // Descomentar la siguiente línea para ejecutar el servicio de dígito verificador.

        /*DigitoVerificadorService dvs = new DigitoVerificadorService();
        dvs.ejecutar(201012341);*/

        // Servicio de pago con billetes.
        // Descomentar la siguiente sección para ejecutar el servicio de pago con billetes.

        List<Billete> billetes = new ArrayList<>(Arrays.asList(
            new Billete(100, 5),
            new Billete(50, 5),
            new Billete(20, 5),
            new Billete(10, 5),
            new Billete(5, 10),
            new Billete(1, 20)
        ));

        PagoStrategy strategy = new MenorCantidadBilletesPagoStrategy();
        CajaService cs = new CajaService(strategy, billetes);
        int monto = 499;

        cs.ejecutar(monto);

        // Servicio de listado de mails.
        // Descomentar las siguientes lineas para utilizar el servicio de listado de mails

        /*List<Mail> mails = new ArrayList<>(Arrays.asList(
                new Mail("MailA", "A B", new GregorianCalendar(2015, Calendar.FEBRUARY, 1).getTime()),
                new Mail("MailB", "A", new GregorianCalendar(2015, Calendar.MARCH, 5).getTime()),
                new Mail("MailC", "B", new GregorianCalendar(2015, Calendar.APRIL, 6).getTime()),
                new Mail("MailD", "A B", new GregorianCalendar(2015, Calendar.SEPTEMBER, 8).getTime()),
                new Mail("MailE", "C", new GregorianCalendar(2015, Calendar.NOVEMBER, 7).getTime()),
                new Mail("MailF", "A C", new GregorianCalendar(2015, Calendar.DECEMBER, 3).getTime())
        ));

        String ordenamiento = "B-LIFO|!C-FIFO|C-LIFO";

        MailOrderService mos = new MailOrderService();

        mos.ordenarMails(mails, ordenamiento);*/

    }
}