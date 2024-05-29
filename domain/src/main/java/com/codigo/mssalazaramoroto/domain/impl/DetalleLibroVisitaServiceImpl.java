package com.codigo.mssalazaramoroto.domain.impl;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.DetalleLibroVisitaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.DetalleLibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.DetalleLibroVisitaServiceIn;

import com.codigo.mssalazaramoroto.domain.ports.out.DetalleLibroVisitaServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DetalleLibroVisitaServiceImpl implements DetalleLibroVisitaServiceIn {


    private final DetalleLibroVisitaServiceOut detalleLibroVisitaServiceOut;

    @Override
    public DetalleLibroVisitaDto crearDetalleLibroVisitaServiceIn(DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        return detalleLibroVisitaServiceOut.crearDetalleLibroVisitaOut(detalleLibroVisitaRequest);
    }

    @Override
    public List<DetalleLibroVisitaDto> obtenerTodosIn() {
        return detalleLibroVisitaServiceOut.buscarTodosOut();
    }

    @Override
    public Optional<DetalleLibroVisitaDto> buscarPorIdIn(Long id) {
        return detalleLibroVisitaServiceOut.buscarPorIdOut(id);
    }

    @Override
    public DetalleLibroVisitaDto actualizarIn(Long id, DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        return detalleLibroVisitaServiceOut.actualizarOut(id, detalleLibroVisitaRequest);
    }

    @Override
    public DetalleLibroVisitaDto eliminarIn(Long id) {
        return detalleLibroVisitaServiceOut.eliminarOut(id);
    }
}
