package com.maciejprogramuje.facebook.logintest.uonet_api.o03_pupils;

import com.maciejprogramuje.facebook.logintest.uonet_api.models.Uczniowie;

public class PupilsReadyEvent {
    private Uczniowie uczniowie;

    public PupilsReadyEvent(Uczniowie uczniowie) {
        this.uczniowie = uczniowie;
    }

    public Uczniowie getUczniowie() {
        return uczniowie;
    }
}
