package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.request.DetalleLibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface DetalleLibroVisitaServiceIn {
    ResponseEntity<BaseResponse> crearDetalleLibroVisitaServiceIn(DetalleLibroVisitaRequest detalleLibroVisitaRequest);
    ResponseEntity<BaseResponse> obtenerTodosIn();
    ResponseEntity<BaseResponse> buscarPorIdIn(Long id);
    ResponseEntity<BaseResponse> actualizarIn(Long id, DetalleLibroVisitaRequest detalleLibroVisitaRequest);
    ResponseEntity<BaseResponse> eliminarIn(Long id);
}
