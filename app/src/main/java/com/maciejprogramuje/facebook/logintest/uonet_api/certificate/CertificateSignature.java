package com.maciejprogramuje.facebook.logintest.uonet_api.certificate;

import android.util.Base64;

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


    public static String generate(byte[] contents, final InputStream cert) {
        try {
            final KeyStore instance = KeyStore.getInstance(CERT_TYPE);
            instance.load(cert, PASSWORD.toCharArray());
            final PrivateKey privateKey = (PrivateKey) instance.getKey(CONTAINER_NAME, PASSWORD.toCharArray());
            final Signature instance2 = Signature.getInstance(ALGORITHM_NAME);
            instance2.initSign(privateKey);
            instance2.update(contents);
            return Base64.encodeToString(instance2.sign(), Base64.NO_WRAP);
        } catch (KeyStoreException | IOException | CertificateException | NoSuchAlgorithmException | UnrecoverableKeyException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return null;
    }
}
