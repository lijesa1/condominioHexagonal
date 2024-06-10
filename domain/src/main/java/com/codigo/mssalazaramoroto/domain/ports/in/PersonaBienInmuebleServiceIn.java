package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaBienInmuebleDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PersonaBienInmuebleServiceIn {

    ResponseEntity<BaseResponse> crearPersonaBienInmuebleServiceIn(PersonaBienInmuebleRequest personabienInmuebleRequest);
    ResponseEntity<BaseResponse> obtenerTodosIn();
    ResponseEntity<BaseResponse> buscarPorIdIn(Long id);
    ResponseEntity<BaseResponse> actualizarIn(Long id, PersonaBienInmuebleRequest personabienInmuebleRequest);
    ResponseEntity<BaseResponse> eliminarIn(Long id);

}
