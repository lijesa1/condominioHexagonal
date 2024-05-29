package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoDocumentoDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoDocumentoRequest;

import java.util.List;
import java.util.Optional;

public interface TipoDocumentoServiceOut {

    TipoDocumentoDto crearTipoDocumentoServiceOut(TipoDocumentoRequest tipoDocumentoRequest);

    List<TipoDocumentoDto> buscarTodosOut();

    Optional<TipoDocumentoDto> buscarPorIdOut(Long id);

    TipoDocumentoDto actualizarOut(Long id, TipoDocumentoRequest tipoDocumentoRequest);

    TipoDocumentoDto eliminarOut(Long id);


}
