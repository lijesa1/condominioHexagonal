package com.codigo.mssalazaramoroto.application.controller;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.BienInmuebleServiceIn;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ms-condominio/v1/bienInmueble")
@AllArgsConstructor
public class BienInmuebleController {
    private final BienInmuebleServiceIn bienInmuebleServiceIn;

    @PostMapping
    public ResponseEntity<BaseResponse> registrar(@RequestBody BienInmuebleRequest bienInmuebleRequest) {
        return bienInmuebleServiceIn.crearBienInmuebleServiceIn(bienInmuebleRequest);
    }

    @GetMapping
    public ResponseEntity<BaseResponse> buscarBienInmueble() {
        return bienInmuebleServiceIn.obtenerTodosIn();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> buscarPorId(@PathVariable Long id) {
        return bienInmuebleServiceIn.buscarPorIdIn(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> actualizar(@PathVariable Long id, @RequestBody BienInmuebleRequest bienInmuebleRequest) {
        return bienInmuebleServiceIn.actualizarIn(id, bienInmuebleRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> eliminar(@PathVariable Long id) {
        return bienInmuebleServiceIn.eliminarIn(id);

    }
}
