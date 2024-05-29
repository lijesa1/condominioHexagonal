package com.codigo.mssalazaramoroto.application.controller;


import com.codigo.mssalazaramoroto.domain.aggregates.dto.LibroVisitaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.LibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.LibroVisitaServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-condominio/v1/libroVisita")
@AllArgsConstructor
public class LibroVisitaController {
    private final LibroVisitaServiceIn libroVisitaServiceIn;

    @PostMapping
    public ResponseEntity<LibroVisitaDto> registrar(@RequestBody LibroVisitaRequest LibroVisitaRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(libroVisitaServiceIn.crearLibroVisitaServiceIn(LibroVisitaRequest));
    }

    @GetMapping
    public ResponseEntity<List<LibroVisitaDto>> buscarLibroVisita() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(libroVisitaServiceIn.obtenerTodosIn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroVisitaDto> buscarLibroVisitaId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(libroVisitaServiceIn.buscarPorIdIn(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroVisitaDto> actualizar(@PathVariable Long id, @RequestBody LibroVisitaRequest libroVisitaRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(libroVisitaServiceIn.actualizarIn(id, libroVisitaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LibroVisitaDto> eliminar(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(libroVisitaServiceIn.eliminarIn(id));
    }
}
