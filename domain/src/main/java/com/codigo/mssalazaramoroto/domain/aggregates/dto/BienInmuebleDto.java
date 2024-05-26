package com.codigo.mssalazaramoroto.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BienInmuebleDto {
    private Long id;
    private String torre;
    private String pisoTorre;
    private String numDpto;
    private String numEstacionamiento;
    private String numComercio;
    private Boolean enUso;
    private Boolean enAlquiler;
    private String estado;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelet;
    private Timestamp dateDelet;
}
