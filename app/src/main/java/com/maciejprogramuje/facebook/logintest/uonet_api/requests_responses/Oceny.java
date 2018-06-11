package com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Oceny extends ResponseBase<List<Oceny.Ocena>> {
    public static class Ocena {
        @JsonProperty("Id")
        private Long id;
        @JsonProperty("Pozycja")
        private Integer Pozycja;
        @JsonProperty("PrzedmiotPozycja")
        private Integer PrzedmiotPozycja;
        @JsonProperty("IdPrzedmiot")
        private Integer IdPrzedmiot;
        @JsonProperty("IdKategoria")
        private Integer IdKategoria;
        @JsonProperty("Wpis")
        private String Wpis;
        @JsonProperty("Wartosc")
        private Double Wartosc;
        @JsonProperty("WagaModyfikatora")
        private Double WagaModyfikatora;
        @JsonProperty("WagaOceny")
        private Double WagaOceny;
        @JsonProperty("Licznik")
        private Integer Licznik;
        @JsonProperty("Mianownik")
        private Integer Mianownik;
        @JsonProperty("Komentarz")
        private String Komentarz;
        @JsonProperty("Waga")
        private String Waga;
        @JsonProperty("Opis")
        private String Opis;
        @JsonProperty("DataUtworzenia")
        private Long DataUtworzenia;
        @JsonProperty("DataUtworzeniaTekst")
        private String DataUtworzeniaTekst;
        @JsonProperty("DataModyfikacji")
        private Long DataModyfikacji;
        @JsonProperty("DataModyfikacjiTekst")
        private String DataModyfikacjiTekst;
        @JsonProperty("IdPracownikD")
        private Integer IdPracownikD;
        @JsonProperty("IdPracownikM")
        private Integer IdPracownikM;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getPozycja() {
            return Pozycja;
        }

        public void setPozycja(Integer pozycja) {
            Pozycja = pozycja;
        }

        public Integer getPrzedmiotPozycja() {
            return PrzedmiotPozycja;
        }

        public void setPrzedmiotPozycja(Integer przedmiotPozycja) {
            PrzedmiotPozycja = przedmiotPozycja;
        }

        public Integer getIdPrzedmiot() {
            return IdPrzedmiot;
        }

        public void setIdPrzedmiot(Integer idPrzedmiot) {
            IdPrzedmiot = idPrzedmiot;
        }

        public Integer getIdKategoria() {
            return IdKategoria;
        }

        public void setIdKategoria(Integer idKategoria) {
            IdKategoria = idKategoria;
        }

        public String getWpis() {
            return Wpis;
        }

        public void setWpis(String wpis) {
            Wpis = wpis;
        }

        public Double getWartosc() {
            return Wartosc;
        }

        public void setWartosc(Double wartosc) {
            Wartosc = wartosc;
        }

        public Double getWagaModyfikatora() {
            return WagaModyfikatora;
        }

        public void setWagaModyfikatora(Double wagaModyfikatora) {
            WagaModyfikatora = wagaModyfikatora;
        }

        public Double getWagaOceny() {
            return WagaOceny;
        }

        public void setWagaOceny(Double wagaOceny) {
            WagaOceny = wagaOceny;
        }

        public Integer getLicznik() {
            return Licznik;
        }

        public void setLicznik(Integer licznik) {
            Licznik = licznik;
        }

        public Integer getMianownik() {
            return Mianownik;
        }

        public void setMianownik(Integer mianownik) {
            Mianownik = mianownik;
        }

        public String getKomentarz() {
            return Komentarz;
        }

        public void setKomentarz(String komentarz) {
            Komentarz = komentarz;
        }

        public String getWaga() {
            return Waga;
        }

        public void setWaga(String waga) {
            Waga = waga;
        }

        public String getOpis() {
            return Opis;
        }

        public void setOpis(String opis) {
            Opis = opis;
        }

        public Long getDataUtworzenia() {
            return DataUtworzenia;
        }

        public void setDataUtworzenia(Long dataUtworzenia) {
            DataUtworzenia = dataUtworzenia;
        }

        public String getDataUtworzeniaTekst() {
            return DataUtworzeniaTekst;
        }

        public void setDataUtworzeniaTekst(String dataUtworzeniaTekst) {
            DataUtworzeniaTekst = dataUtworzeniaTekst;
        }

        public Long getDataModyfikacji() {
            return DataModyfikacji;
        }

        public void setDataModyfikacji(Long dataModyfikacji) {
            DataModyfikacji = dataModyfikacji;
        }

        public String getDataModyfikacjiTekst() {
            return DataModyfikacjiTekst;
        }

        public void setDataModyfikacjiTekst(String dataModyfikacjiTekst) {
            DataModyfikacjiTekst = dataModyfikacjiTekst;
        }

        public Integer getIdPracownikD() {
            return IdPracownikD;
        }

        public void setIdPracownikD(Integer idPracownikD) {
            IdPracownikD = idPracownikD;
        }

        public Integer getIdPracownikM() {
            return IdPracownikM;
        }

        public void setIdPracownikM(Integer idPracownikM) {
            IdPracownikM = idPracownikM;
        }

        @Override
        public String toString() {
            return getDataUtworzeniaTekst() + ", " + getWartosc() + " (" + getWaga() + "), " + getOpis();
        }
    }
}
