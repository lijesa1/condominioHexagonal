package com.codigo.mssalazaramoroto.application.controller;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
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
@RequestMapping("/ms-salazar-amoroto/v1/persona")
@AllArgsConstructor
@Tag(
        name = "Api de Personas",
        description = "Esta api permite registrar, buscar, actualizar y desactivar una persona asociada a una empresa"
)
public class PersonaController {
    private final PersonaServiceIn personaServiceIn;

    @PostMapping
    @Operation(
            summary = "Registra una persona asociada a una empresa previamente registrada en la base de datos",
            description = "Para usar endPoint debes enviar una petición con los datos de la persona, lo cual se va guardar en Base de datos previa validación, el DNI no deberá estar registrado previamente",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de personas")
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
    public ResponseEntity<PersonaDto> registrar(@RequestBody PersonaRequest requestPersona) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personaServiceIn.crearPersonaIn(requestPersona));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar una persona en base de datos por su id",
            description = "Para usar endPoint debes enviar una petición con el id de la persona, lo cual se va buscar en Base de datos previa validación",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de personas")
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
    public ResponseEntity<PersonaDto> buscarXid(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.buscarXIdIn(id).get());
    }

    @GetMapping("/todos")
    @Operation(
            summary = "Lista todas las personas registradas en base de datos",
            description = "Para usar endPoint debes enviar una petición por URL al endpoint de Personas",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de personas")
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
    public ResponseEntity<List<PersonaDto>> buscartodos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.obtenerTodosIn());
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar los datos de una persona registrada",
            description = "Para usar endPoint debes enviar una petición con los datos de la persona, lo cual se va actualizar en Base de datos previa validación, el DNI no deberá estar registrado previamente",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de personas")
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
    public ResponseEntity<PersonaDto> actualizar(@PathVariable Long id, @RequestBody PersonaRequest personaRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.actualziarIn(id, personaRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Desactiva una persona registrada en la BD",
            description = "Para usar endPoint debes enviar una petición con los datos de la persona, lo cual se va desactivar en Base de datos previa validación",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de personas")
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
    public ResponseEntity<PersonaDto> delete(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.deleteIn(id));
    }
}
