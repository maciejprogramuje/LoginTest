package com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Slowniki extends ResponseBase<Slowniki.Slownik> {
    public static class Slownik {
        @JsonProperty("TimeKey")
        private Integer timeKey;
        @JsonProperty("Nauczyciele")
        private List<Nauczyciel> nauczyciele = new ArrayList<>();
        @JsonProperty("Pracownicy")
        private List<Pracownik> pracownicy = new ArrayList<>();
        @JsonProperty("Przedmioty")
        private List<Przedmiot> przedmioty = new ArrayList<>();
        @JsonProperty("PoryLekcji")
        private List<PoraLekcji> poryLekcji = new ArrayList<>();
        @JsonProperty("KategorieOcen")
        private List<KategoriaOceny> kategorieOcen = new ArrayList<>();
        @JsonProperty("KategorieUwag")
        private List<KategoriaUwagi> kategorieUwag = new ArrayList<>();
        @JsonProperty("KategorieFrekwencji")
        private List<KategoriaFrekwencji> kategorieFrekwencji = new ArrayList<>();
        @JsonProperty("TypyFrekwencji")
        private List<TypFrekwencji> typyFrekwencji = new ArrayList<>();

        public Nauczyciel getNauczyciel(int id) {
            for (int i = 0; i < nauczyciele.size(); i++) {
                if(nauczyciele.get(i).getId() == id) {
                    return nauczyciele.get(i);
                }
            }
            return null;
        }

        public Pracownik getPracownik(int id) {
            for (int i = 0; i < pracownicy.size(); i++) {
                if(pracownicy.get(i).getId() == id) {
                    return pracownicy.get(i);
                }
            }
            return null;
        }

        public Przedmiot getPrzedmiot(int id) {
            for (int i = 0; i < przedmioty.size(); i++) {
                if(przedmioty.get(i).getId() == id) {
                    return przedmioty.get(i);
                }
            }
            return null;
        }

        public KategoriaOceny getKategoriaOceny(int id) {
            for (int i = 0; i < kategorieOcen.size(); i++) {
                if(kategorieOcen.get(i).getId() == id) {
                    return kategorieOcen.get(i);
                }
            }
            return null;
        }

        public KategoriaUwagi getKategoriaUwagi(int id) {
            for (int i = 0; i < kategorieUwag.size(); i++) {
                if(kategorieUwag.get(i).getId() == id) {
                    return kategorieUwag.get(i);
                }
            }
            return null;
        }

        public KategoriaFrekwencji getKategoriaFrekwencji(int id) {
            for (int i = 0; i < kategorieFrekwencji.size(); i++) {
                if(kategorieFrekwencji.get(i).getId() == id) {
                    return kategorieFrekwencji.get(i);
                }
            }
            return null;
        }

        public TypFrekwencji getTypFrekwencji(int id) {
            for (int i = 0; i < typyFrekwencji.size(); i++) {
                if(typyFrekwencji.get(i).getId() == id) {
                    return typyFrekwencji.get(i);
                }
            }
            return null;
        }

        public Integer getTimeKey() {
            return this.timeKey;
        }

        public List<Nauczyciel> getNauczyciele() {
            return this.nauczyciele;
        }

        public List<Pracownik> getPracownicy() {
            return this.pracownicy;
        }

        public List<Przedmiot> getPrzedmioty() {
            return this.przedmioty;
        }

        public List<PoraLekcji> getPoryLekcji() {
            return this.poryLekcji;
        }

        public List<KategoriaOceny> getKategorieOcen() {
            return this.kategorieOcen;
        }

        public List<KategoriaUwagi> getKategorieUwag() {
            return this.kategorieUwag;
        }

        public List<KategoriaFrekwencji> getKategorieFrekwencji() {
            return this.kategorieFrekwencji;
        }

        public List<TypFrekwencji> getTypyFrekwencji() {
            return this.typyFrekwencji;
        }
    }

    public static class Przedmiot {
        @JsonProperty("Id")
        private Integer id;
        @JsonProperty("Nazwa")
        private String nazwa;
        @JsonProperty("Kod")
        private String kod;
        @JsonProperty("Aktywny")
        private Boolean aktywny;
        @JsonProperty("Pozycja")
        private Integer pozycja;

        public Integer getId() {
            return this.id;
        }

        public String getNazwa() {
            return this.nazwa;
        }

        public String getKod() {
            return this.kod;
        }

        public Boolean getAktywny() {
            return this.aktywny;
        }

        public Integer getPozycja() {
            return this.pozycja;
        }
    }

    public static class Pracownik {
        @JsonProperty("Id")
        private Integer id;
        @JsonProperty("Imie")
        private String imie;
        @JsonProperty("Nazwisko")
        private String nazwisko;
        @JsonProperty("Kod")
        private String kod;
        @JsonProperty("Aktywny")
        private Boolean aktywny;
        @JsonProperty("Nauczyciel")
        private Boolean nauczyciel;
        @JsonProperty("LoginId")
        private Integer loginId;

        public Integer getId() {
            return this.id;
        }

        public String getImie() {
            return this.imie;
        }

        public String getNazwisko() {
            return this.nazwisko;
        }

        public String getKod() {
            return this.kod;
        }

        public Boolean getAktywny() {
            return this.aktywny;
        }

        public Boolean getNauczyciel() {
            return this.nauczyciel;
        }

        public Integer getLoginId() {
            return this.loginId;
        }
    }

    public static class PoraLekcji {
        @JsonProperty("Id")
        private Integer id;
        @JsonProperty("Numer")
        private Integer numer;
        @JsonProperty("Poczatek")
        private Integer poczatek;
        @JsonProperty("PoczatekTekst")
        private String poczatekTekst;
        @JsonProperty("Koniec")
        private Integer koniec;
        @JsonProperty("KoniecTekst")
        private String koniecTekst;

        public Integer getId() {
            return this.id;
        }

        public Integer getNumer() {
            return this.numer;
        }

        public Integer getPoczatek() {
            return this.poczatek;
        }

        public String getPoczatekTekst() {
            return this.poczatekTekst;
        }

        public Integer getKoniec() {
            return this.koniec;
        }

        public String getKoniecTekst() {
            return this.koniecTekst;
        }
    }

    public static class Nauczyciel {
        @JsonProperty("Id")
        private Integer id;
        @JsonProperty("Imie")
        private String imie;
        @JsonProperty("Nazwisko")
        private String nazwisko;
        @JsonProperty("Kod")
        private String kod;
        @JsonProperty("Aktywny")
        private Boolean aktywny;
        @JsonProperty("Nauczyciel")
        private Boolean nauczyciel;
        @JsonProperty("LoginId")
        private Integer loginId;

        public Integer getId() {
            return this.id;
        }

        public String getImie() {
            return this.imie;
        }

        public String getNazwisko() {
            return this.nazwisko;
        }

        public String getKod() {
            return this.kod;
        }

        public Boolean getAktywny() {
            return this.aktywny;
        }

        public Boolean getNauczyciel() {
            return this.nauczyciel;
        }

        public Integer getLoginId() {
            return this.loginId;
        }
    }

    public static class KategoriaUwagi {
        @JsonProperty("Id")
        private Integer id;
        @JsonProperty("Nazwa")
        private String nazwa;
        @JsonProperty("Aktywny")
        private Boolean aktywny;

        public Integer getId() {
            return this.id;
        }

        public String getNazwa() {
            return this.nazwa;
        }

        public Boolean getAktywny() {
            return this.aktywny;
        }
    }

    public static class KategoriaOceny {
        @JsonProperty("Id")
        private Integer id;
        @JsonProperty("Kod")
        private String kod;
        @JsonProperty("Nazwa")
        private String nazwa;

        public Integer getId() {
            return this.id;
        }

        public String getKod() {
            return this.kod;
        }

        public String getNazwa() {
            return this.nazwa;
        }
    }

    public static class KategoriaFrekwencji {
        @JsonProperty("Id")
        private Integer id;
        @JsonProperty("Nazwa")
        private String nazwa;
        @JsonProperty("Pozycja")
        private Integer pozycja;
        @JsonProperty("Obecnosc")
        private Boolean obecnosc;
        @JsonProperty("Nieobecnosc")
        private Boolean nieobecnosc;
        @JsonProperty("Zwolnienie")
        private Boolean zwolnienie;
        @JsonProperty("Spoznienie")
        private Boolean spoznienie;
        @JsonProperty("Usprawiedliwione")
        private Boolean usprawiedliwione;
        @JsonProperty("Usuniete")
        private Boolean usuniete;

        public Integer getId() {
            return this.id;
        }

        public String getNazwa() {
            return this.nazwa;
        }

        public Integer getPozycja() {
            return this.pozycja;
        }

        public Boolean getObecnosc() {
            return this.obecnosc;
        }

        public Boolean getNieobecnosc() {
            return this.nieobecnosc;
        }

        public Boolean getZwolnienie() {
            return this.zwolnienie;
        }

        public Boolean getSpoznienie() {
            return this.spoznienie;
        }

        public Boolean getUsprawiedliwione() {
            return this.usprawiedliwione;
        }

        public Boolean getUsuniete() {
            return this.usuniete;
        }
    }

    public static class TypFrekwencji {
        @JsonProperty("Id")
        private Integer id;
        @JsonProperty("Symbol")
        private String symbol;
        @JsonProperty("Nazwa")
        private String nazwa;
        @JsonProperty("Aktywny")
        private Boolean aktywny;
        @JsonProperty("WpisDomyslny")
        private Boolean wpisDomyslny;
        @JsonProperty("IdKategoriaFrek")
        private Integer idKategoriaFrek;

        public Integer getId() {
            return this.id;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public String getNazwa() {
            return this.nazwa;
        }

        public Boolean getAktywny() {
            return this.aktywny;
        }

        public Boolean getWpisDomyslny() {
            return this.wpisDomyslny;
        }

        public Integer getIdKategoriaFrek() {
            return this.idKategoriaFrek;
        }
    }
}
