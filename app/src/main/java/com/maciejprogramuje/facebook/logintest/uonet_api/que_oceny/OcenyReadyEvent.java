package com.maciejprogramuje.facebook.logintest.uonet_api.que_oceny;

import com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses.Oceny;

public class OcenyReadyEvent {
    private final Oceny oceny;

    public OcenyReadyEvent(Oceny oceny) {
        this.oceny = oceny;
    }

    public Oceny getOceny() {
        return oceny;
    }
}
