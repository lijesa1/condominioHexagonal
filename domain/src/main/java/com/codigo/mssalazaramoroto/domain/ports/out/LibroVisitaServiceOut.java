package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.LibroVisitaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.request.LibroVisitaRequest;

import java.util.List;
import java.util.Optional;

public interface LibroVisitaServiceOut {

    LibroVisitaDto crearLibroVisitaServiceOut(LibroVisitaRequest libroVisitaRequest);

    List<LibroVisitaDto> buscarTodosOut();

    Optional<LibroVisitaDto> buscarPorIdOut(Long id);

    LibroVisitaDto actualizarOut(Long id, LibroVisitaRequest libroVisitaRequest);

    LibroVisitaDto eliminarOut(Long id);
}
