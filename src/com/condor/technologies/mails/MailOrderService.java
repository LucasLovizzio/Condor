package com.condor.technologies.mails;

import java.util.List;

public class MailOrderService {

    public List<Mail> ordenarMails(List<Mail> mails, String ordenamiento) {
        System.out.println("=== MAILS ORIGINALES ===");
        imprimirMails(mails);

        MailOrder mailOrder = new MailOrder();
        List<Mail> mailsOrdenados = mailOrder.ordenar(mails, ordenamiento);

        System.out.println("\n=== CRITERIO DE ORDENAMIENTO ===");
        System.out.println(ordenamiento);
        explicarCriterios(ordenamiento);

        System.out.println("\n=== MAILS ORDENADOS ===");
        imprimirMails(mailsOrdenados);

        return mailsOrdenados;
    }

    private void explicarCriterios(String ordenamiento) {
        String[] criterios = ordenamiento.split("\\|");

        for (int i = 0; i < criterios.length; i++) {
            String criterio = criterios[i].trim();
            if (criterio.matches("^(!?)([A-Z]+)-(FIFO|LIFO)$")) {
                String[] partes = criterio.split("-");
                boolean esNegacion = partes[0].startsWith("!");
                String flag = esNegacion ? partes[0].substring(1) : partes[0];
                String orden = partes[1];
            }
        }
    }

    private void imprimirMails(List<Mail> mails) {
        if (mails == null || mails.isEmpty()) {
            System.out.println("No hay mails para mostrar.");
            return;
        }

        for (Mail mail : mails) {
            System.out.println(mail);
        }
    }
}