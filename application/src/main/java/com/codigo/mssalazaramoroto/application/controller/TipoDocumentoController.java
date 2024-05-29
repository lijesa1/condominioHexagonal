package com.codigo.mssalazaramoroto.application.controller;


import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoDocumentoDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoDocumentoRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.TipoDocumentoServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-condominio/v1/tipoDocumento")
@AllArgsConstructor
public class TipoDocumentoController {

    private final TipoDocumentoServiceIn tipoDocumentoServiceIn;

    @PostMapping
    public ResponseEntity<TipoDocumentoDto>registrar(@RequestBody TipoDocumentoRequest tipoDocumentoRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tipoDocumentoServiceIn.crearTipoDocumentoServiceIn(tipoDocumentoRequest));
    }

    @GetMapping
    public ResponseEntity<List<TipoDocumentoDto>> buscarTipoDocumento() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoDocumentoServiceIn.obtenerTodosIn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumentoDto> buscarTipoBienInmuebleById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoDocumentoServiceIn.buscarPorIdIn(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDocumentoDto> actualizar(@PathVariable Long id, @RequestBody TipoDocumentoRequest tipoDocumentoRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoDocumentoServiceIn.actualizarIn(id, tipoDocumentoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoDocumentoDto> eliminar(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tipoDocumentoServiceIn.eliminarIn(id));
    }
}
