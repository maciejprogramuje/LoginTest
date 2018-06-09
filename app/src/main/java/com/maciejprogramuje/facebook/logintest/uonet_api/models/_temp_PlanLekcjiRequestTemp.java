package com.maciejprogramuje.facebook.logintest.uonet_api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class _temp_PlanLekcjiRequestTemp extends _temp_UczenAwareRequestBase<_temp_PlanLekcji> {

    @JsonProperty("DataPoczatkowa")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataPoczatkowa;
    @JsonProperty("DataKoncowa")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataKoncowa;
    @JsonIgnore
    private boolean withChanges;

    public _temp_PlanLekcjiRequestTemp(Date dataPoczatkowa, Date dataKoncowa, boolean withChanges) {
        this.dataPoczatkowa = dataPoczatkowa;
        this.dataKoncowa = dataKoncowa;
        this.withChanges = withChanges;
    }

    //@Override
    public String getPath() {
        return this.withChanges ? "PlanLekcjiZeZmianami" : "_temp_PlanLekcji";
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

    public boolean isWithChanges() {
        return this.withChanges;
    }

    public void setWithChanges(boolean withChanges) {
        this.withChanges = withChanges;
    }
}
