package com.codigo.mssalazaramoroto.infraestructure.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
//@Embeddable
public class PersonaBienInmueblePKId implements Serializable {
    private Long bienInmuebleId;
    private Long personaId;
}
