package com.codigo.mssalazaramoroto.domain.impl;

import com.codigo.mssalazaramoroto.domain.aggregates.request.DetalleLibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.DetalleLibroVisitaServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.out.DetalleLibroVisitaServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DetalleLibroVisitaServiceImpl implements DetalleLibroVisitaServiceIn {

    private final DetalleLibroVisitaServiceOut detalleLibroVisitaServiceOut;

    @Override
    public ResponseEntity<BaseResponse> crearDetalleLibroVisitaServiceIn(DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        return detalleLibroVisitaServiceOut.crearDetalleLibroVisitaOut(detalleLibroVisitaRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> obtenerTodosIn() {
        return detalleLibroVisitaServiceOut.buscarTodosOut();
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdIn(Long id) {
        return detalleLibroVisitaServiceOut.buscarPorIdOut(id);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarIn(Long id, DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        return detalleLibroVisitaServiceOut.actualizarOut(id, detalleLibroVisitaRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarIn(Long id) {
        return detalleLibroVisitaServiceOut.eliminarOut(id);
    }
}
