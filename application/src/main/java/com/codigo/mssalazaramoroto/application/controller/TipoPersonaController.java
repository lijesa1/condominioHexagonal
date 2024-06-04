package com.codigo.mssalazaramoroto.application.controller;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoPersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoPersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
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
    public ResponseEntity<BaseResponse> registrar(@RequestBody TipoPersonaRequest tipoPersonaRequest) {
        return tipoPersonaServiceIn.crearTipoPersonaServiceIn(tipoPersonaRequest);
    }
    @GetMapping
    public ResponseEntity<BaseResponse> buscarTipoPersona() {
        return tipoPersonaServiceIn.obtenerTodosIn();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> buscarTipoPersonaById(@PathVariable Long id) {
        return tipoPersonaServiceIn.buscarPorIdIn(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> actualizar(@PathVariable Long id, @RequestBody TipoPersonaRequest tipoPersonaRequest) {
        return tipoPersonaServiceIn.actualizarIn(id, tipoPersonaRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> eliminar(@PathVariable Long id) {
        return tipoPersonaServiceIn.eliminarIn(id);
    }
}
