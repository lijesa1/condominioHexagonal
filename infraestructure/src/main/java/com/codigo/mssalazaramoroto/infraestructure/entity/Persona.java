package com.codigo.mssalazaramoroto.infraestructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "persona")
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 255)
    private String apellido;

    @Column(name = "tipoDocumento", nullable = false, length = 5)
    private String tipoDocumento;

    @Column(name = "numeroDocumento", nullable = false, unique = true, length = 20)
    private String numeroDocumento;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "direccion", length = 10485760)
    private String direccion;

    @Column(name = "estado", nullable = false)
    private Integer estado;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;
}
