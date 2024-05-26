package com.codigo.mssalazaramoroto.infraestructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
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

    @Column(name = "estado", nullable = false)
    private String estado;


   /* @OneToMany(targetEntity = BienInmueble.class, fetch = FetchType.LAZY, mappedBy = "tipoBienInmueble")
    private List<BienInmueble> bienInmuebleList;
*/

    @Column(name = "usuaCrea", length = 255)
    private String usuaCrea;

    @Column(name = "dateCreate", nullable = true, columnDefinition = "TIMESTAMP WITH TIME ZONE")
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