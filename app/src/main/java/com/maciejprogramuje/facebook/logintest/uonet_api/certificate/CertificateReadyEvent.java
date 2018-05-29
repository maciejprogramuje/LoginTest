package com.maciejprogramuje.facebook.logintest.uonet_api.certificate;

import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;

public class CertificateReadyEvent {
    private Certyfikat.TokenCertificate cert;

    public CertificateReadyEvent(Certyfikat.TokenCertificate cert) {
        this.cert = cert;
    }

    public Certyfikat.TokenCertificate getCert() {
        return cert;
    }
}
