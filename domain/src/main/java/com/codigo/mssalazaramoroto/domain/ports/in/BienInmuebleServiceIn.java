package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;

import java.util.List;
import java.util.Optional;

public interface BienInmuebleServiceIn {
    BienInmuebleDto crearBienInmuebleServiceIn(BienInmuebleRequest bienInmuebleRequest);
    List<BienInmuebleDto> obtenerTodosIn();
    Optional<BienInmuebleDto> buscarPorIdIn(Long id);
    BienInmuebleDto actualizarIn(Long id, BienInmuebleRequest bienInmuebleRequest);
    BienInmuebleDto eliminarIn(Long id);
}
