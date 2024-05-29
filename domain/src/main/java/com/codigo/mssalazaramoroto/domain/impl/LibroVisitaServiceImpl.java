package com.codigo.mssalazaramoroto.domain.impl;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.LibroVisitaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.LibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.LibroVisitaServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.out.LibroVisitaServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class LibroVisitaServiceImpl implements LibroVisitaServiceIn {

    private final LibroVisitaServiceOut libroVisitaServiceOut;

    @Override
    public LibroVisitaDto crearLibroVisitaServiceIn(LibroVisitaRequest libroVisitaRequest) {
        return libroVisitaServiceOut.crearLibroVisitaServiceOut(libroVisitaRequest);
    }

    @Override
    public List<LibroVisitaDto> obtenerTodosIn() {
        return libroVisitaServiceOut.buscarTodosOut();
    }

    @Override
    public Optional<LibroVisitaDto> buscarPorIdIn(Long id) {
        return libroVisitaServiceOut.buscarPorIdOut(id);
    }

    @Override
    public LibroVisitaDto actualizarIn(Long id, LibroVisitaRequest libroVisitaRequest) {
        return libroVisitaServiceOut.actualizarOut(id, libroVisitaRequest);
    }

    @Override
    public LibroVisitaDto eliminarIn(Long id) {
        return libroVisitaServiceOut.eliminarOut(id);
    }
}
