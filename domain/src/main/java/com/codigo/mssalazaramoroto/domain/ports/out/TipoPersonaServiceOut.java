package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoPersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoPersonaRequest;

import java.util.List;
import java.util.Optional;

public interface TipoPersonaServiceOut {

    TipoPersonaDto crearTipoPersonaOut(TipoPersonaRequest tipoPersonaRequest);

    List<TipoPersonaDto> buscarTodosOut();

    Optional<TipoPersonaDto> buscarPorIdOut(Long id);

    TipoPersonaDto actualizarOut(Long id, TipoPersonaRequest TipoPersonaRequest);

    TipoPersonaDto eliminarOut(Long id);

}
