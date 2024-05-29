package com.codigo.mssalazaramoroto.domain.aggregates.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class PersonaDto {
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String celular;
    private String email;
    private String numDocumento;
    private String tipoDocumento;
    private String tipoPersona;
    private Date fechaNac;
    private String login;
    private String password;


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
