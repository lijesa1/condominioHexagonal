package com.codigo.mssalazaramoroto.infraestructure.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")

public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombres", nullable = false)
    private String nombre;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno", nullable = false)
    private String apellidoMaterno;

    @Column(name = "celular", nullable = false)
    @Size(min = 9)
    @Size(max = 9)
    private String celular;

    @Column(name = "email", nullable = false)
    @Email
    private String email;

    @Column(name = "num_documento", nullable = false)
    @Size(min = 8)
    @Size(max = 8)
    private String numDocumento;

    @Column(name = "fecha_nac", nullable = false)
    private Date fechaNac;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    @Size(min = 8)
    private String password;

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
    @ManyToOne(targetEntity = TipoDocumento.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "tipo_documento_id")
    private TipoDocumento tipoDocumento;

    @ManyToOne(targetEntity = TipoPersona.class)
    @JoinColumn(name = "tipo_persona_id")
    private TipoPersona tipoPersona;


    /*@OneToMany(mappedBy = "persona", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Set<PersonaBienInmueble> personaBienInmuebles;

    @OneToMany(targetEntity = LibroVisita.class, fetch = FetchType.LAZY, mappedBy = "persona")
    private List<LibroVisita> libroVisitas;

    @OneToMany(mappedBy = "persona", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Set<DetalleLibroVisita> detalleLibroVisitas;*/

}