package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface BienInmuebleServiceIn {
    ResponseEntity<BaseResponse> crearBienInmuebleServiceIn(BienInmuebleRequest bienInmuebleRequest);
    ResponseEntity<BaseResponse> obtenerTodosIn();
    ResponseEntity<BaseResponse> buscarPorIdIn(Long id);
    ResponseEntity<BaseResponse> actualizarIn(Long id, BienInmuebleRequest bienInmuebleRequest);
    ResponseEntity<BaseResponse> eliminarIn(Long id);
}
