package com.codigo.mssalazaramoroto.infraestructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bien_inmueble")
public class BienInmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "torre", nullable = false)
    private String torre;

    @Column(name = "piso_torre", nullable = false)
    private String pisoTorre;

    @Column(name = "num_dpto", nullable = false)
    private String numDpto;

    @Column(name = "num_estacionamiento", nullable = false)
    private String numEstacionamiento;

    @Column(name = "num_comercio", nullable = false)
    private String numComercio;

    @Column(name = "en_uso", nullable = false)
    private Boolean enUso;

    @Column(name = "en_alquiler", nullable = false)
    private Boolean enAlquiler;



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







    @ManyToOne(targetEntity = TipoBienInmueble.class)
    @JoinColumn(name = "tipo_bien_inmueble_id")
    private TipoBienInmueble tipoBienInmueble;


}