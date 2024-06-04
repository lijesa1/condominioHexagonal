package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoPersonaDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoPersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface TipoPersonaServiceIn {

    ResponseEntity<BaseResponse> crearTipoPersonaServiceIn(TipoPersonaRequest tipoPersonaRequest);
    ResponseEntity<BaseResponse> obtenerTodosIn();
    ResponseEntity<BaseResponse> buscarPorIdIn(Long id);
    ResponseEntity<BaseResponse> actualizarIn(Long id, TipoPersonaRequest tipoPersonaRequest);
    ResponseEntity<BaseResponse> eliminarIn(Long id);
}
