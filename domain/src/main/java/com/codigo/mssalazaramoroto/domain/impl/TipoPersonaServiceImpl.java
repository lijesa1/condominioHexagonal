package com.codigo.mssalazaramoroto.domain.impl;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoPersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoPersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.TipoPersonaServiceIn;

import com.codigo.mssalazaramoroto.domain.ports.out.TipoPersonaServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoPersonaServiceImpl implements TipoPersonaServiceIn {

    private final TipoPersonaServiceOut tipoPersonaServiceOut;

    @Override
    public ResponseEntity<BaseResponse> crearTipoPersonaServiceIn(TipoPersonaRequest tipoPersonaRequest) {
        return tipoPersonaServiceOut.crearTipoPersonaOut(tipoPersonaRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> obtenerTodosIn() {
        return tipoPersonaServiceOut.buscarTodosOut();
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdIn(Long id) {
        return tipoPersonaServiceOut.buscarPorIdOut(id);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarIn(Long id, TipoPersonaRequest tipoPersonaRequest) {
        return tipoPersonaServiceOut.actualizarOut(id, tipoPersonaRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarIn(Long id) {
        return tipoPersonaServiceOut.eliminarOut((id));
    }
}
