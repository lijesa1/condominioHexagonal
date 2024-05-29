package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;

import java.util.List;
import java.util.Optional;

public interface PersonaServiceIn {
    PersonaDto crearPersonaServiceIn(PersonaRequest personaRequest);

    List<PersonaDto> obtenerTodosIn();

    Optional<PersonaDto> buscarPorIdIn(Long id);

    PersonaDto actualizarIn(Long id, PersonaRequest personaRequest);

    PersonaDto eliminarIn(Long id);
}
