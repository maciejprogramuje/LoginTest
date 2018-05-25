package com.maciejprogramuje.facebook.logintest.api.login;

import android.util.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maciejprogramuje.facebook.logintest.api.login.models.CertificateBody;
import com.maciejprogramuje.facebook.logintest.api.login.models.CertificateRequest;

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

public class RequestSignature {
    private static final String ALGORITHM_NAME = "SHA1withRSA";
    private static final String CERT_TYPE = "pkcs12";
    private static final String CONTAINER_NAME = "LoginCert";
    private static final String PASSWORD = "CE75EA598C7743AD9B0B7328DED85B06";

    private byte[] contents;
    private InputStream cert;

    public String get() {
        try {
            final KeyStore instance = KeyStore.getInstance(CERT_TYPE);
            instance.load(cert, PASSWORD.toCharArray());
            final PrivateKey privateKey = (PrivateKey) instance.getKey(CONTAINER_NAME, PASSWORD.toCharArray());
            final Signature instance2 = Signature.getInstance(ALGORITHM_NAME);
            instance2.initSign(privateKey);
            instance2.update(contents);

            byte[] bytes = instance2.sign();
            // Base64 w wersji dla androida, a nie javy
            return Base64.encodeToString(bytes, Base64.DEFAULT);
            //return Base64.getEncoder().encodeToString(instance2.sign());
        } catch (KeyStoreException | IOException | CertificateException | NoSuchAlgorithmException | UnrecoverableKeyException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setCertificateRequest(CertificateRequest certificateRequest) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            this.contents = mapper.writeValueAsBytes(certificateRequest);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void setCertificate(CertificateBody.Certyfikat certyfikat) {
        this.cert = new ByteArrayInputStream(Base64.decode(certyfikat.getCertyfikatPfx(), Base64.DEFAULT));
    }

    //connection.setRequestProperty("RequestSignatureValue", EncryptionUtils.signContent(bytes, new ByteArrayInputStream(Base64.getDecoder().decode(this.cert.getCertyfikatPfx()))));
}
