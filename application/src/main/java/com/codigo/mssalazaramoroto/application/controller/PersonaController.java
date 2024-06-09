package com.codigo.mssalazaramoroto.application.controller;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.PersonaServiceIn;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-condominio/v1/persona")
@AllArgsConstructor

@Tag(
        name = "Api de Persona",
        description = "Esta api permite registrar, buscar, actualizar y desactivar una Persona"
)
public class PersonaController {

    private final PersonaServiceIn personaServiceIn;

    @PostMapping

    @Operation(
            summary = "Registrar un Persona en base de datos",
            description = "Para usar endPoint debes enviar un objeto Persona, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Persona ")
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
    public ResponseEntity<BaseResponse> registrar(@Valid  @RequestBody PersonaRequest personaRequest) {
        return personaServiceIn.crearPersonaServiceIn(personaRequest);
    }

    @GetMapping

    @Operation(
            summary = "Buscar todas las Personas",
            description = "Para usar endPoint debes enviar un objeto Persona, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Persona ")
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
    public ResponseEntity<BaseResponse> buscarPersona() {
        return personaServiceIn.obtenerTodosIn();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar una Persona por Id",
            description = "Para usar endPoint debes enviar un objeto Persona, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Persona ")
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
                    description = "HTTTP STATUS 201 significa que se creó de manera exitosa",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP STATUS 400 Bad Request",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<BaseResponse> buscarPorId(@PathVariable Long id) {
        return personaServiceIn.buscarPorIdIn(id);
    }
    @PutMapping("/{id}")

    @Operation(
            summary = "Actualizar una Persona por Id",
            description = "Para usar endPoint debes enviar un objeto Persona, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Persona ")
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
    public ResponseEntity<BaseResponse> actualizar(@PathVariable Long id, @RequestBody PersonaRequest personaRequest) {
        return personaServiceIn.actualizarIn(id, personaRequest);
    }

    @DeleteMapping("/{id}")

    @Operation(
            summary = "Eliminar una Persona por Id",
            description = "Para usar endPoint debes enviar un objeto Persona, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de Persona ")
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
        return personaServiceIn.eliminarIn(id);
    }
}
