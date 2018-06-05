package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by maciekmm on 9/12/16.
 */
public class Uczniowie extends ResponseBase<List<Uczniowie.Uczen>> {
    public class Uczen {
        @SerializedName("IdOkresKlasyfikacyjny")
        public Integer idOkresKlasyfikacyjny;
        @SerializedName("OkresPoziom")
        public Integer okresPoziom;
        @SerializedName("OkresNumer")
        public Integer okresNumer;
        @SerializedName("OkresDataOd")
        public Integer okresDataOd;
        @SerializedName("OkresDataDo")
        public Integer okresDataDo;
        @SerializedName("OkresDataOdTekst")
        public String okresDataOdTekst;
        @SerializedName("OkresDataDoTekst")
        public String okresDataDoTekst;
        @SerializedName("IdJednostkaSprawozdawcza")
        public Integer idJednostkaSprawozdawcza;
        @SerializedName("JednostkaSprawozdawczaSkrot")
        public String jednostkaSprawozdawczaSkrot;
        @SerializedName("JednostkaSprawozdawczaNazwa")
        public String jednostkaSprawozdawczaNazwa;
        @SerializedName("JednostkaSprawozdawczaSymbol")
        public String jednostkaSprawozdawczaSymbol;
        @SerializedName("IdJednostka")
        public Integer idJednostka;
        @SerializedName("JednostkaNazwa")
        public String jednostkaNazwa;
        @SerializedName("JednostkaSkrot")
        public String jednostkaSkrot;
        @SerializedName("OddzialSymbol")
        public String oddzialSymbol;
        @SerializedName("OddzialKod")
        public String oddzialKod;
        @SerializedName("UzytkownikRola")
        public String uzytkownikRola;
        @SerializedName("UzytkownikLogin")
        public String uzytkownikLogin;
        @SerializedName("UzytkownikLoginId")
        public Integer uzytkownikLoginId;
        @SerializedName("UzytkownikNazwa")
        public String uzytkownikNazwa;
        @SerializedName("Id")
        public Integer id;
        @SerializedName("IdOddzial")
        public Integer idOddzial;
        @SerializedName("Imie")
        public String imie;
        @SerializedName("Imie2")
        public String imie2;
        @SerializedName("Nazwisko")
        public String nazwisko;
        @SerializedName("Pseudonim")
        public Object pseudonim;
        @SerializedName("UczenPlec")
        public Integer uczenPlec;
        @SerializedName("Pozycja")
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
