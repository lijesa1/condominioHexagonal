package com.codigo.mssalazaramoroto.domain.aggregates.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

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
    private String usuarioCreacion;
    private Timestamp fechaCreacion;
    private String usuarioModificacion;
    private Timestamp fechaModificacion;
    private String usuarioActualizacion;
    private Timestamp fechaActualizacion;
    private String usuarioEliminacion;
    private Timestamp fechaEliminacion;

}
