package com.codigo.mssalazaramoroto.infraestructure.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "persona_bien_inmueble")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(PersonaBienInmueblePKId.class)
public class PersonaBienInmueble {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Id @Column
    private Long bienInmuebleId;
    @Id @Column
    private Long personaId;

//    @EmbeddedId
//    private PersonaBienInmueblePKId personaBienInmueblePKId;

    @Column(name = "estado", nullable = true)
    private String estado;

    @Column(name = "usuario_creacion", nullable = true)
    private String usuarioCreacion;

    @Column(name = "fecha_creacion", nullable = true)
    private Timestamp fechaCreacion;

    @Column(name = "usuario_actualizacion", nullable = true)
    private String usuarioActualizacion;

    @Column(name = "fecha_actualizacion", nullable = true)
    private Timestamp fechaActualizacion;

    @Column(name = "usuario_eliminacion", nullable = true)
    private String usuarioEliminacion;

    @Column(name = "fecha_eliminacion", nullable = true)
    private Timestamp fechaEliminacion;

/*    @ManyToOne(targetEntity = BienInmueble.class)
    @JoinColumn(name = "bien_inmueble_id", nullable = false)
    private BienInmueble bienInmueble;

    @ManyToOne(targetEntity = Persona.class)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;*/
}
