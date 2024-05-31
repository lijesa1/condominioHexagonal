package com.codigo.mssalazaramoroto.application.controller;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
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
    public ResponseEntity<PersonaDto> registrar(@RequestBody PersonaRequest personaRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personaServiceIn.crearPersonaServiceIn(personaRequest));
    }

    @GetMapping
    public ResponseEntity<List<PersonaDto>> buscarPersona() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.obtenerTodosIn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.buscarPorIdIn(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaDto> actualizar(@PathVariable Long id, @RequestBody PersonaRequest personaRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.actualizarIn(id, personaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaDto> eliminar(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaServiceIn.eliminarIn(id));

    }



}
