package com.condor.technologies.mails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MailOrder {

    public List<Mail> ordenar(List<Mail> mails, String ordenamiento) {
        List<Mail> resultado = new ArrayList<>();
        Set<String> mailsProcesados = new HashSet<>(); // Para evitar duplicados

        List<OrderStrategy> strategies = new ArrayList<>(Arrays.asList(
                new FifoOrderStrategy(),
                new LifoOrderStrategy()
        ));

        String[] criterios = ordenamiento.split("\\|");

        // Procesar cada criterio
        for (String criterio : criterios) {
            criterio = criterio.trim();
            if (!criterio.matches("^(!?)([A-Z]+)-(FIFO|LIFO)$")) continue;

            String[] partes = criterio.split("-"); // Dividir en flag y estrategia
            boolean esNegacion = partes[0].startsWith("!"); // Verificar si es una negación

            String flag;
            if (esNegacion) { // Si es una negación, eliminar el signo de negación
                flag = partes[0] = partes[0].substring(1); // Eliminar el signo de negación
            } else { // Si no es una negación, simplemente asignar el flag
                flag = partes[0];
            }

            String strategyName = partes[1]; // Nombre de la estrategia (FIFO o LIFO)

            // Encontrar la estrategia correspondiente
            OrderStrategy strategy = strategies.stream()
                    .filter(s -> s.getName().equalsIgnoreCase(strategyName))
                    .findFirst()
                    .orElse(null);

            if (strategy != null) {
                // Filtrar mails que cumplen el criterio y no han sido procesados

                List<Mail> mailsFiltrados = mails.stream()
                        .filter(mail -> !mailsProcesados.contains(mail.getId())) // No procesados antes
                        .filter(mail -> esNegacion != mail.getFlags().contains(flag)) // Filtro los que cumplen o no cumplen el flag dependiendo de la negacion
                        .collect(Collectors.toList());

                // Ordenar los mails filtrados
                strategy.ordenar(mailsFiltrados);

                // Agregar al resultado y marcar como procesados
                resultado.addAll(mailsFiltrados);
                mailsFiltrados.forEach(mail -> mailsProcesados.add(mail.getId()));
            }
        }

        return resultado;
    }
}