package com.maciejprogramuje.facebook.logintest.uonet_api.requests_responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OcenyRequest extends RequestBase<OcenyRequest> {
    @JsonProperty("IdOkresKlasyfikacyjny")
    private Integer idOkresKlasyfikacyjny;
    @JsonProperty("IdUczen")
    private Integer idUczen;

    public OcenyRequest(Integer idOkresKlasyfikacyjny, Integer idUczen) {
        this.idOkresKlasyfikacyjny = idOkresKlasyfikacyjny;
        this.idUczen = idUczen;
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
}
