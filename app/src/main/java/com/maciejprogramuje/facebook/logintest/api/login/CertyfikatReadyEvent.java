package com.maciejprogramuje.facebook.logintest.api.login;

import com.maciejprogramuje.facebook.logintest.api.login.models.CertyfikatBody;

public class CertyfikatReadyEvent {
    private final CertyfikatBody.Certyfikat certyfikat;

    public CertyfikatReadyEvent(CertyfikatBody.Certyfikat certyfikat) {
        this.certyfikat = certyfikat;
    }

    public CertyfikatBody.Certyfikat getCertyfikat() {
        return certyfikat;
    }
}
