package com.codigo.mssalazaramoroto.application.controller;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoPersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoPersonaRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.TipoPersonaServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ms-condominio/v1/tipoPersona")
@AllArgsConstructor
public class  TipoPersonaController {
    private final TipoPersonaServiceIn tipoPersonaServiceIn;

    @PostMapping
    public ResponseEntity<TipoPersonaDto> registrar(@RequestBody TipoPersonaRequest tipoPersonaRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tipoPersonaServiceIn.crearTipoPersonaServiceIn(tipoPersonaRequest));
    }
    @GetMapping
    public ResponseEntity<List<TipoPersonaDto>> buscarTipoPersona() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoPersonaServiceIn.obtenerTodosIn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPersonaDto> buscarTipoPersonaById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoPersonaServiceIn.buscarPorIdIn(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoPersonaDto> actualizar(@PathVariable Long id, @RequestBody TipoPersonaRequest tipoPersonaRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoPersonaServiceIn.actualizarIn(id, tipoPersonaRequest));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoPersonaDto> eliminar(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoPersonaServiceIn.eliminarIn(id));
    }
}
