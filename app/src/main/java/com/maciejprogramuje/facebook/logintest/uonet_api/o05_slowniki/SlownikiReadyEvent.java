package com.maciejprogramuje.facebook.logintest.uonet_api.o05_slowniki;

import com.maciejprogramuje.facebook.logintest.uonet_api.models.Slowniki;

public class SlownikiReadyEvent {
    private final Slowniki slowniki;

    public SlownikiReadyEvent(Slowniki slowniki) {
        this.slowniki = slowniki;
    }

    public Slowniki getSlowniki() {
        return slowniki;
    }
}
