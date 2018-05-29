package com.maciejprogramuje.facebook.logintest.uonet_api.models;

public class UczniowieRequest extends RequestBase<Uczniowie> {
    @Override
    public String getPath() {
        return "ListaUczniow";
    }
}
