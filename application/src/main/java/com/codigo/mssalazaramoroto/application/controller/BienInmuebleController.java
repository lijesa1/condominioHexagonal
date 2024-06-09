package com.codigo.mssalazaramoroto.application.controller;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.BienInmuebleServiceIn;
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
@RequestMapping("/ms-condominio/v1/bienInmueble")
@AllArgsConstructor
@Tag(
        name = "Api de Bien Inmueble",
        description = "Esta api permite registrar, buscar, actualizar y desactivar un Bien Inmueble"
)
public class BienInmuebleController {
    private final BienInmuebleServiceIn bienInmuebleServiceIn;
@PostMapping
    @Operation(
            summary = "Registrar un bien_inmueble en base de datos",
            description = "Para usar endPoint debes enviar un objeto bien_inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de bien_inmueble ")
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
    public ResponseEntity<BaseResponse> registrar(@Valid @RequestBody BienInmuebleRequest bienInmuebleRequest) {
        return bienInmuebleServiceIn.crearBienInmuebleServiceIn(bienInmuebleRequest);
    }
    @GetMapping
    @Operation(
            summary = "Buscar todos los bienes inmuebles",
            description = "Para usar endPoint debes enviar un objeto bien_inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de bien_inmueble ")
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
    public ResponseEntity<BaseResponse> buscarBienInmueble() {
        return bienInmuebleServiceIn.obtenerTodosIn();
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar un bien inmueble por id",
            description = "Para usar endPoint debes enviar un objeto bien_inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de bien_inmueble ")
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
        return bienInmuebleServiceIn.buscarPorIdIn(id);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar un bien inmueble por id",
            description = "Para usar endPoint debes enviar un objeto bien_inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de bien_inmueble ")
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
    public ResponseEntity<BaseResponse> actualizar(@PathVariable Long id, @RequestBody BienInmuebleRequest bienInmuebleRequest) {
        return bienInmuebleServiceIn.actualizarIn(id, bienInmuebleRequest);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar un bien inmueble por id",
            description = "Para usar endPoint debes enviar un objeto bien_inmueble, lo cual se va guardar en Base de datos previa validacion",
            parameters = {
                    @Parameter(name = "filtro", description = "Filtro de bien_inmueble ")
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
        return bienInmuebleServiceIn.eliminarIn(id);
    }
}
