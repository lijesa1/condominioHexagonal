package com.codigo.mssalazaramoroto.application.controller;


import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.PersonaBienInmuebleServiceIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-condominio/v1/personaBienInmueble")
@AllArgsConstructor

@Tag(
        name = "Api de Persona Bien Inmueble",
        description = "Esta api permite registrar, buscar, actualizar y desactivar un Persona Bien Inmueble"
)
public class PersonaBienInmuebleController {

    private final PersonaBienInmuebleServiceIn personaBienInmuebleServiceIn;

    @PostMapping
    @Operation(
            summary = "Registrar un Persona Bien Inmueble en base de datos",
            description = "Para usar endPoint debes enviar un objeto Persona Bien Inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Persona Bien Inmueble ")
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

    public ResponseEntity<BaseResponse> registrar(@RequestBody PersonaBienInmuebleRequest personaBienInmuebleRequest) {
        return personaBienInmuebleServiceIn.crearPersonaBienInmuebleServiceIn(personaBienInmuebleRequest);
    }

    @GetMapping

    @Operation(
            summary = "Buscar Persona Bien Inmueble",
            description = "Para usar endPoint debes enviar un objeto Persona Bien Inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Persona Bien Inmueble ")
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
    public ResponseEntity<BaseResponse> buscarPersonaBienInmueble() {
        return personaBienInmuebleServiceIn.obtenerTodosIn();
    }

    @GetMapping("/{id}")

    @Operation(
            summary = "Buscar Persona Bien Inmueble por Id",
            description = "Para usar endPoint debes enviar un objeto Persona Bien Inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Persona Bien Inmueble ")
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
    public ResponseEntity<BaseResponse> buscarPorId(@PathVariable Long id) {
        return personaBienInmuebleServiceIn.buscarPorIdIn(id);
    }

    @PutMapping("/{id}")

    @Operation(
            summary = "Actualizar Persona Bien Inmueble",
            description = "Para usar endPoint debes enviar un objeto Persona Bien Inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Persona Bien Inmueble ")
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
    public ResponseEntity<BaseResponse> actualizar(@PathVariable Long id, @RequestBody PersonaBienInmuebleRequest personaBienInmuebleRequest) {
        return personaBienInmuebleServiceIn.actualizarIn(id, personaBienInmuebleRequest);
    }

    @DeleteMapping("/{id}")

    @Operation(
            summary = "Eliminar Persona Bien Inmueble",
            description = "Para usar endPoint debes enviar un objeto Persona Bien Inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Persona Bien Inmueble ")
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
        return personaBienInmuebleServiceIn.eliminarIn(id);
    }
}
