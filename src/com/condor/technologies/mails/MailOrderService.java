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

        System.out.println("\n=== MAILS ORDENADOS ===");
        imprimirMails(mailsOrdenados);

        return mailsOrdenados;
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