package com.codigo.mssalazaramoroto.domain.aggregates.dto;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class DetalleLibroVisitaDto {
    private Long id;
    private String observacionesPersonaVisitante;
    private Boolean estadoVisitante;



    private String estado;
    private String usuarioCreacion;
    private Timestamp fechaCreacion;
    private String usuarioModificacion;
    private Timestamp fechaModificacion;
    private String usuarioActualizacion;
    private Timestamp fechaActualizacion;
    private String usuarioEliminacion;
    private Timestamp fechaEliminacion;



}
