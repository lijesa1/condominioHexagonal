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

    @Column(name = "num_comercio")
    private String numComercio;

    @Column(name = "en_uso", nullable = false)
    private Boolean enUso;

    @Column(name = "en_alquiler", nullable = false)
    private Boolean enAlquiler;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "usua_crea")
    private String usuaCrea;

    @Column(name = "date_create")
    private Timestamp dateCreate;

    @Column(name = "usua_modif")
    private String usuaModif;

    @Column(name = "date_modif")
    private Timestamp dateModif;

    @Column(name = "usua_delet")
    private String usuaDelet;

    @Column(name = "date_delet")
    private Timestamp dateDelet;

    @ManyToOne(targetEntity = TipoBienInmueble.class)
    private TipoBienInmueble tipoBienInmueble;


}