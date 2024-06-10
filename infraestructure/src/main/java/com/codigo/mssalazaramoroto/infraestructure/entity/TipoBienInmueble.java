package com.codigo.mssalazaramoroto.infraestructure.entity;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tipo_bien_inmueble")
public class TipoBienInmueble {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

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
}