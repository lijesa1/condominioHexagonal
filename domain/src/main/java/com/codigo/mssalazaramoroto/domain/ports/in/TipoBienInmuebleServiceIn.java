package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface TipoBienInmuebleServiceIn {
    ResponseEntity<BaseResponse> crearTipoBienInmuebleServiceIn(TipoBienInmuebleRequest tipoBienInmuebleRequest);
    ResponseEntity<BaseResponse> obtenerTodosIn();
    ResponseEntity<BaseResponse>buscarPorIdIn(Long id);
    ResponseEntity<BaseResponse> actualizarIn(Long id, TipoBienInmuebleRequest tipoBienInmuebleRequest);
    ResponseEntity<BaseResponse> eliminarIn(Long id);
}
