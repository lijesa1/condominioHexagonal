package com.codigo.mssalazaramoroto.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaBienInmuebleRequest {
    private Long bienInmuebleId;
    private Long personaId;
    private String estado;
}
