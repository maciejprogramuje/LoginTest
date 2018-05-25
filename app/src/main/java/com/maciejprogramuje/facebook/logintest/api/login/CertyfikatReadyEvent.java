package com.maciejprogramuje.facebook.logintest.api.login;

import com.maciejprogramuje.facebook.logintest.api.login.models.CertificateBody;
import com.maciejprogramuje.facebook.logintest.api.login.models.CertificateRequest;

public class CertyfikatReadyEvent {
    private final CertificateBody.Certyfikat certyfikat;
    private CertificateRequest certificateRequest;

    public CertyfikatReadyEvent(CertificateBody.Certyfikat certyfikat, CertificateRequest certificateRequest) {
        this.certyfikat = certyfikat;
        this.certificateRequest = certificateRequest;
    }

    public CertificateRequest getCertificateRequest() {
        return certificateRequest;
    }

    public CertificateBody.Certyfikat getCertificate() {
        return certyfikat;
    }
}
