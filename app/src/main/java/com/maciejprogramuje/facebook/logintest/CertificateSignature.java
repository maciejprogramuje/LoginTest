package com.maciejprogramuje.facebook.logintest;

import android.util.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maciejprogramuje.facebook.logintest.api.certificate.models.CertificateRequest;
import com.maciejprogramuje.facebook.logintest.api.certificate.models.CertificateResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

public class CertificateSignature {
    private static final String ALGORITHM_NAME = "SHA1withRSA";
    private static final String CERT_TYPE = "pkcs12";
    private static final String CONTAINER_NAME = "LoginCert";
    private static final String PASSWORD = "CE75EA598C7743AD9B0B7328DED85B06";


    public static String generate(CertificateRequest certificateRequest, CertificateResponse.Certyfikat cerificate) {
        byte[] contents = setCertificateRequest(certificateRequest);
        InputStream cert = setCertificate(cerificate);

        try {
            final KeyStore instance = KeyStore.getInstance(CERT_TYPE);
            instance.load(cert, PASSWORD.toCharArray());
            final PrivateKey privateKey = (PrivateKey) instance.getKey(CONTAINER_NAME, PASSWORD.toCharArray());
            final Signature instance2 = Signature.getInstance(ALGORITHM_NAME);
            instance2.initSign(privateKey);
            instance2.update(contents);

            byte[] bytes = instance2.sign();
            // Base64 w wersji dla androida, a nie javy
            return Base64.encodeToString(bytes, Base64.NO_WRAP);
        } catch (KeyStoreException | IOException | CertificateException | NoSuchAlgorithmException | UnrecoverableKeyException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] setCertificateRequest(CertificateRequest certificateRequest) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.writeValueAsBytes(certificateRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static InputStream setCertificate(CertificateResponse.Certyfikat certyfikat) {
        return new ByteArrayInputStream(Base64.decode(certyfikat.getCertyfikatPfx(), Base64.NO_WRAP));
    }
}
