package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;

import java.util.List;
import java.util.Optional;

public interface PersonaServiceOut {

    BaseResponse crearPersonaOut(PersonaRequest personaRequest);

    List<PersonaDto> buscarTodosOut();

    Optional<PersonaDto> buscarPorIdOut(Long id);

    PersonaDto actualizarOut(Long id, PersonaRequest personaRequest);

    PersonaDto eliminarOut(Long id);

}
