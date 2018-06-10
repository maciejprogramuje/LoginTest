package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OcenyPodsumowanie extends ResponseBase<OcenyPodsumowanie> {
    @JsonProperty("OcenyPrzewidywane")
    private List<OcenaPrzewidywana> ocenyPrzewidywane;
    @JsonProperty("OcenyKlasyfikacyjne")
    private List<OcenaKlasyfikacyjna> ocenyKlasyfikacyjne;
    @JsonProperty("SrednieOcen")
    private List<SredniaOcen> srednieOcen;

    public static class OcenaPrzewidywana {
    }

    public static class OcenaKlasyfikacyjna {
    }

    public static class SredniaOcen {
        @JsonProperty("IdPrzedmiot")
        private Long idPrzedmiot;
        @JsonProperty("SredniaOcen")
        private String sredniaOcen;
        @JsonProperty("SumaPunktow")
        private String sumaPunktow;

        public Long getIdPrzedmiot() {
            return idPrzedmiot;
        }

        public void setIdPrzedmiot(Long idPrzedmiot) {
            this.idPrzedmiot = idPrzedmiot;
        }

        public String getSredniaOcen() {
            return sredniaOcen;
        }

        public void setSredniaOcen(String sredniaOcen) {
            this.sredniaOcen = sredniaOcen;
        }

        public String getSumaPunktow() {
            return sumaPunktow;
        }

        public void setSumaPunktow(String sumaPunktow) {
            this.sumaPunktow = sumaPunktow;
        }
    }

    public List<OcenaPrzewidywana> getOcenyPrzewidywane() {
        return ocenyPrzewidywane;
    }

    public void setOcenyPrzewidywane(List<OcenaPrzewidywana> ocenyPrzewidywane) {
        this.ocenyPrzewidywane = ocenyPrzewidywane;
    }

    public List<OcenaKlasyfikacyjna> getOcenyKlasyfikacyjne() {
        return ocenyKlasyfikacyjne;
    }

    public void setOcenyKlasyfikacyjne(List<OcenaKlasyfikacyjna> ocenyKlasyfikacyjne) {
        this.ocenyKlasyfikacyjne = ocenyKlasyfikacyjne;
    }

    public List<SredniaOcen> getSrednieOcen() {
        return srednieOcen;
    }

    public void setSrednieOcen(List<SredniaOcen> srednieOcen) {
        this.srednieOcen = srednieOcen;
    }
}
