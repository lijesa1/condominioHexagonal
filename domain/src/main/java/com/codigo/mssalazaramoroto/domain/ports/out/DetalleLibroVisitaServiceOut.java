package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.DetalleLibroVisitaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.DetalleLibroVisitaRequest;

import java.util.List;
import java.util.Optional;

public interface DetalleLibroVisitaServiceOut {
    DetalleLibroVisitaDto crearDetalleLibroVisitaOut(DetalleLibroVisitaRequest detalleLibroVisitaRequest);

    List<DetalleLibroVisitaDto> buscarTodosOut();

    Optional<DetalleLibroVisitaDto> buscarPorIdOut(Long id);

    DetalleLibroVisitaDto actualizarOut(Long id, DetalleLibroVisitaRequest detalleLibroVisitaRequest);

    DetalleLibroVisitaDto eliminarOut(Long id);
}
