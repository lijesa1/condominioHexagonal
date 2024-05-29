package com.codigo.mssalazaramoroto.domain.impl;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.PersonaBienInmuebleServiceIn;

import com.codigo.mssalazaramoroto.domain.ports.out.PersonaBienInmuebleServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor

public class PersonaBienInmuebleServiceImpl implements PersonaBienInmuebleServiceIn {
    private final PersonaBienInmuebleServiceOut personaBienInmuebleServiceOut;

    @Override
    public PersonaBienInmuebleDto crearPersonaBienInmuebleServiceIn(PersonaBienInmuebleRequest personaBienInmuebleRequest) {
        return personaBienInmuebleServiceOut.crearPersonaBienInmuebleOut(personaBienInmuebleRequest);
    }

    @Override
    public List<PersonaBienInmuebleDto> obtenerTodosIn() {
        return personaBienInmuebleServiceOut.buscarTodosOut();
    }

    @Override
    public Optional<PersonaBienInmuebleDto> buscarPorIdIn(Long id) {
        return personaBienInmuebleServiceOut.buscarPorIdOut(id);
    }

    @Override
    public PersonaBienInmuebleDto actualizarIn(Long id, PersonaBienInmuebleRequest personabienInmuebleRequest) {
        return personaBienInmuebleServiceOut.actualizarOut(id, personabienInmuebleRequest);
    }

    @Override
    public PersonaBienInmuebleDto eliminarIn(Long id) {
        return personaBienInmuebleServiceOut.eliminarOut(id);
    }
}
