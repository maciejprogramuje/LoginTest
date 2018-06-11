package com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses;

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
    private TokenCert tokenCert;

    public static class TokenCert {
        @JsonProperty("CertyfikatKlucz")
        private String certyfikatKlucz;
        @JsonProperty("CertyfikatKluczSformatowanyTekst")
        private String certyfikatKluczSformatowanyTekst;
        @JsonProperty("CertyfikatDataUtworzenia")
        private Integer certyfikatDataUtworzenia;
        @JsonProperty("CertyfikatDataUtworzeniaSformatowanyTekst")
        private String certyfikatDataUtworzeniaSformatowanyTekst;
        @JsonProperty("CertyfikatPfx")
        private String certyfikatPfx;
        @JsonProperty("GrupaKlientow")
        private String grupaKlientow;
        @JsonProperty("AdresBazowyRestApi")
        private String adresBazowyRestApi;
        @JsonProperty("UzytkownikLogin")
        private String uzytkownikLogin;
        @JsonProperty("UzytkownikNazwa")
        private String uzytkownikNazwa;
        @JsonProperty("TypKonta")
        private Object typKonta;

        public String getCertyfikatKlucz() {
            return certyfikatKlucz;
        }

        public void setCertyfikatKlucz(String certyfikatKlucz) {
            this.certyfikatKlucz = certyfikatKlucz;
        }

        public String getCertyfikatKluczSformatowanyTekst() {
            return certyfikatKluczSformatowanyTekst;
        }

        public void setCertyfikatKluczSformatowanyTekst(String certyfikatKluczSformatowanyTekst) {
            this.certyfikatKluczSformatowanyTekst = certyfikatKluczSformatowanyTekst;
        }

        public Integer getCertyfikatDataUtworzenia() {
            return certyfikatDataUtworzenia;
        }

        public void setCertyfikatDataUtworzenia(Integer certyfikatDataUtworzenia) {
            this.certyfikatDataUtworzenia = certyfikatDataUtworzenia;
        }

        public String getCertyfikatDataUtworzeniaSformatowanyTekst() {
            return certyfikatDataUtworzeniaSformatowanyTekst;
        }

        public void setCertyfikatDataUtworzeniaSformatowanyTekst(String certyfikatDataUtworzeniaSformatowanyTekst) {
            this.certyfikatDataUtworzeniaSformatowanyTekst = certyfikatDataUtworzeniaSformatowanyTekst;
        }

        public String getCertyfikatPfx() {
            return certyfikatPfx;
        }

        public void setCertyfikatPfx(String certyfikatPfx) {
            this.certyfikatPfx = certyfikatPfx;
        }

        public String getGrupaKlientow() {
            return grupaKlientow;
        }

        public void setGrupaKlientow(String grupaKlientow) {
            this.grupaKlientow = grupaKlientow;
        }

        public String getAdresBazowyRestApi() {
            return adresBazowyRestApi;
        }

        public void setAdresBazowyRestApi(String adresBazowyRestApi) {
            this.adresBazowyRestApi = adresBazowyRestApi;
        }

        public String getUzytkownikLogin() {
            return uzytkownikLogin;
        }

        public void setUzytkownikLogin(String uzytkownikLogin) {
            this.uzytkownikLogin = uzytkownikLogin;
        }

        public String getUzytkownikNazwa() {
            return uzytkownikNazwa;
        }

        public void setUzytkownikNazwa(String uzytkownikNazwa) {
            this.uzytkownikNazwa = uzytkownikNazwa;
        }

        public Object getTypKonta() {
            return typKonta;
        }

        public void setTypKonta(Object typKonta) {
            this.typKonta = typKonta;
        }
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
