package com.codigo.mssalazaramoroto.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter


public class LibroVisitaDto {

    //OJO REVISAR LOS ATRIBUTOS

    private Long id;
   private Date fechaVisita;
 private String observacionesLibroVisita;
 private String personaRegistradorId;


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
