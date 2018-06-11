package com.maciejprogramuje.facebook.logintest.uonet_api.log2_certyfikat;

public class CertyfikatReadyEvent {
    private final String certyfikatPfx;
    private final String certyfikatKlucz;

    public CertyfikatReadyEvent(String certyfikatPfx, String certyfikatKlucz) {
        this.certyfikatPfx = certyfikatPfx;
        this.certyfikatKlucz = certyfikatKlucz;
    }

    public String getCertyfikatPfx() {
        return certyfikatPfx;
    }

    public String getCertyfikatKlucz() {
        return certyfikatKlucz;
    }
}
