package com.codigo.mssalazaramoroto.application.controller;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.DetalleLibroVisitaDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.DetalleLibroVisitaRequest;

import com.codigo.mssalazaramoroto.domain.ports.in.DetalleLibroVisitaServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-condominio/v1/detalleLibroVisita")
@AllArgsConstructor
public class DetalleLibroVisitaController {
    private final DetalleLibroVisitaServiceIn detalleLibroVisitaServiceIn;

    @PostMapping
    public ResponseEntity<DetalleLibroVisitaDto> registrar(@RequestBody DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(detalleLibroVisitaServiceIn.crearDetalleLibroVisitaServiceIn(detalleLibroVisitaRequest));
    }

    @GetMapping
    public ResponseEntity<List<DetalleLibroVisitaDto>> buscarDetalleLibroVisita() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(detalleLibroVisitaServiceIn.obtenerTodosIn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleLibroVisitaDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(detalleLibroVisitaServiceIn.buscarPorIdIn(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleLibroVisitaDto> actualizar(@PathVariable Long id, @RequestBody DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(detalleLibroVisitaServiceIn.actualizarIn(id, detalleLibroVisitaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetalleLibroVisitaDto> eliminar(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(detalleLibroVisitaServiceIn.eliminarIn(id));
    }
}
