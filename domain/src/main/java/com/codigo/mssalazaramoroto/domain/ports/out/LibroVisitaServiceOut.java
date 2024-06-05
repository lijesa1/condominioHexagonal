package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.request.LibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface LibroVisitaServiceOut {

    ResponseEntity<BaseResponse> crearLibroVisitaServiceOut(LibroVisitaRequest libroVisitaRequest);

    ResponseEntity<BaseResponse> buscarTodosOut();

    ResponseEntity<BaseResponse> buscarPorIdOut(Long id);

    ResponseEntity<BaseResponse> actualizarOut(Long id, LibroVisitaRequest libroVisitaRequest);

    ResponseEntity<BaseResponse> eliminarOut(Long id);
}
