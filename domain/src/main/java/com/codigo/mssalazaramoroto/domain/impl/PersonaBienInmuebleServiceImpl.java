package com.codigo.mssalazaramoroto.domain.impl;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.PersonaBienInmuebleServiceIn;

import com.codigo.mssalazaramoroto.domain.ports.out.PersonaBienInmuebleServiceOut;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class PersonaBienInmuebleServiceImpl implements PersonaBienInmuebleServiceIn {
    private final PersonaBienInmuebleServiceOut personaBienInmuebleServiceOut;


    @Override
    public ResponseEntity<BaseResponse> crearPersonaBienInmuebleServiceIn(PersonaBienInmuebleRequest personaBienInmuebleRequest) {
        return personaBienInmuebleServiceOut.crearPersonaBienInmuebleOut(personaBienInmuebleRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> obtenerTodosIn() {
        return personaBienInmuebleServiceOut.buscarTodosOut();
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdIn(Long id) {
        return personaBienInmuebleServiceOut.buscarPorIdOut(id);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarIn(Long id, PersonaBienInmuebleRequest personabienInmuebleRequest) {
        return personaBienInmuebleServiceOut.actualizarOut(id, personabienInmuebleRequest);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarIn(Long id) {
        return personaBienInmuebleServiceOut.eliminarOut(id);
    }
}
