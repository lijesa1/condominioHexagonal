package com.codigo.mssalazaramoroto.application.controller;


import com.codigo.mssalazaramoroto.domain.aggregates.dto.LibroVisitaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.LibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.LibroVisitaServiceIn;
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
@RequestMapping("/ms-condominio/v1/libroVisita")
@AllArgsConstructor


@Tag(
        name = "Api de Libro Visita",
        description = "Esta api permite registrar, buscar, actualizar y desactivar un Libro Visita"
)

public class LibroVisitaController {
    private final LibroVisitaServiceIn libroVisitaServiceIn;

    @PostMapping

    @Operation(
            summary = "Registrar un Libro Visita en base de datos",
            description = "Para usar endPoint debes enviar un objeto Libro Visita, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Libro Visita ")
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
    public ResponseEntity<LibroVisitaDto> registrar(@RequestBody LibroVisitaRequest LibroVisitaRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(libroVisitaServiceIn.crearLibroVisitaServiceIn(LibroVisitaRequest));
    }

    @GetMapping

    @Operation(
            summary = "Buscar todos los Libro Visita",
            description = "Para usar endPoint debes enviar un objeto Libro Visita, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Libro Visita ")
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
    public ResponseEntity<List<LibroVisitaDto>> buscarLibroVisita() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(libroVisitaServiceIn.obtenerTodosIn());
    }

    @GetMapping("/{id}")

    @Operation(
            summary = "Buscar un Libro Visita por Id",
            description = "Para usar endPoint debes enviar un objeto Libro Visita, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Libro Visita ")
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
    public ResponseEntity<LibroVisitaDto> buscarLibroVisitaId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(libroVisitaServiceIn.buscarPorIdIn(id).get());
    }

    @PutMapping("/{id}")

    @Operation(
            summary = "Actualizar un Libro Visita por Id",
            description = "Para usar endPoint debes enviar un objeto Libro Visita, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Libro Visita ")
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
    public ResponseEntity<LibroVisitaDto> actualizar(@PathVariable Long id, @RequestBody LibroVisitaRequest libroVisitaRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(libroVisitaServiceIn.actualizarIn(id, libroVisitaRequest));
    }

    @DeleteMapping("/{id}")

    @Operation(
            summary = "Eliminar un Libro Visita por Id",
            description = "Para usar endPoint debes enviar un objeto Libro Visita, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Libro Visita ")
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
    public ResponseEntity<LibroVisitaDto> eliminar(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(libroVisitaServiceIn.eliminarIn(id));
    }
}
