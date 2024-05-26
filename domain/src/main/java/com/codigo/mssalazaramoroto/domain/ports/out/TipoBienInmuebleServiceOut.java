package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;

import java.util.List;
import java.util.Optional;

public interface TipoBienInmuebleServiceOut {
    TipoBienInmuebleDto crearTipoBienInmuebleOut(TipoBienInmuebleRequest tipoBienInmuebleRequest);

    List<TipoBienInmuebleDto> buscarTodosOut();

    Optional<TipoBienInmuebleDto> buscarPorIdOut(Long id);

    TipoBienInmuebleDto actualizarOut(Long id, TipoBienInmuebleRequest tipoBienInmuebleRequest);

    TipoBienInmuebleDto eliminarOut(Long id);
}
