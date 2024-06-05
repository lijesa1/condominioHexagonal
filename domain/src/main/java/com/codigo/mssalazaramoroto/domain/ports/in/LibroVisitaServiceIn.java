package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.request.LibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface LibroVisitaServiceIn {
    ResponseEntity<BaseResponse> crearLibroVisitaServiceIn(LibroVisitaRequest libroVisitaRequest);

    ResponseEntity<BaseResponse> obtenerTodosIn();

    ResponseEntity<BaseResponse> buscarPorIdIn(Long id);

    ResponseEntity<BaseResponse> actualizarIn(Long id, LibroVisitaRequest libroVisitaRequest);

    ResponseEntity<BaseResponse> eliminarIn(Long id);
}
