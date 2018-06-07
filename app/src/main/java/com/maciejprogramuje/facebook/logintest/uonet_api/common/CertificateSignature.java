package com.maciejprogramuje.facebook.logintest.uonet_api.common;

import android.util.Base64;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.RequestAbst;

import java.io.ByteArrayInputStream;
import java.io.IOException;
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

    public static String generate(byte[] pupilsRequest, ByteArrayInputStream certyfikatPfx) {
        try {
            final KeyStore instance = KeyStore.getInstance(CERT_TYPE);
            instance.load(certyfikatPfx, PASSWORD.toCharArray());
            final PrivateKey privateKey = (PrivateKey) instance.getKey(CONTAINER_NAME, PASSWORD.toCharArray());
            final Signature instance2 = Signature.getInstance(ALGORITHM_NAME);
            instance2.initSign(privateKey);
            instance2.update(pupilsRequest);
            return Base64.encodeToString(instance2.sign(), Base64.NO_WRAP);
        } catch (KeyStoreException | IOException | CertificateException | NoSuchAlgorithmException | UnrecoverableKeyException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String generate(RequestAbst requestAbst, String certyfikatPfx) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            byte[] bytes = mapper.writeValueAsBytes(requestAbst);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(certyfikatPfx, Base64.NO_WRAP));


            final KeyStore instance = KeyStore.getInstance(CERT_TYPE);
            instance.load(byteArrayInputStream, PASSWORD.toCharArray());
            final PrivateKey privateKey = (PrivateKey) instance.getKey(CONTAINER_NAME, PASSWORD.toCharArray());
            final Signature instance2 = Signature.getInstance(ALGORITHM_NAME);
            instance2.initSign(privateKey);
            instance2.update(bytes);
            return Base64.encodeToString(instance2.sign(), Base64.NO_WRAP);
        } catch (KeyStoreException | IOException | CertificateException | NoSuchAlgorithmException | UnrecoverableKeyException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return null;
    }



}
