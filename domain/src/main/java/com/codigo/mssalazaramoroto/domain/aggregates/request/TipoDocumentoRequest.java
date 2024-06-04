package com.codigo.mssalazaramoroto.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipoDocumentoRequest {
    private String descripcion;
    private String estado;
}
