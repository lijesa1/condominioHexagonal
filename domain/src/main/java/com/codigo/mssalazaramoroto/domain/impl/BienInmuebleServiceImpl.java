package com.codigo.mssalazaramoroto.domain.impl;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.BienInmuebleServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.out.BienInmuebleServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BienInmuebleServiceImpl implements BienInmuebleServiceIn {
    private final BienInmuebleServiceOut bienInmuebleServiceOut;

    @Override
    public BienInmuebleDto crearBienInmuebleServiceIn(BienInmuebleRequest bienInmuebleRequest) {
        return bienInmuebleServiceOut.crearBienInmuebleOut(bienInmuebleRequest);
    }

    @Override
    public List<BienInmuebleDto> obtenerTodosIn() {
        return bienInmuebleServiceOut.buscarTodosOut();
    }

    @Override
    public Optional<BienInmuebleDto> buscarPorIdIn(Long id) {
        return bienInmuebleServiceOut.buscarPorIdOut(id);
    }

    @Override
    public BienInmuebleDto actualizarIn(Long id, BienInmuebleRequest bienInmuebleRequest) {
        return bienInmuebleServiceOut.actualizarOut(id, bienInmuebleRequest);
    }

    @Override
    public BienInmuebleDto eliminarIn(Long id) {
        return bienInmuebleServiceOut.eliminarOut(id);
    }
}
