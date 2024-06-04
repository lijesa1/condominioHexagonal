package com.codigo.mssalazaramoroto.domain.impl;


import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoDocumentoDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoDocumentoRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.TipoDocumentoServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.out.TipoDocumentoServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class TipoDocumentoServiceImpl implements TipoDocumentoServiceIn {
    private final TipoDocumentoServiceOut tipoDocumentoServiceOut;

    @Override
    public ResponseEntity<BaseResponse> crearTipoDocumentoServiceIn(TipoDocumentoRequest tipoDocumentoRequest) {
        return tipoDocumentoServiceOut.crearTipoDocumentoServiceOut(tipoDocumentoRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> obtenerTodosIn() {
        return tipoDocumentoServiceOut.buscarTodosOut();
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdIn(Long id) {
        return tipoDocumentoServiceOut.buscarPorIdOut(id);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarIn(Long id, TipoDocumentoRequest tipoDocumentoRequest) {
        return tipoDocumentoServiceOut.actualizarOut(id, tipoDocumentoRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarIn(Long id) {
        return tipoDocumentoServiceOut.eliminarOut((id));
    }
}
