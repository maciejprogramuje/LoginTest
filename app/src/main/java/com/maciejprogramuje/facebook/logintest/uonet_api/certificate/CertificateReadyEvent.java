package com.maciejprogramuje.facebook.logintest.uonet_api.certificate;

public class CertificateReadyEvent {
    private final String certyfikatPfx;
    private final String certyfikatKlucz;

    public CertificateReadyEvent(String certyfikatPfx, String certyfikatKlucz) {
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
