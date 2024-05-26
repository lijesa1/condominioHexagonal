package com.codigo.mssalazaramoroto.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class TipoBienInmuebleDto {

    private Long id;
    private String descripcion;
    private String estado;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelet;
    private Timestamp dateDelet;


}
