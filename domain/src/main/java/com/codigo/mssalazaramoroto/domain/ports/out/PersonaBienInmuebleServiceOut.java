package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PersonaBienInmuebleServiceOut {

    ResponseEntity<BaseResponse> crearPersonaBienInmuebleOut(PersonaBienInmuebleRequest personaBienInmuebleRequest);

    ResponseEntity<BaseResponse> buscarTodosOut();

    ResponseEntity<BaseResponse> buscarPorIdOut(Long id);

    ResponseEntity<BaseResponse> actualizarOut(Long id, PersonaBienInmuebleRequest personaBienInmuebleRequest);

    ResponseEntity<BaseResponse> eliminarOut(Long id);
}
