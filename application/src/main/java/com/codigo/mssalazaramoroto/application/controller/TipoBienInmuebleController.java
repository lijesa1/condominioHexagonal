package com.codigo.mssalazaramoroto.application.controller;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.TipoBienInmuebleServiceIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ms-condominio/v1/tipoBienInmueble")
@AllArgsConstructor

@Tag(
        name = "Api de Tipo Bien Inmueble",
        description = "Esta api permite registrar, buscar, actualizar y desactivar una Tipo Bien Inmueble"
)
public class TipoBienInmuebleController {
    private final TipoBienInmuebleServiceIn tipoBienInmuebleServiceIn;

    @PostMapping

    @Operation(
            summary = "Registrar un Tipo Bien Inmueble en base de datos",
            description = "Para usar endPoint debes enviar un objeto Tipo Bien Inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Tipo Bien Inmueble ")
            }
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa registro exitoso",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTTP STATUS 201 significa que se creó  de manera exitosa",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP STATUS 400 Bad Request",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<BaseResponse> registrar(@Valid @RequestBody TipoBienInmuebleRequest tipoBienInmuebleRequest) {
        return tipoBienInmuebleServiceIn.crearTipoBienInmuebleServiceIn(tipoBienInmuebleRequest);
    }

    @GetMapping
    @Operation(
            summary = "Obtener todos los Tipo Bien Inmueble",
            description = "Para usar endPoint debes enviar un objeto Tipo Bien Inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Tipo Bien Inmueble ")
            }
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa registro exitoso",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTTP STATUS 201 significa que se creó  de manera exitosa",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP STATUS 400 Bad Request",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<BaseResponse> buscarTipoBienInmueble() {
        return tipoBienInmuebleServiceIn.obtenerTodosIn();
    }

    @GetMapping("/{id}")

    @Operation(
            summary = "Buscar Tipo Bien Inmueble por id",
            description = "Para usar endPoint debes enviar un objeto Tipo Bien Inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Tipo Bien Inmueble ")
            }
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa registro exitoso",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTTP STATUS 201 significa que se creó  de manera exitosa",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP STATUS 400 Bad Request",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<BaseResponse> buscarTipoBienInmuebleById(@PathVariable Long id) {
        return tipoBienInmuebleServiceIn.buscarPorIdIn(id);
    }

    @PutMapping("/{id}")

    @Operation(
            summary = "Actualizar un Tipo Bien Inmueble en base de datos",
            description = "Para usar endPoint debes enviar un objeto Tipo Bien Inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Tipo Bien Inmueble ")
            }
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa registro exitoso",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTTP STATUS 201 significa que se creó  de manera exitosa",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP STATUS 400 Bad Request",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<BaseResponse> actualizar(@PathVariable Long id, @Valid @RequestBody TipoBienInmuebleRequest tipoBienInmuebleRequest) {
        return tipoBienInmuebleServiceIn.actualizarIn(id, tipoBienInmuebleRequest);
    }

    @DeleteMapping("/{id}")

    @Operation(
            summary = "Eliminar un Tipo Bien Inmueble en base de datos",
            description = "Para usar endPoint debes enviar un objeto Tipo Bien Inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Tipo Bien Inmueble ")
            }
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP STATUS 200 significa registro exitoso",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTTP STATUS 201 significa que se creó  de manera exitosa",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP STATUS 400 Bad Request",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<BaseResponse> eliminar(@PathVariable Long id) {
        return tipoBienInmuebleServiceIn.eliminarIn(id);
    }
}
