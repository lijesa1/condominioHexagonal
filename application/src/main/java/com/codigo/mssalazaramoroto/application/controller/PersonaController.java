package com.codigo.mssalazaramoroto.application.controller;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.in.PersonaServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-condominio/v1/persona")
@AllArgsConstructor
public class PersonaController {

    private final PersonaServiceIn personaServiceIn;

    @PostMapping
    public ResponseEntity<BaseResponse> registrar(@RequestBody PersonaRequest personaRequest) {
        return personaServiceIn.crearPersonaServiceIn(personaRequest);
    }

    @GetMapping
    public ResponseEntity<BaseResponse> buscarPersona() {
        return personaServiceIn.obtenerTodosIn();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse> buscarPorId(@PathVariable Long id) {
        return personaServiceIn.buscarPorIdIn(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse> actualizar(@PathVariable Long id, @RequestBody PersonaRequest personaRequest) {
        return personaServiceIn.actualizarIn(id, personaRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse> eliminar(@PathVariable Long id) {
        return personaServiceIn.eliminarIn(id);
    }
}
