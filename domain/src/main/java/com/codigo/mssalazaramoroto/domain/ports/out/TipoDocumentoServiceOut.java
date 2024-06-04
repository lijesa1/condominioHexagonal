package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoDocumentoRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface TipoDocumentoServiceOut {

    ResponseEntity<BaseResponse> crearTipoDocumentoServiceOut(TipoDocumentoRequest tipoDocumentoRequest);

    ResponseEntity<BaseResponse> buscarTodosOut();

    ResponseEntity<BaseResponse> buscarPorIdOut(Long id);

    ResponseEntity<BaseResponse> actualizarOut(Long id, TipoDocumentoRequest tipoDocumentoRequest);

    ResponseEntity<BaseResponse> eliminarOut(Long id);
}
