package com.condor.technologies.mails;

import java.util.List;

public interface OrderStrategy {

    void ordenar(List<Mail> mails);
    String getName();

}
