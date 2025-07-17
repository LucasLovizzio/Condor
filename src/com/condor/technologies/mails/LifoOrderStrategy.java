package com.condor.technologies.mails;

import java.util.List;

public class LifoOrderStrategy implements OrderStrategy {

    private static final String NAME = "LIFO";

    @Override
    public void ordenar(List<Mail> mails) {
        mails.sort((m1, m2) -> m2.getFecha().compareTo(m1.getFecha()));
    }

    @Override
    public String getName() {
        return NAME;
    }

}
