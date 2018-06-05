package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.google.gson.annotations.SerializedName;

public class Certyfikat {
    @SerializedName("IsError")
    public boolean isError;
    @SerializedName("IsMessageForUser")
    public boolean isMessageForUser;
    @SerializedName("Message")
    public String message;
    @SerializedName("TokenKey")
    public String tokenKey;
    @SerializedName("TokenStatus")
    public String tokenStatus;
    @SerializedName("TokenCert")
    public TokenCert tokenCert;

    public class TokenCert {
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
}
