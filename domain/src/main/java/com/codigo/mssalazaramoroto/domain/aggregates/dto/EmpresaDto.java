package com.codigo.mssalazaramoroto.domain.aggregates.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class EmpresaDto {
    private Long id;
    private String razonSocial;
    private String tipoDocumento;
    private String numeroDocumento;
    private Integer estado;
    private String condicion;
    private String direccion;
    private String distrito;
    private String provincia;
    private String departamento;
    private boolean esAgenteRetencion;
    private String usuaCrea;
    private Timestamp dateCreate;
    private String usuaModif;
    private Timestamp dateModif;
    private String usuaDelet;
    private Timestamp dateDelet;
}
