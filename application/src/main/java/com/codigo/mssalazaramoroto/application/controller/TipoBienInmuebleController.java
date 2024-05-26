package com.codigo.mssalazaramoroto.application.controller;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.TipoBienInmuebleServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-condominio/v1/tipoBienInmueble")
@AllArgsConstructor
public class TipoBienInmuebleController {
    private final TipoBienInmuebleServiceIn tipoBienInmuebleServiceIn;

    @PostMapping
    public ResponseEntity<TipoBienInmuebleDto> registrar(@RequestBody TipoBienInmuebleRequest tipoBienInmuebleRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tipoBienInmuebleServiceIn.crearTipoBienInmuebleServiceIn(tipoBienInmuebleRequest));
    }

    @GetMapping
    public ResponseEntity<List<TipoBienInmuebleDto>> buscarTipoBienInmueble() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoBienInmuebleServiceIn.obtenerTodosIn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoBienInmuebleDto> buscarTipoBienInmuebleById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoBienInmuebleServiceIn.buscarPorIdIn(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoBienInmuebleDto> actualizar(@PathVariable Long id, @RequestBody TipoBienInmuebleRequest tipoBienInmuebleRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoBienInmuebleServiceIn.actualizarIn(id, tipoBienInmuebleRequest));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoBienInmuebleDto> eliminar(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoBienInmuebleServiceIn.eliminarIn(id));
    }
}
