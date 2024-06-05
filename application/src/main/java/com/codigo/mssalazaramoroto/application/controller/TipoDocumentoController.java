package com.codigo.mssalazaramoroto.application.controller;


import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoDocumentoDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoDocumentoRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.TipoDocumentoServiceIn;
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
@RequestMapping("/ms-condominio/v1/tipoDocumento")
@AllArgsConstructor
@Tag(
        name = "Api de Tipo Documento",
        description = "Esta api permite registrar, buscar, actualizar y desactivar una Tipo Documento"
)

public class TipoDocumentoController {

    private final TipoDocumentoServiceIn tipoDocumentoServiceIn;

    @PostMapping

    @Operation(
            summary = "Registrar un Tipo Documento en base de datos",
            description = "Para usar endPoint debes enviar un objeto Tipo Documento, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Tipo Documento ")
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
    public ResponseEntity<BaseResponse>registrar(@RequestBody TipoDocumentoRequest tipoDocumentoRequest){
        return tipoDocumentoServiceIn.crearTipoDocumentoServiceIn(tipoDocumentoRequest);
    }

    @GetMapping

    @Operation(
            summary = "Buscar todos los Tipo Documento",
            description = "Para usar endPoint debes enviar un objeto Tipo Documento, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Tipo Documento ")
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
    public ResponseEntity<BaseResponse> buscarTipoDocumento() {
        return tipoDocumentoServiceIn.obtenerTodosIn();
    }

    @GetMapping("/{id}")

    @Operation(
            summary = "Buscar Tipo Documento por Id",
            description = "Para usar endPoint debes enviar un objeto Tipo Documento, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Tipo Documento ")
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
        return tipoDocumentoServiceIn.buscarPorIdIn(id);
    }

    @PutMapping("/{id}")

    @Operation(
            summary = "Actualizar un Tipo Documento en base de datos",
            description = "Para usar endPoint debes enviar un objeto Tipo Documento, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Tipo Documento ")
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
    public ResponseEntity<BaseResponse> actualizar(@PathVariable Long id, @RequestBody TipoDocumentoRequest tipoDocumentoRequest) {
        return tipoDocumentoServiceIn.actualizarIn(id, tipoDocumentoRequest);
    }

    @DeleteMapping("/{id}")

    @Operation(
            summary = "Eliminar un Tipo Documento en base de datos",
            description = "Para usar endPoint debes enviar un objeto Tipo Documento, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Tipo Documento ")
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
        return tipoDocumentoServiceIn.eliminarIn(id);
    }
}
