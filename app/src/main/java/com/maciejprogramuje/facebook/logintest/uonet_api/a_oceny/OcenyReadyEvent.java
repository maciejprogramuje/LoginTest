package com.maciejprogramuje.facebook.logintest.uonet_api.a_oceny;

import com.maciejprogramuje.facebook.logintest.uonet_api.models.Oceny;

public class OcenyReadyEvent {
    private final Oceny oceny;

    public OcenyReadyEvent(Oceny oceny) {
        this.oceny = oceny;
    }

    public Oceny getOceny() {
        return oceny;
    }
}
