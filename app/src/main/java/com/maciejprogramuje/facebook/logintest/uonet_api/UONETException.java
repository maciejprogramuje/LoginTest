package com.maciejprogramuje.facebook.logintest.uonet_api;

import java.io.IOException;

public class UONETException extends IOException {
    public UONETException(String message) {
        super(message);
    }

    public UONETException(String message, Throwable e) {
        super(message, e);
    }
}
