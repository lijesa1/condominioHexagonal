package com.codigo.mssalazaramoroto.domain.impl;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoPersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoPersonaRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.TipoPersonaServiceIn;

import com.codigo.mssalazaramoroto.domain.ports.out.TipoPersonaServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoPersonaServiceImpl implements TipoPersonaServiceIn {

    private final TipoPersonaServiceOut tipoPersonaServiceOut;


    @Override
    public TipoPersonaDto crearTipoPersonaServiceIn(TipoPersonaRequest tipoPersonaRequest) {
        return tipoPersonaServiceOut.crearTipoPersonaOut(tipoPersonaRequest);
    }

    @Override
    public List<TipoPersonaDto> obtenerTodosIn() {
        return tipoPersonaServiceOut.buscarTodosOut();
    }

    @Override
    public Optional<TipoPersonaDto> buscarPorIdIn(Long id) {
        return tipoPersonaServiceOut.buscarPorIdOut(id);
    }

    @Override
    public TipoPersonaDto actualizarIn(Long id, TipoPersonaRequest tipoPersonaRequest) {
        return tipoPersonaServiceOut.actualizarOut(id, tipoPersonaRequest);
    }

    @Override
    public TipoPersonaDto eliminarIn(Long id) {
        return tipoPersonaServiceOut.eliminarOut((id));
    }
}
