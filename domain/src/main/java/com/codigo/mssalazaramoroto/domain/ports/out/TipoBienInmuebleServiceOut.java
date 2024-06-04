package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface TipoBienInmuebleServiceOut {
    ResponseEntity<BaseResponse> crearTipoBienInmuebleOut(TipoBienInmuebleRequest tipoBienInmuebleRequest);
    ResponseEntity<BaseResponse> buscarTodosOut();
    ResponseEntity<BaseResponse> buscarPorIdOut(Long id);
    ResponseEntity<BaseResponse> actualizarOut(Long id, TipoBienInmuebleRequest tipoBienInmuebleRequest);
    ResponseEntity<BaseResponse> eliminarOut(Long id);
}
