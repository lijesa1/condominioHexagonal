package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.request.DetalleLibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface DetalleLibroVisitaServiceOut {
    ResponseEntity<BaseResponse> crearDetalleLibroVisitaOut(DetalleLibroVisitaRequest detalleLibroVisitaRequest);

    ResponseEntity<BaseResponse> buscarTodosOut();

    ResponseEntity<BaseResponse> buscarPorIdOut(Long id);

    ResponseEntity<BaseResponse> actualizarOut(Long id, DetalleLibroVisitaRequest detalleLibroVisitaRequest);

    ResponseEntity<BaseResponse> eliminarOut(Long id);
}
