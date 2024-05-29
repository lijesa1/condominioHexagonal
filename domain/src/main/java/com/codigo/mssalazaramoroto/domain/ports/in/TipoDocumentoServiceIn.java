package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoDocumentoDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoDocumentoRequest;
import java.util.List;
import java.util.Optional;

public interface TipoDocumentoServiceIn {

    TipoDocumentoDto crearTipoDocumentoServiceIn(TipoDocumentoRequest tipoDocumentoRequest);

   List<TipoDocumentoDto> obtenerTodosIn();

    Optional<TipoDocumentoDto> buscarPorIdIn(Long id);

    TipoDocumentoDto actualizarIn(Long id, TipoDocumentoRequest tipoDocumentoRequest);
    TipoDocumentoDto eliminarIn(Long id);

}
