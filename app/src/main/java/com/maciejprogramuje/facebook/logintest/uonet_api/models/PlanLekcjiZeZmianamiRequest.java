package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class PlanLekcjiZeZmianamiRequest extends RequestBase<PlanLekcjiZeZmianamiRequest> {
    @JsonProperty("DataPoczatkowa")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataPoczatkowa;
    @JsonProperty("DataKoncowa")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataKoncowa;
    @JsonProperty("IdOkresKlasyfikacyjny")
    private Integer idOkresKlasyfikacyjny;
    @JsonProperty("IdUczen")
    private Integer idUczen;
    @JsonProperty("IdOddzial")
    private Integer idOddzial;

    public PlanLekcjiZeZmianamiRequest(Date dataPoczatkowa, Date dataKoncowa, Integer idOkresKlasyfikacyjny, Integer idUczen, Integer idOddzial) {
        this.dataPoczatkowa = dataPoczatkowa;
        this.dataKoncowa = dataKoncowa;
        this.idOkresKlasyfikacyjny = idOkresKlasyfikacyjny;
        this.idUczen = idUczen;
        this.idOddzial = idOddzial;
    }

    public Date getDataPoczatkowa() {
        return this.dataPoczatkowa;
    }

    public void setDataPoczatkowa(Date dataPoczatkowa) {
        this.dataPoczatkowa = dataPoczatkowa;
    }

    public Date getDataKoncowa() {
        return this.dataKoncowa;
    }

    public void setDataKoncowa(Date dataKoncowa) {
        this.dataKoncowa = dataKoncowa;
    }

    public Integer getIdOkresKlasyfikacyjny() {
        return idOkresKlasyfikacyjny;
    }

    public void setIdOkresKlasyfikacyjny(Integer idOkresKlasyfikacyjny) {
        this.idOkresKlasyfikacyjny = idOkresKlasyfikacyjny;
    }

    public Integer getIdUczen() {
        return idUczen;
    }

    public void setIdUczen(Integer idUczen) {
        this.idUczen = idUczen;
    }

    public Integer getIdOddzial() {
        return idOddzial;
    }

    public void setIdOddzial(Integer idOddzial) {
        this.idOddzial = idOddzial;
    }
}
