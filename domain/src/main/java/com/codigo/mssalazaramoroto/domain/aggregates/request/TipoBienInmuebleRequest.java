package com.codigo.mssalazaramoroto.domain.aggregates.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TipoBienInmuebleRequest {
    @NotBlank(message = "Por favor ingrese la descripción del TipoBienInmueble")
    @NotNull(message = "El TipoBienInmueble no puede ser nulo")
    @NotEmpty(message = "la descripción del TipoBienInmueble no puede estar vacío")
    private String descripcion;

    @NotBlank(message = "Por favor ingrese el estado del TipoBienInmueble")
    @NotNull(message = "El estado del TipoBienInmueble no puede ser nulo")
    @NotEmpty(message = "El estado del TipoBienInmueble no puede estar vacío")
    private String estado;
}
