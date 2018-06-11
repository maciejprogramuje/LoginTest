package com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Uczniowie extends ResponseBase<List<Uczniowie.Uczen>> {
    public static class Uczen {
        @JsonProperty("IdOkresKlasyfikacyjny")
        private Integer idOkresKlasyfikacyjny;
        @JsonProperty("OkresPoziom")
        private Integer okresPoziom;
        @JsonProperty("OkresNumer")
        private Integer okresNumer;
        @JsonProperty("OkresDataOd")
        private Integer okresDataOd;
        @JsonProperty("OkresDataDo")
        private Integer okresDataDo;
        @JsonProperty("OkresDataOdTekst")
        private String okresDataOdTekst;
        @JsonProperty("OkresDataDoTekst")
        private String okresDataDoTekst;
        @JsonProperty("IdJednostkaSprawozdawcza")
        private Integer idJednostkaSprawozdawcza;
        @JsonProperty("JednostkaSprawozdawczaSkrot")
        private String jednostkaSprawozdawczaSkrot;
        @JsonProperty("JednostkaSprawozdawczaNazwa")
        private String jednostkaSprawozdawczaNazwa;
        @JsonProperty("JednostkaSprawozdawczaSymbol")
        private String jednostkaSprawozdawczaSymbol;
        @JsonProperty("IdJednostka")
        private Integer idJednostka;
        @JsonProperty("JednostkaNazwa")
        private String jednostkaNazwa;
        @JsonProperty("JednostkaSkrot")
        private String jednostkaSkrot;
        @JsonProperty("OddzialSymbol")
        private String oddzialSymbol;
        @JsonProperty("OddzialKod")
        private String oddzialKod;
        @JsonProperty("UzytkownikRola")
        private String uzytkownikRola;
        @JsonProperty("UzytkownikLogin")
        private String uzytkownikLogin;
        @JsonProperty("UzytkownikLoginId")
        private Integer uzytkownikLoginId;
        @JsonProperty("UzytkownikNazwa")
        private String uzytkownikNazwa;
        @JsonProperty("Id")
        private Integer id;
        @JsonProperty("IdOddzial")
        private Integer idOddzial;
        @JsonProperty("Imie")
        private String imie;
        @JsonProperty("Imie2")
        private String imie2;
        @JsonProperty("Nazwisko")
        private String nazwisko;
        @JsonProperty("Pseudonim")
        private Object pseudonim;
        @JsonProperty("UczenPlec")
        private Integer uczenPlec;
        @JsonProperty("Pozycja")
        private Integer pozycja;
        @JsonProperty("LoginId")
        private String loginId;

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

        public Integer getIdOkresKlasyfikacyjny() {
            return idOkresKlasyfikacyjny;
        }

        public void setIdOkresKlasyfikacyjny(Integer idOkresKlasyfikacyjny) {
            this.idOkresKlasyfikacyjny = idOkresKlasyfikacyjny;
        }

        public Integer getOkresPoziom() {
            return okresPoziom;
        }

        public void setOkresPoziom(Integer okresPoziom) {
            this.okresPoziom = okresPoziom;
        }

        public Integer getOkresNumer() {
            return okresNumer;
        }

        public void setOkresNumer(Integer okresNumer) {
            this.okresNumer = okresNumer;
        }

        public Integer getOkresDataOd() {
            return okresDataOd;
        }

        public void setOkresDataOd(Integer okresDataOd) {
            this.okresDataOd = okresDataOd;
        }

        public Integer getOkresDataDo() {
            return okresDataDo;
        }

        public void setOkresDataDo(Integer okresDataDo) {
            this.okresDataDo = okresDataDo;
        }

        public String getOkresDataOdTekst() {
            return okresDataOdTekst;
        }

        public void setOkresDataOdTekst(String okresDataOdTekst) {
            this.okresDataOdTekst = okresDataOdTekst;
        }

        public String getOkresDataDoTekst() {
            return okresDataDoTekst;
        }

        public void setOkresDataDoTekst(String okresDataDoTekst) {
            this.okresDataDoTekst = okresDataDoTekst;
        }

        public Integer getIdJednostkaSprawozdawcza() {
            return idJednostkaSprawozdawcza;
        }

        public void setIdJednostkaSprawozdawcza(Integer idJednostkaSprawozdawcza) {
            this.idJednostkaSprawozdawcza = idJednostkaSprawozdawcza;
        }

        public String getJednostkaSprawozdawczaSkrot() {
            return jednostkaSprawozdawczaSkrot;
        }

        public void setJednostkaSprawozdawczaSkrot(String jednostkaSprawozdawczaSkrot) {
            this.jednostkaSprawozdawczaSkrot = jednostkaSprawozdawczaSkrot;
        }

        public String getJednostkaSprawozdawczaNazwa() {
            return jednostkaSprawozdawczaNazwa;
        }

        public void setJednostkaSprawozdawczaNazwa(String jednostkaSprawozdawczaNazwa) {
            this.jednostkaSprawozdawczaNazwa = jednostkaSprawozdawczaNazwa;
        }

        public String getJednostkaSprawozdawczaSymbol() {
            return jednostkaSprawozdawczaSymbol;
        }

        public void setJednostkaSprawozdawczaSymbol(String jednostkaSprawozdawczaSymbol) {
            this.jednostkaSprawozdawczaSymbol = jednostkaSprawozdawczaSymbol;
        }

        public Integer getIdJednostka() {
            return idJednostka;
        }

        public void setIdJednostka(Integer idJednostka) {
            this.idJednostka = idJednostka;
        }

        public String getJednostkaNazwa() {
            return jednostkaNazwa;
        }

        public void setJednostkaNazwa(String jednostkaNazwa) {
            this.jednostkaNazwa = jednostkaNazwa;
        }

        public String getJednostkaSkrot() {
            return jednostkaSkrot;
        }

        public void setJednostkaSkrot(String jednostkaSkrot) {
            this.jednostkaSkrot = jednostkaSkrot;
        }

        public String getOddzialSymbol() {
            return oddzialSymbol;
        }

        public void setOddzialSymbol(String oddzialSymbol) {
            this.oddzialSymbol = oddzialSymbol;
        }

        public String getOddzialKod() {
            return oddzialKod;
        }

        public void setOddzialKod(String oddzialKod) {
            this.oddzialKod = oddzialKod;
        }

        public String getUzytkownikRola() {
            return uzytkownikRola;
        }

        public void setUzytkownikRola(String uzytkownikRola) {
            this.uzytkownikRola = uzytkownikRola;
        }

        public String getUzytkownikLogin() {
            return uzytkownikLogin;
        }

        public void setUzytkownikLogin(String uzytkownikLogin) {
            this.uzytkownikLogin = uzytkownikLogin;
        }

        public Integer getUzytkownikLoginId() {
            return uzytkownikLoginId;
        }

        public void setUzytkownikLoginId(Integer uzytkownikLoginId) {
            this.uzytkownikLoginId = uzytkownikLoginId;
        }

        public String getUzytkownikNazwa() {
            return uzytkownikNazwa;
        }

        public void setUzytkownikNazwa(String uzytkownikNazwa) {
            this.uzytkownikNazwa = uzytkownikNazwa;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getIdOddzial() {
            return idOddzial;
        }

        public void setIdOddzial(Integer idOddzial) {
            this.idOddzial = idOddzial;
        }

        public String getImie() {
            return imie;
        }

        public void setImie(String imie) {
            this.imie = imie;
        }

        public String getImie2() {
            return imie2;
        }

        public void setImie2(String imie2) {
            this.imie2 = imie2;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public void setNazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
        }

        public Object getPseudonim() {
            return pseudonim;
        }

        public void setPseudonim(Object pseudonim) {
            this.pseudonim = pseudonim;
        }

        public Integer getUczenPlec() {
            return uczenPlec;
        }

        public void setUczenPlec(Integer uczenPlec) {
            this.uczenPlec = uczenPlec;
        }

        public Integer getPozycja() {
            return pozycja;
        }

        public void setPozycja(Integer pozycja) {
            this.pozycja = pozycja;
        }

        public String getLoginId() {
            return loginId;
        }

        public void setLoginId(String loginId) {
            this.loginId = loginId;
        }
    }
}
