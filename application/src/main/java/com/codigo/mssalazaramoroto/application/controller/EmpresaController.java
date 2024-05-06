package com.codigo.mssalazaramoroto.application.controller;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.EmpresaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.EmpresaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.EmpresaServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.in.PersonaServiceIn;
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
@RequestMapping("/ms-salazar-amoroto/v1/empresa")
@AllArgsConstructor
@Tag(
        name = "Api de Empresas",
        description = "Esta api permite registrar, buscar, actualizar y desactivar una empresa"
)
public class EmpresaController {
    private final EmpresaServiceIn empresaServiceIn;


    @PostMapping
    @Operation(
            summary = "Registrar una empresa en base de datos",
            description = "Para usar endPoint debes enviar un objeto empresa, lo cual se va guardar en Base de datos previa validacion, el RUC no deberá esta registrado previamente",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de empresas")
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
    public ResponseEntity<EmpresaDto> registrar(@RequestBody EmpresaRequest requestEmpresa) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(empresaServiceIn.crearEmpresaIn(requestEmpresa));
    }

    @GetMapping
    @Operation(
            summary = "Buscar una empresa por tipo de documento y número de RUC",
            description = "Para usar endPoint debes enviar una petición con los valores tipoDoc y numDoc con los valores RUC y número respectivamente",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de empresas")
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
    public ResponseEntity<EmpresaDto> buscarEmpresaByNumeroDocumento(@RequestParam String numDoc) {
        return ResponseEntity
                .ok(empresaServiceIn.obtenerEmpresaByNumeroDocumentoIn(numDoc).get());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar una empresa por su identificador de clave en la BD",
            description = "Para usar endPoint debes enviar una petición con el id de la empresa que deseas buscar en el endpoint",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de empresas")
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
    public ResponseEntity<EmpresaDto> buscarEmpresaById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.buscarXIdIn(id).get());
    }

    @GetMapping("/empresas")
    @Operation(
            summary = "Retorna un listado de empresas registradas en la BD",
            description = "Para usar endPoint debes enviar una petición con los valores tipoDoc y numDoc con los valores RUC y número respectivamente",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de empresas")
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
    public ResponseEntity<List<EmpresaDto>> buscarEmpresas() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.obtenerTodosIn());
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Actualiza los datos de una empresa registrada",
            description = "Para usar endPoint debes enviar una petición con los valores tipoDoc y numDoc con los valores RUC y número respectivamente",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de empresas")
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
    public ResponseEntity<EmpresaDto> actualizar(@PathVariable Long id, @RequestBody EmpresaRequest empresaRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.actualizarIn(id, empresaRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Desactiva una empresa registrada en la BD",
            description = "Para usar endPoint debes enviar una petición con los valores tipoDoc y numDoc con los valores RUC y número respectivamente",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de empresas")
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
    public ResponseEntity<EmpresaDto> delete(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.deleteIn(id));
    }
}
