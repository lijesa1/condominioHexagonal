package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoPersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface TipoPersonaServiceOut {

    ResponseEntity<BaseResponse> crearTipoPersonaOut(TipoPersonaRequest tipoPersonaRequest);

    ResponseEntity<BaseResponse> buscarTodosOut();

    ResponseEntity<BaseResponse> buscarPorIdOut(Long id);

    ResponseEntity<BaseResponse> actualizarOut(Long id, TipoPersonaRequest TipoPersonaRequest);

    ResponseEntity<BaseResponse> eliminarOut(Long id);

}
