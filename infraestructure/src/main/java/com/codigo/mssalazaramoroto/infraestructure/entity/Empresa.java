package com.codigo.mssalazaramoroto.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "empresa_info")
@Getter
@Setter
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "razonSocial", nullable = false, length = 255)
    private String razonSocial;

    @Column(name = "tipoDocumento", nullable = false, length = 5)
    private String tipoDocumento;

    @Column(name = "numeroDocumento", unique = true, length = 20)
    private String numeroDocumento;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "condicion", nullable = false,length = 50)
    private String condicion;

    @Column(name = "direccion", length = 10485760)
    private String direccion;

    @Column(name = "distrito", length = 100)
    private String distrito;

    @Column(name = "provincia", length = 100)
    private String provincia;

    @Column(name = "departamento", length = 100)
    private String departamento;

    @Column(name = "EsAgenteRetencion", nullable = false, columnDefinition = "boolean default false")
    private boolean esAgenteRetencion;

    @Column(name = "usuaCrea", length = 255)
    private String usuaCrea;

    @Column(name = "dateCreate", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Timestamp dateCreate;

    @Column(name = "usuaModif", length = 255)
    private String usuaModif;

    @Column(name = "dateModif", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Timestamp dateModif;

    @Column(name = "usuaDelet", length = 255)
    private String usuaDelet;

    @Column(name = "dateDelet", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Timestamp dateDelet;
}
