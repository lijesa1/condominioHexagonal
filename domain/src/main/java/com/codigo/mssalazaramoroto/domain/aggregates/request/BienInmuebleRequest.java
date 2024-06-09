package com.codigo.mssalazaramoroto.domain.aggregates.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BienInmuebleRequest {
    private String torre;
    private String pisoTorre;
    private String numDpto;
    private String numEstacionamiento;
    private String numComercio;
    @NotNull
    private Boolean enUso;
    @NotNull
    private Boolean enAlquiler;
    @NotBlank
    private String estado;

    @NotNull(message = "El campo tipoBienInmueble no puede ser nulo")
    @NotBlank(message = "El campo tipoBienInmueble no puede estar vacio")
    private String tipoBienInmueble;
    private String numPlaca;
}
