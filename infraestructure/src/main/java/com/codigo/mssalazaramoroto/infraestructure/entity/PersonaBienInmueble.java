package com.codigo.mssalazaramoroto.infraestructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Getter;

import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "persona_bien_inmueble")
public class PersonaBienInmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estado", nullable = true)
    private String estado;

    @Column(name = "usuario_creacion", nullable = true)
    private String usuarioCreacion;

    @Column(name = "fecha_creacion", nullable = true)
    private Timestamp fechaCreacion;

    @Column(name = "usuario_modificacion", nullable = true)
    private String usuarioModificacion;

    @Column(name = "fecha_modificacion", nullable = true)
    private Timestamp fechaModificacion;

    @Column(name = "usuario_actualizacion", nullable = true)
    private String usuarioActualizacion;

    @Column(name = "fecha_actualizacion", nullable = true)
    private Timestamp fechaActualizacion;

    @Column(name = "usuario_eliminacion", nullable = true)
    private String usuarioEliminacion;

    @Column(name = "fecha_eliminacion", nullable = true)
    private Timestamp fechaEliminacion;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bien_inmueble_id", nullable = false)
    private BienInmueble bienInmueble;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;
}
