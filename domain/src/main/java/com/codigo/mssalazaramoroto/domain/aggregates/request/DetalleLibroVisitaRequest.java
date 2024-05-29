package com.codigo.mssalazaramoroto.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class DetalleLibroVisitaRequest {

    private Long id;
    private String observacionesPersonaVisitante;
    private Boolean estadoVisitante;
    private String estado;
}
