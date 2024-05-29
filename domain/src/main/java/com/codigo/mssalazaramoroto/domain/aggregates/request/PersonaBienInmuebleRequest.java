package com.codigo.mssalazaramoroto.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class PersonaBienInmuebleRequest {

    private String bienInmuebleId;
    private String personaId;
    private String estado;




}
