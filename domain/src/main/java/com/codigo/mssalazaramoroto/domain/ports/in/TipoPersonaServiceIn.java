package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoPersonaDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoPersonaRequest;

import java.util.List;
import java.util.Optional;

public interface TipoPersonaServiceIn {

    TipoPersonaDto crearTipoPersonaServiceIn(TipoPersonaRequest tipoPersonaRequest);

    List<TipoPersonaDto> obtenerTodosIn();

    Optional<TipoPersonaDto> buscarPorIdIn(Long id);

    TipoPersonaDto actualizarIn(Long id, TipoPersonaRequest tipoPersonaRequest);
    TipoPersonaDto eliminarIn(Long id);



}
