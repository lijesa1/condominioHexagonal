package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import org.springframework.http.ResponseEntity;

public interface PersonaServiceIn {
    ResponseEntity<BaseResponse> crearPersonaServiceIn(PersonaRequest personaRequest);

    ResponseEntity<BaseResponse> obtenerTodosIn();

    ResponseEntity<BaseResponse> buscarPorIdIn(Long id);

    ResponseEntity<BaseResponse> actualizarIn(Long id, PersonaRequest personaRequest);

    ResponseEntity<BaseResponse> eliminarIn(Long id);
}
