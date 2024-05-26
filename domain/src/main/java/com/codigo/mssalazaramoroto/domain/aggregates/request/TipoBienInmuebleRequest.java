package com.codigo.mssalazaramoroto.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoBienInmuebleRequest {
    private String descripcion;
    private String estado;
}
