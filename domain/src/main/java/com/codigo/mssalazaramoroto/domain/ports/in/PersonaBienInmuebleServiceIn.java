package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaBienInmuebleDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaBienInmuebleRequest;

import java.util.List;
import java.util.Optional;

public interface PersonaBienInmuebleServiceIn {

    PersonaBienInmuebleDto crearPersonaBienInmuebleServiceIn(PersonaBienInmuebleRequest personabienInmuebleRequest);
    List<PersonaBienInmuebleDto> obtenerTodosIn();
    Optional<PersonaBienInmuebleDto> buscarPorIdIn(Long id);
    PersonaBienInmuebleDto actualizarIn(Long id, PersonaBienInmuebleRequest personabienInmuebleRequest);
    PersonaBienInmuebleDto eliminarIn(Long id);

}
