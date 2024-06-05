package com.codigo.mssalazaramoroto.domain.impl;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.LibroVisitaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.LibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.LibroVisitaServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.out.LibroVisitaServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class LibroVisitaServiceImpl implements LibroVisitaServiceIn {

    private final LibroVisitaServiceOut libroVisitaServiceOut;

    @Override
    public ResponseEntity<BaseResponse> crearLibroVisitaServiceIn(LibroVisitaRequest libroVisitaRequest) {
        return libroVisitaServiceOut.crearLibroVisitaServiceOut(libroVisitaRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> obtenerTodosIn() {
        return libroVisitaServiceOut.buscarTodosOut();
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdIn(Long id) {
        return libroVisitaServiceOut.buscarPorIdOut(id);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarIn(Long id, LibroVisitaRequest libroVisitaRequest) {
        return libroVisitaServiceOut.actualizarOut(id, libroVisitaRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarIn(Long id) {
        return libroVisitaServiceOut.eliminarOut(id);
    }
}
