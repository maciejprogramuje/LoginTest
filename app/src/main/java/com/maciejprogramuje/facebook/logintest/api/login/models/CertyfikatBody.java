package com.maciejprogramuje.facebook.logintest.api.login.models;

import com.google.gson.annotations.SerializedName;

public class CertyfikatBody {
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
    private Certyfikat tokenCert;

    public Boolean getError() {
        return this.isError;
    }

    public void setError(Boolean error) {
        this.isError = error;
    }

    public Boolean getMessageForUser() {
        return this.isMessageForUser;
    }

    public void setMessageForUser(Boolean messageForUser) {
        this.isMessageForUser = messageForUser;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTokenKey() {
        return this.tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public String getTokenStatus() {
        return this.tokenStatus;
    }

    public void setTokenStatus(String tokenStatus) {
        this.tokenStatus = tokenStatus;
    }

    public Certyfikat getTokenCert() {
        return this.tokenCert;
    }

    public void setTokenCert(Certyfikat tokenCert) {
        this.tokenCert = tokenCert;
    }

    /**
     * I have no control over field names, I know it's bad.
     */
    public class Certyfikat {
        @SerializedName("CertyfikatKlucz")
        private String certyfikatKlucz;
        @SerializedName("CertyfikatKluczSformatowanyTekst")
        private String certyfikatKluczSformatowanyTekst;
        @SerializedName("CertyfikatDataUtworzenia")
        private Integer certyfikatDataUtworzenia;
        @SerializedName("CertyfikatDataUtworzeniaSformatowanyTekst")
        private String certyfikatDataUtworzeniaSformatowanyTekst;
        @SerializedName("CertyfikatPfx")
        private String certyfikatPfx;
        @SerializedName("GrupaKlientow")
        private String grupaKlientow;
        @SerializedName("AdresBazowyRestApi")
        private String adresBazowyRestApi;
        @SerializedName("UzytkownikLogin")
        private String uzytkownikLogin;
        @SerializedName("UzytkownikNazwa")
        private String uzytkownikNazwa;
        @SerializedName("TypKonta")
        private Object typKonta;

        public String getCertyfikatKlucz() {
            return this.certyfikatKlucz;
        }

        public void setCertyfikatKlucz(String certyfikatKlucz) {
            this.certyfikatKlucz = certyfikatKlucz;
        }

        public String getCertyfikatKluczSformatowanyTekst() {
            return this.certyfikatKluczSformatowanyTekst;
        }

        public void setCertyfikatKluczSformatowanyTekst(String certyfikatKluczSformatowanyTekst) {
            this.certyfikatKluczSformatowanyTekst = certyfikatKluczSformatowanyTekst;
        }

        public Integer getCertyfikatDataUtworzenia() {
            return this.certyfikatDataUtworzenia;
        }

        public void setCertyfikatDataUtworzenia(Integer certyfikatDataUtworzenia) {
            this.certyfikatDataUtworzenia = certyfikatDataUtworzenia;
        }

        public String getCertyfikatDataUtworzeniaSformatowanyTekst() {
            return this.certyfikatDataUtworzeniaSformatowanyTekst;
        }

        public void setCertyfikatDataUtworzeniaSformatowanyTekst(String certyfikatDataUtworzeniaSformatowanyTekst) {
            this.certyfikatDataUtworzeniaSformatowanyTekst = certyfikatDataUtworzeniaSformatowanyTekst;
        }

        public String getCertyfikatPfx() {
            return this.certyfikatPfx;
        }

        public void setCertyfikatPfx(String certyfikatPfx) {
            this.certyfikatPfx = certyfikatPfx;
        }

        public String getGrupaKlientow() {
            return this.grupaKlientow;
        }

        public void setGrupaKlientow(String grupaKlientow) {
            this.grupaKlientow = grupaKlientow;
        }

        public String getAdresBazowyRestApi() {
            return this.adresBazowyRestApi;
        }

        public void setAdresBazowyRestApi(String adresBazowyRestApi) {
            this.adresBazowyRestApi = adresBazowyRestApi;
        }

        public String getUzytkownikLogin() {
            return this.uzytkownikLogin;
        }

        public void setUzytkownikLogin(String uzytkownikLogin) {
            this.uzytkownikLogin = uzytkownikLogin;
        }

        public String getUzytkownikNazwa() {
            return this.uzytkownikNazwa;
        }

        public void setUzytkownikNazwa(String uzytkownikNazwa) {
            this.uzytkownikNazwa = uzytkownikNazwa;
        }

        public Object getTypKonta() {
            return this.typKonta;
        }

        public void setTypKonta(Object typKonta) {
            this.typKonta = typKonta;
        }
    }

    @Override
    public String toString() {
        return "CertyfikatBody{" +
                "isError=" + isError +
                ", isMessageForUser=" + isMessageForUser +
                ", message='" + message + '\'' +
                ", tokenKey='" + tokenKey + '\'' +
                ", tokenStatus='" + tokenStatus + '\'' +
                ", tokenCert=" + tokenCert +
                '}';
    }
}
