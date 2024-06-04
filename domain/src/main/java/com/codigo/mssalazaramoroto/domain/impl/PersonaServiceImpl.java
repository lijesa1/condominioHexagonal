package com.codigo.mssalazaramoroto.domain.impl;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.PersonaServiceIn;

import com.codigo.mssalazaramoroto.domain.ports.out.PersonaServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonaServiceImpl implements PersonaServiceIn {

    private final PersonaServiceOut personaServiceOut;

    @Override
    public ResponseEntity<BaseResponse> crearPersonaServiceIn(PersonaRequest personaRequest) {
        return personaServiceOut.crearPersonaOut(personaRequest);
    }

    @Override
    public
    ResponseEntity<BaseResponse> obtenerTodosIn() {
        return personaServiceOut.buscarTodosOut();
    }

    @Override
    public
    ResponseEntity<BaseResponse> buscarPorIdIn(Long id) {
        return personaServiceOut.buscarPorIdOut(id);
    }

    @Override
    public
    ResponseEntity<BaseResponse> actualizarIn(Long id, PersonaRequest personaRequest) {
        return personaServiceOut.actualizarOut(id, personaRequest);
    }

    @Override
    public
    ResponseEntity<BaseResponse> eliminarIn(Long id) {
        return personaServiceOut.eliminarOut(id);
    }
}
