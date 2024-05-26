package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;

import java.util.List;
import java.util.Optional;

public interface TipoBienInmuebleServiceIn {

    TipoBienInmuebleDto crearTipoBienInmuebleServiceIn(TipoBienInmuebleRequest tipoBienInmuebleRequest);

    List<TipoBienInmuebleDto> obtenerTodosIn();

    Optional<TipoBienInmuebleDto>buscarPorIdIn(Long id);

    TipoBienInmuebleDto actualizarIn(Long id, TipoBienInmuebleRequest tipoBienInmuebleRequest);
    TipoBienInmuebleDto eliminarIn(Long id);

}
