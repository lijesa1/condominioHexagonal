package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;

import java.util.List;
import java.util.Optional;

public interface PersonaServiceOut {
    PersonaDto crearPersonaOut(PersonaRequest personaRequest);
    Optional<PersonaDto> buscarXIdOut(Long id);
    List<PersonaDto> obtenerTodosOut();
    PersonaDto actualziarOut(Long id, PersonaRequest personaRequest);
    PersonaDto deleteOut(Long id);
}
