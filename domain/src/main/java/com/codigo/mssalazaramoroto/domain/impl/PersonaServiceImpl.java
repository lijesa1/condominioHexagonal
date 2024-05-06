package com.codigo.mssalazaramoroto.domain.impl;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.PersonaServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.out.PersonaServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaServiceIn {

    private final PersonaServiceOut personaServiceOut;
    @Override
    public PersonaDto crearPersonaIn(PersonaRequest personaRequest) {
        return personaServiceOut.crearPersonaOut(personaRequest);
    }

    @Override
    public Optional<PersonaDto> buscarXIdIn(Long id) {
        return personaServiceOut.buscarXIdOut(id);
    }

    @Override
    public List<PersonaDto> obtenerTodosIn() {
        return personaServiceOut.obtenerTodosOut();
    }

    @Override
    public PersonaDto actualziarIn(Long id, PersonaRequest personaRequest) {
        return personaServiceOut.actualizarOut(id,personaRequest);
    }

    @Override
    public PersonaDto deleteIn(Long id) {
        return personaServiceOut.deleteOut(id);
    }
}
