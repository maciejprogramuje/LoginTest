package com.maciejprogramuje.facebook.logintest.api.certificate;

public class CertificateReadyEvent {
    private final String certyfikatKlucz;
    private final String certyfikatPfx;
    private final String uzytkownikNazwa;

    public CertificateReadyEvent(String certyfikatKlucz, String certyfikatPfx, String uzytkownikNazwa) {
        this.certyfikatKlucz = certyfikatKlucz;
        this.certyfikatPfx = certyfikatPfx;
        this.uzytkownikNazwa = uzytkownikNazwa;
    }

    public String getCertyfikatKlucz() {
        return certyfikatKlucz;
    }

    public String getCertyfikatPfx() {
        return certyfikatPfx;
    }

    public String getUzytkownikNazwa() {
        return uzytkownikNazwa;
    }
}
