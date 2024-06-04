package com.codigo.mssalazaramoroto.application.controller;


import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoDocumentoDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoDocumentoRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
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
    public ResponseEntity<BaseResponse>registrar(@RequestBody TipoDocumentoRequest tipoDocumentoRequest){
        return tipoDocumentoServiceIn.crearTipoDocumentoServiceIn(tipoDocumentoRequest);
    }

    @GetMapping
    public ResponseEntity<BaseResponse> buscarTipoDocumento() {
        return tipoDocumentoServiceIn.obtenerTodosIn();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> buscarTipoBienInmuebleById(@PathVariable Long id) {
        return tipoDocumentoServiceIn.buscarPorIdIn(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> actualizar(@PathVariable Long id, @RequestBody TipoDocumentoRequest tipoDocumentoRequest) {
        return tipoDocumentoServiceIn.actualizarIn(id, tipoDocumentoRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> eliminar(@PathVariable Long id) {
        return tipoDocumentoServiceIn.eliminarIn(id);
    }
}
