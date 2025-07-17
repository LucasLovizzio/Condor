package com.condor.technologies.mails;

import java.util.List;

public class FifoOrderStrategy implements OrderStrategy {

    private static final String NAME = "FIFO";

    @Override
    public void ordenar(List<Mail> mails) {
        mails.sort((m1, m2) -> m1.getFecha().compareTo(m2.getFecha()));
    }

    @Override
    public String getName() {
        return NAME;
    }
}
