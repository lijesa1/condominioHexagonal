package com.codigo.mssalazaramoroto.application.controller;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
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
    public ResponseEntity<BaseResponse> registrar(@RequestBody TipoBienInmuebleRequest tipoBienInmuebleRequest) {
        return tipoBienInmuebleServiceIn.crearTipoBienInmuebleServiceIn(tipoBienInmuebleRequest);
    }

    @GetMapping
    public ResponseEntity<BaseResponse> buscarTipoBienInmueble() {
        return tipoBienInmuebleServiceIn.obtenerTodosIn();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> buscarTipoBienInmuebleById(@PathVariable Long id) {
        return tipoBienInmuebleServiceIn.buscarPorIdIn(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> actualizar(@PathVariable Long id, @RequestBody TipoBienInmuebleRequest tipoBienInmuebleRequest) {
        return tipoBienInmuebleServiceIn.actualizarIn(id, tipoBienInmuebleRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> eliminar(@PathVariable Long id) {
        return tipoBienInmuebleServiceIn.eliminarIn(id);
    }
}
