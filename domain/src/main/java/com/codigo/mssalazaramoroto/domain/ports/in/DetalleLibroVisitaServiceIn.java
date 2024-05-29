package com.codigo.mssalazaramoroto.domain.ports.in;


import com.codigo.mssalazaramoroto.domain.aggregates.dto.DetalleLibroVisitaDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.DetalleLibroVisitaRequest;

import java.util.List;
import java.util.Optional;

public interface DetalleLibroVisitaServiceIn {
    DetalleLibroVisitaDto crearDetalleLibroVisitaServiceIn(DetalleLibroVisitaRequest detalleLibroVisitaRequest);
    List<DetalleLibroVisitaDto> obtenerTodosIn();
    Optional<DetalleLibroVisitaDto> buscarPorIdIn(Long id);
    DetalleLibroVisitaDto actualizarIn(Long id, DetalleLibroVisitaRequest detalleLibroVisitaRequest);
    DetalleLibroVisitaDto eliminarIn(Long id);


}
