package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Certyfikat {
    @JsonProperty("IsError")
    private boolean isError;
    @JsonProperty("IsMessageForUser")
    private boolean isMessageForUser;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("TokenKey")
    private String tokenKey;
    @JsonProperty("TokenStatus")
    private String tokenStatus;
    @JsonProperty("TokenCert")
    public TokenCert tokenCert;

    public static class TokenCert {
        @JsonProperty("CertyfikatKlucz")
        public String certyfikatKlucz;
        @JsonProperty("CertyfikatKluczSformatowanyTekst")
        public String certyfikatKluczSformatowanyTekst;
        @JsonProperty("CertyfikatDataUtworzenia")
        public Integer certyfikatDataUtworzenia;
        @JsonProperty("CertyfikatDataUtworzeniaSformatowanyTekst")
        public String certyfikatDataUtworzeniaSformatowanyTekst;
        @JsonProperty("CertyfikatPfx")
        public String certyfikatPfx;
        @JsonProperty("GrupaKlientow")
        public String grupaKlientow;
        @JsonProperty("AdresBazowyRestApi")
        public String adresBazowyRestApi;
        @JsonProperty("UzytkownikLogin")
        public String uzytkownikLogin;
        @JsonProperty("UzytkownikNazwa")
        public String uzytkownikNazwa;
        @JsonProperty("TypKonta")
        public Object typKonta;
    }

    @Override
    public String toString() {
        return "Certyfikat{" +
                "isError=" + isError +
                ", isMessageForUser=" + isMessageForUser +
                ", message='" + message + '\'' +
                ", tokenKey='" + tokenKey + '\'' +
                ", tokenStatus='" + tokenStatus + '\'' +
                ", tokenCert=" + tokenCert +
                '}';
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public boolean isMessageForUser() {
        return isMessageForUser;
    }

    public void setMessageForUser(boolean messageForUser) {
        isMessageForUser = messageForUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public String getTokenStatus() {
        return tokenStatus;
    }

    public void setTokenStatus(String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public TokenCert getTokenCert() {
        return tokenCert;
    }

    public void setTokenCert(TokenCert tokenCert) {
        this.tokenCert = tokenCert;
    }
}
