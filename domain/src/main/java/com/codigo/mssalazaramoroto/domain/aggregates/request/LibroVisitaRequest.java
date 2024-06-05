package com.codigo.mssalazaramoroto.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class LibroVisitaRequest {
    private Date fechaVisita;
    private String observacionesLibroVisita;
    private Long personaRegistradorId;
    private String estado;
}
