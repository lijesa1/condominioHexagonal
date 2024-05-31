package com.codigo.mssalazaramoroto.infraestructure.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "detalle_libro_visita")
public class DetalleLibroVisita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "observaciones_persona_visitante", nullable = false)
    private String observacionesPersonaVisitante;

    @Column(name = "estado_visitante", nullable = false)
    private Boolean estadoVisitante;

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
    @ManyToOne(targetEntity = LibroVisita.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_visita_id", nullable = false)
    private LibroVisita libroVisita;

    @ManyToOne(targetEntity = Persona.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

}
