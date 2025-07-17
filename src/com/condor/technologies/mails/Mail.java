package com.condor.technologies.mails;

import java.util.Date;
import java.util.List;
import java.util.Arrays;
import java.text.SimpleDateFormat;

public class Mail {

    private final String id;
    private final List<String> flags;
    private final Date date;

    public Mail(String id, String flags, Date date) {
        this.id = id;
        this.flags = Arrays.asList(flags.trim().split("\\s+"));
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public List<String> getFlags() {
        return flags;
    }

    public Date getFecha() {
        return date;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        return String.format("%s Flags: %s Fecha de Recepción: %s",
                id, String.join(" ", flags), sdf.format(date));
    }
}