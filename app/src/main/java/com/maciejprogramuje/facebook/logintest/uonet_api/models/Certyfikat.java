package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.google.gson.annotations.SerializedName;

public class Certyfikat {
    @SerializedName("IsError")
    private boolean isError;
    @SerializedName("IsMessageForUser")
    private boolean isMessageForUser;
    @SerializedName("Message")
    private String message;
    @SerializedName("TokenKey")
    private String tokenKey;
    @SerializedName("TokenStatus")
    private String tokenStatus;
    @SerializedName("TokenCert")
    public TokenCert tokenCert;

    public static class TokenCert {
        @SerializedName("CertyfikatKlucz")
        public String certyfikatKlucz;
        @SerializedName("CertyfikatKluczSformatowanyTekst")
        public String certyfikatKluczSformatowanyTekst;
        @SerializedName("CertyfikatDataUtworzenia")
        public Integer certyfikatDataUtworzenia;
        @SerializedName("CertyfikatDataUtworzeniaSformatowanyTekst")
        public String certyfikatDataUtworzeniaSformatowanyTekst;
        @SerializedName("CertyfikatPfx")
        public String certyfikatPfx;
        @SerializedName("GrupaKlientow")
        public String grupaKlientow;
        @SerializedName("AdresBazowyRestApi")
        public String adresBazowyRestApi;
        @SerializedName("UzytkownikLogin")
        public String uzytkownikLogin;
        @SerializedName("UzytkownikNazwa")
        public String uzytkownikNazwa;
        @SerializedName("TypKonta")
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
