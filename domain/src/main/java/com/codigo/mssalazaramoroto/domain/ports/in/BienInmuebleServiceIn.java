package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;

import java.util.List;

public interface BienInmuebleServiceIn {
    BienInmuebleDto crearBienInmuebleServiceIn(BienInmuebleRequest bienInmuebleRequest);
    List<BienInmuebleDto> obtenerTodosIn();
}
