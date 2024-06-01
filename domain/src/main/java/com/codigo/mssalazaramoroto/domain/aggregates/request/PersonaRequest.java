package com.codigo.mssalazaramoroto.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class PersonaRequest {
    private String celular;
    private String email;
    private String numDocumento;
    private Date fechaNac;
    private String tipoDocumento;
    private String tipoPersona;
    private String login;
}
