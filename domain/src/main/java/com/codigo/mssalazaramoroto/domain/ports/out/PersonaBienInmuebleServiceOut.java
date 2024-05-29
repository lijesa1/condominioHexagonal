package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaBienInmuebleRequest;

import java.util.List;
import java.util.Optional;

public interface PersonaBienInmuebleServiceOut {

    PersonaBienInmuebleDto crearPersonaBienInmuebleOut(PersonaBienInmuebleRequest personaBienInmuebleRequest);

    List<PersonaBienInmuebleDto> buscarTodosOut();

    Optional<PersonaBienInmuebleDto> buscarPorIdOut(Long id);

    PersonaBienInmuebleDto actualizarOut(Long id, PersonaBienInmuebleRequest personaBienInmuebleRequest);

    PersonaBienInmuebleDto eliminarOut(Long id);
}
