package com.codigo.mssalazaramoroto.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BienInmuebleRequest {
    private String torre;
    private String pisoTorre;
    private String numDpto;
    private String numEstacionamiento;
    private String numComercio;
    private Boolean enUso;
    private Boolean enAlquiler;
    private String estado;
    private String tipoBienInmueble;
    private String numPlaca;




}
