package com.codigo.mssalazaramoroto.domain.aggregates.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class TipoBienInmuebleDto {

    private Long id;
    private String descripcion;
    private String estado;
    private String usuarioCreacion;
    private Timestamp fechaCreacion;
    private String usuarioActualizacion;
    private Timestamp fechaActualizacion;
    private String usuarioEliminacion;
    private Timestamp fechaEliminacion;


}
