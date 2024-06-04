package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface BienInmuebleServiceOut {
    ResponseEntity<BaseResponse> crearBienInmuebleOut(BienInmuebleRequest bienInmuebleRequest);

    ResponseEntity<BaseResponse> buscarTodosOut();

    ResponseEntity<BaseResponse> buscarPorIdOut(Long id);

    ResponseEntity<BaseResponse> actualizarOut(Long id, BienInmuebleRequest bienInmuebleRequest);

    ResponseEntity<BaseResponse> eliminarOut(Long id);
}
