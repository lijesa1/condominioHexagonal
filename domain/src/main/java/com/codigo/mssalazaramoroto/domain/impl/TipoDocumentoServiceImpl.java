package com.codigo.mssalazaramoroto.domain.impl;


import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoDocumentoDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoDocumentoRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.TipoDocumentoServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.out.TipoDocumentoServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class TipoDocumentoServiceImpl implements TipoDocumentoServiceIn {
    private final TipoDocumentoServiceOut tipoDocumentoServiceOut;


    @Override
    public TipoDocumentoDto crearTipoDocumentoServiceIn(TipoDocumentoRequest tipoDocumentoRequest) {
        return tipoDocumentoServiceOut.crearTipoDocumentoServiceOut(tipoDocumentoRequest);
    }

    @Override
    public List<TipoDocumentoDto> obtenerTodosIn() {
        return tipoDocumentoServiceOut.buscarTodosOut();
    }



    @Override
    public Optional<TipoDocumentoDto> buscarPorIdIn(Long id) {
        return tipoDocumentoServiceOut.buscarPorIdOut(id);
    }

    @Override
    public TipoDocumentoDto actualizarIn(Long id, TipoDocumentoRequest tipoDocumentoRequest) {
        return tipoDocumentoServiceOut.actualizarOut(id, tipoDocumentoRequest);
    }

    @Override
    public TipoDocumentoDto eliminarIn(Long id) {
        return tipoDocumentoServiceOut.eliminarOut((id));
    }
}
