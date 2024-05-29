package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;

import java.util.List;
import java.util.Optional;

public interface BienInmuebleServiceOut {
    BienInmuebleDto crearBienInmuebleOut(BienInmuebleRequest bienInmuebleRequest);

    List<BienInmuebleDto> buscarTodosOut();

    Optional<BienInmuebleDto> buscarPorIdOut(Long id);

    BienInmuebleDto actualizarOut(Long id, BienInmuebleRequest bienInmuebleRequest);

    BienInmuebleDto eliminarOut(Long id);
}
