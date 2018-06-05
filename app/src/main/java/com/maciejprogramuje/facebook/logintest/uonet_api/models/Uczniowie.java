package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Uczniowie extends ResponseBase<List<Uczniowie.Uczen>> {
    public static class Uczen {
        @JsonProperty("IdOkresKlasyfikacyjny")
        public Integer idOkresKlasyfikacyjny;
        @JsonProperty("OkresPoziom")
        public Integer okresPoziom;
        @JsonProperty("OkresNumer")
        public Integer okresNumer;
        @JsonProperty("OkresDataOd")
        public Integer okresDataOd;
        @JsonProperty("OkresDataDo")
        public Integer okresDataDo;
        @JsonProperty("OkresDataOdTekst")
        public String okresDataOdTekst;
        @JsonProperty("OkresDataDoTekst")
        public String okresDataDoTekst;
        @JsonProperty("IdJednostkaSprawozdawcza")
        public Integer idJednostkaSprawozdawcza;
        @JsonProperty("JednostkaSprawozdawczaSkrot")
        public String jednostkaSprawozdawczaSkrot;
        @JsonProperty("JednostkaSprawozdawczaNazwa")
        public String jednostkaSprawozdawczaNazwa;
        @JsonProperty("JednostkaSprawozdawczaSymbol")
        public String jednostkaSprawozdawczaSymbol;
        @JsonProperty("IdJednostka")
        public Integer idJednostka;
        @JsonProperty("JednostkaNazwa")
        public String jednostkaNazwa;
        @JsonProperty("JednostkaSkrot")
        public String jednostkaSkrot;
        @JsonProperty("OddzialSymbol")
        public String oddzialSymbol;
        @JsonProperty("OddzialKod")
        public String oddzialKod;
        @JsonProperty("UzytkownikRola")
        public String uzytkownikRola;
        @JsonProperty("UzytkownikLogin")
        public String uzytkownikLogin;
        @JsonProperty("UzytkownikLoginId")
        public Integer uzytkownikLoginId;
        @JsonProperty("UzytkownikNazwa")
        public String uzytkownikNazwa;
        @JsonProperty("Id")
        public Integer id;
        @JsonProperty("IdOddzial")
        public Integer idOddzial;
        @JsonProperty("Imie")
        public String imie;
        @JsonProperty("Imie2")
        public String imie2;
        @JsonProperty("Nazwisko")
        public String nazwisko;
        @JsonProperty("Pseudonim")
        public Object pseudonim;
        @JsonProperty("UczenPlec")
        public Integer uczenPlec;
        @JsonProperty("Pozycja")
        public Integer pozycja;

        @Override
        public String toString() {
            return "Uczen{" +
                    "idOkresKlasyfikacyjny=" + idOkresKlasyfikacyjny +
                    ", okresPoziom=" + okresPoziom +
                    ", okresNumer=" + okresNumer +
                    ", okresDataOd=" + okresDataOd +
                    ", okresDataDo=" + okresDataDo +
                    ", okresDataOdTekst='" + okresDataOdTekst + '\'' +
                    ", okresDataDoTekst='" + okresDataDoTekst + '\'' +
                    ", idJednostkaSprawozdawcza=" + idJednostkaSprawozdawcza +
                    ", jednostkaSprawozdawczaSkrot='" + jednostkaSprawozdawczaSkrot + '\'' +
                    ", jednostkaSprawozdawczaNazwa='" + jednostkaSprawozdawczaNazwa + '\'' +
                    ", jednostkaSprawozdawczaSymbol='" + jednostkaSprawozdawczaSymbol + '\'' +
                    ", idJednostka=" + idJednostka +
                    ", jednostkaNazwa='" + jednostkaNazwa + '\'' +
                    ", jednostkaSkrot='" + jednostkaSkrot + '\'' +
                    ", oddzialSymbol='" + oddzialSymbol + '\'' +
                    ", oddzialKod='" + oddzialKod + '\'' +
                    ", uzytkownikRola='" + uzytkownikRola + '\'' +
                    ", uzytkownikLogin='" + uzytkownikLogin + '\'' +
                    ", uzytkownikLoginId=" + uzytkownikLoginId +
                    ", uzytkownikNazwa='" + uzytkownikNazwa + '\'' +
                    ", id=" + id +
                    ", idOddzial=" + idOddzial +
                    ", imie='" + imie + '\'' +
                    ", imie2='" + imie2 + '\'' +
                    ", nazwisko='" + nazwisko + '\'' +
                    ", pseudonim=" + pseudonim +
                    ", uczenPlec=" + uczenPlec +
                    ", pozycja=" + pozycja +
                    '}';
        }
    }
}
