package com.codigo.mssalazaramoroto.domain.impl;

import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.BienInmuebleServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.out.BienInmuebleServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BienInmuebleServiceImpl implements BienInmuebleServiceIn {
    private final BienInmuebleServiceOut bienInmuebleServiceOut;

    @Override
    public ResponseEntity<BaseResponse> crearBienInmuebleServiceIn(BienInmuebleRequest bienInmuebleRequest) {
        return bienInmuebleServiceOut.crearBienInmuebleOut(bienInmuebleRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> obtenerTodosIn() {
        return bienInmuebleServiceOut.buscarTodosOut();
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdIn(Long id) {
        return bienInmuebleServiceOut.buscarPorIdOut(id);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarIn(Long id, BienInmuebleRequest bienInmuebleRequest) {
        return bienInmuebleServiceOut.actualizarOut(id, bienInmuebleRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarIn(Long id) {
        return bienInmuebleServiceOut.eliminarOut(id);
    }
}
