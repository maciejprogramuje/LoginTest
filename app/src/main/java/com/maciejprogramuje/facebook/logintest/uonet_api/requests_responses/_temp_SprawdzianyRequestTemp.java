package com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class _temp_SprawdzianyRequestTemp extends _temp_UczenAwareRequestBase<_temp_Sprawdziany> {

    @JsonProperty("DataPoczatkowa")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataPoczatkowa;
    @JsonProperty("DataKoncowa")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataKoncowa;

    public _temp_SprawdzianyRequestTemp(Date dataPoczatkowa, Date dataKoncowa) {
        this.dataPoczatkowa = dataPoczatkowa;
        this.dataKoncowa = dataKoncowa;
    }

    //@Override
    public String getPath() {
        return "_temp_Sprawdziany";
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
}
