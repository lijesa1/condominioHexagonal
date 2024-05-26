package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;

public interface BienInmuebleServiceOut {
    BienInmuebleDto crearBienInmuebleOut(BienInmuebleRequest bienInmuebleRequest);
}
