package com.maciejprogramuje.facebook.logintest.api.certificate;

import com.maciejprogramuje.facebook.logintest.api.certificate.models.CertificateRequest;
import com.maciejprogramuje.facebook.logintest.api.certificate.models.CertificateResponse;

public class CertyfikatReadyEvent {
    private final CertificateResponse.Certyfikat cerificate;
    private CertificateRequest certificateRequest;
    private String requestSignature;

    public CertyfikatReadyEvent(CertificateResponse.Certyfikat cerificate, String requestSignature) {
        this.cerificate = cerificate;
        this.certificateRequest = certificateRequest;
        this.requestSignature = requestSignature;
    }

    public CertificateRequest getCertificateRequest() {
        return certificateRequest;
    }

    public CertificateResponse.Certyfikat getCertificate() {
        return cerificate;
    }

    public String getRequestSignature() {
        return requestSignature;
    }
}
