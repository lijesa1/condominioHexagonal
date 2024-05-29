package com.codigo.mssalazaramoroto.domain.ports.in;


import com.codigo.mssalazaramoroto.domain.aggregates.dto.LibroVisitaDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.LibroVisitaRequest;

import java.util.List;
import java.util.Optional;

public interface LibroVisitaServiceIn {

    LibroVisitaDto crearLibroVisitaServiceIn(LibroVisitaRequest libroVisitaRequest);

    List<LibroVisitaDto> obtenerTodosIn();

    Optional<LibroVisitaDto> buscarPorIdIn(Long id);

    LibroVisitaDto actualizarIn(Long id, LibroVisitaRequest libroVisitaRequest);

    LibroVisitaDto eliminarIn(Long id);

}
