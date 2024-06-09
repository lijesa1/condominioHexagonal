package com.codigo.mssalazaramoroto.application.controller;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.DetalleLibroVisitaDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.DetalleLibroVisitaRequest;

import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.DetalleLibroVisitaServiceIn;
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
@RequestMapping("/ms-condominio/v1/detalleLibroVisita")
@AllArgsConstructor


@Tag(
        name = "Api de Detalle Libro Visita",
        description = "Esta api permite registrar, buscar, actualizar y desactivar un Detalle Libro Visita"
)
public class DetalleLibroVisitaController {
    private final DetalleLibroVisitaServiceIn detalleLibroVisitaServiceIn;

    @PostMapping

    @Operation(
            summary = "Registrar un detalle_libro_visita en base de datos",
            description = "Para usar endPoint debes enviar un objeto detalle_libro_visita, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de detalle_libro_visita ")
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

    public ResponseEntity<BaseResponse> registrar(@RequestBody DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        return detalleLibroVisitaServiceIn.crearDetalleLibroVisitaServiceIn(detalleLibroVisitaRequest);
    }

    @GetMapping

    @Operation(
            summary = "Buscar todos los detalles libro visita",
            description = "Para usar endPoint debes enviar un objeto detalle_libro_visita, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de detalle_libro_visita ")
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

    public ResponseEntity<BaseResponse> buscarDetalleLibroVisita() {
        return detalleLibroVisitaServiceIn.obtenerTodosIn();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar un detalle libro visita por id",
            description = "Para usar endPoint debes enviar un objeto detalle_libro_visita, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de detalle_libro_visita ")
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
        return detalleLibroVisitaServiceIn.buscarPorIdIn(id);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar un detalle libro visita por id",
            description = "Para usar endPoint debes enviar un objeto detalle_libro_visita, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de detalle_libro_visita ")
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
    public ResponseEntity<BaseResponse> actualizar(@PathVariable Long id, @RequestBody DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        return detalleLibroVisitaServiceIn.actualizarIn(id, detalleLibroVisitaRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar un detalle libro visita por id",
            description = "Para usar endPoint debes enviar un objeto detalle_libro_visita, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de detalle_libro_visita ")
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
        return detalleLibroVisitaServiceIn.eliminarIn(id);
    }
}
