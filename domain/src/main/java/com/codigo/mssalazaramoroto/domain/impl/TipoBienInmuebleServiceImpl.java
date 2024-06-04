package com.codigo.mssalazaramoroto.domain.impl;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.TipoBienInmuebleServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.out.TipoBienInmuebleServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoBienInmuebleServiceImpl implements TipoBienInmuebleServiceIn {

    private final TipoBienInmuebleServiceOut tipoBienInmuebleServiceOut;

    @Override
    public ResponseEntity<BaseResponse> crearTipoBienInmuebleServiceIn(TipoBienInmuebleRequest tipoBienInmuebleRequest) {
        return tipoBienInmuebleServiceOut.crearTipoBienInmuebleOut(tipoBienInmuebleRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> obtenerTodosIn() {
        return tipoBienInmuebleServiceOut.buscarTodosOut();
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdIn(Long id) {
        return tipoBienInmuebleServiceOut.buscarPorIdOut(id);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarIn(Long id, TipoBienInmuebleRequest tipoBienInmuebleRequest) {
       return tipoBienInmuebleServiceOut.actualizarOut(id, tipoBienInmuebleRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarIn(Long id) {
        return tipoBienInmuebleServiceOut.eliminarOut((id));
    }
}
