package com.codigo.mssalazaramoroto.domain.impl;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.BienInmuebleServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.out.BienInmuebleServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BienInmuebleServiceImpl implements BienInmuebleServiceIn {
    private final BienInmuebleServiceOut bienInmuebleServiceOut;

    @Override
    public BienInmuebleDto crearBienInmuebleServiceIn(BienInmuebleRequest bienInmuebleRequest) {
        return bienInmuebleServiceOut.crearBienInmuebleOut(bienInmuebleRequest);
    }
}
