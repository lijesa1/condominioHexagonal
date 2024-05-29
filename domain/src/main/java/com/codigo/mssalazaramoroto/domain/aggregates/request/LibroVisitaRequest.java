package com.codigo.mssalazaramoroto.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LibroVisitaRequest {

    private Long id;
    private Date fechaVisita;

    private String usuarioCreacion;
    private String observacionesLibroVisita;
    private Long PersonaRegistradorId;

}
