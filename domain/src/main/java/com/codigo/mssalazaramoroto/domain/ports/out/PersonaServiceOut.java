package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface PersonaServiceOut {
    ResponseEntity<BaseResponse> crearPersonaOut(PersonaRequest personaRequest);

    ResponseEntity<BaseResponse> buscarTodosOut();

    ResponseEntity<BaseResponse> buscarPorIdOut(Long id);

    ResponseEntity<BaseResponse> actualizarOut(Long id, PersonaRequest personaRequest);

    ResponseEntity<BaseResponse> eliminarOut(Long id);
}
