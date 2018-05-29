package com.maciejprogramuje.facebook.logintest.uonet_api;

import android.util.Base64;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maciejprogramuje.facebook.logintest.uonet_api.certificate.CertificateSignature;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Certyfikat;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.RequestBase;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.UczenAwareRequestBase;
import com.maciejprogramuje.facebook.logintest.uonet_api.models.Uczniowie;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class UONETClient {
    public static final String PUPIL_AWARE_REST_ENDPOINT = "Uczen.v3.Uczen";
    public static final String DEFAULT_REST_ENDPOINT = "Uczen.v3.UczenStart";
    public static final String USER_AGENT = "MobileUserAgent";

    private Certyfikat.TokenCertificate cert;
    private String certyfikatKlucz;
    private String certyfikatPfx;

    public UONETClient() {
    }

    public UONETClient(Certyfikat.TokenCertificate cert) {
        this.cert = cert;
    }


    private <T> T doRequest(String baseURL, RequestBase<T> req) throws MalformedURLException, UONETException {
        URL url = new URL(baseURL + req.getPath());

        HttpURLConnection connection;
        try {
            connection = (HttpURLConnection) url.openConnection();
            req.prepare(connection);

            connection.setRequestProperty("Host", "lekcjaplus.vulcan.net.pl");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("User-Agent", USER_AGENT);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
        } catch (IOException e) {
            throw new UONETException(String.format("Could not establish connection: %s", e.getMessage()), e);
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        byte[] bytes;

        try {
            bytes = mapper.writeValueAsBytes(req);
            if (this.cert != null) {
                certyfikatKlucz = this.cert.getCertyfikatKlucz();
                certyfikatPfx = this.cert.getCertyfikatPfx();

                connection.setRequestProperty("RequestCertificateKey", certyfikatKlucz);
                connection.setRequestProperty("RequestSignatureValue", CertificateSignature.generate(bytes, new ByteArrayInputStream(Base64.decode(certyfikatPfx, Base64.NO_WRAP))));
            }
        } catch (IOException e) {
            throw new UONETException(String.format("Could not serialize data: %s", e.getMessage()), e);
        }

        try (OutputStream stream = connection.getOutputStream()) {
            stream.write(bytes);
        } catch (IOException e) {
            throw new UONETException(String.format("Could not open output stream: %s", e.getMessage()), e);
        }

        try {
            int responseCode = connection.getResponseCode();
            if (responseCode < 200 || responseCode > 206) {
                throw new UONETException(String.format("Invalid status code: %d", responseCode));
            }
        } catch (IOException e) {
            throw new UONETException(String.format("Exception while parsing status code: %s", e.getMessage()), e);
        }

        try (InputStream stream = connection.getInputStream()) {
            /*T resp = mapper.readValue(stream, req.getResponseClass());
            return resp;*/

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = new BufferedReader(new InputStreamReader(stream)).readLine()) != null) {
                result.append(line);
            }
            System.out.println("result -> " + result);
            return null;
        } catch (IOException e) {
            throw new UONETException(String.format("Exception while reading response: %s", e.getMessage()), e);
        }
    }

    public <T> T doRequest(RequestBase<T> req) throws UONETException {
        try {
            return this.doRequest(this.cert.getAdresBazowyRestApi() + "/mobile-api/" + DEFAULT_REST_ENDPOINT + "/", req);
        } catch (MalformedURLException e) {
            throw new UONETException(String.format("Invalid URL: %s", e.getMessage()), e);
        }
    }

    public <T> T doRequest(Uczniowie.Uczen pupil, UczenAwareRequestBase<T> req) throws UONETException {
        try {
            req.setIdOddzial(pupil.getIdOddzial());
            req.setIdOkresKlasyfikacyjny(pupil.getIdOkresKlasyfikacyjny());
            req.setIdUczen(pupil.getId());
            return this.doRequest(this.cert.getAdresBazowyRestApi() + "/" + pupil.getJednostkaSprawozdawczaSymbol() + "/mobile-api/" + PUPIL_AWARE_REST_ENDPOINT + "/", (RequestBase<T>) req);
        } catch (MalformedURLException e) {
            throw new UONETException(String.format("Invalid URL: %s", e.getMessage()), e);
        }
    }

    public Certyfikat.TokenCertificate getCertificate() {
        return this.cert;
    }

    public String getCertyfikatKlucz() {
        return certyfikatKlucz;
    }

    public String getCertyfikatPfx() {
        return certyfikatPfx;
    }
}
