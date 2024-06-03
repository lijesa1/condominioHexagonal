package com.codigo.mssalazaramoroto.domain.aggregates.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TipoBienInmuebleRequest {
    private String descripcion;
    private String estado;
}
