package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoDocumentoRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface TipoDocumentoServiceIn {
    ResponseEntity<BaseResponse> crearTipoDocumentoServiceIn(TipoDocumentoRequest tipoDocumentoRequest);
    ResponseEntity<BaseResponse> obtenerTodosIn();
    ResponseEntity<BaseResponse> buscarPorIdIn(Long id);
    ResponseEntity<BaseResponse> actualizarIn(Long id, TipoDocumentoRequest tipoDocumentoRequest);
    ResponseEntity<BaseResponse> eliminarIn(Long id);
}
