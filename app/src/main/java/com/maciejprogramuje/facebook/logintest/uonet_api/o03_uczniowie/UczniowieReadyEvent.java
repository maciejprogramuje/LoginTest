package com.maciejprogramuje.facebook.logintest.uonet_api.o03_uczniowie;

import com.maciejprogramuje.facebook.logintest.uonet_api.models.Uczniowie;

public class UczniowieReadyEvent {
    private Uczniowie uczniowie;

    public UczniowieReadyEvent(Uczniowie uczniowie) {
        this.uczniowie = uczniowie;
    }

    public Uczniowie getUczniowie() {
        return uczniowie;
    }
}
