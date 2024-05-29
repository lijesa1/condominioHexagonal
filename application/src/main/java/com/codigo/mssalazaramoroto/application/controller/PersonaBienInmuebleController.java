package com.codigo.mssalazaramoroto.application.controller;


import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.PersonaBienInmuebleServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-condominio/v1/personaBienInmuebleDto")
@AllArgsConstructor
public class PersonaBienInmuebleController {

    private final PersonaBienInmuebleServiceIn personaBienInmuebleServiceIn;

    @PostMapping
    public ResponseEntity<PersonaBienInmuebleDto> registrar(@RequestBody PersonaBienInmuebleRequest personaBienInmuebleRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personaBienInmuebleServiceIn.crearPersonaBienInmuebleServiceIn(personaBienInmuebleRequest));
    }

    @GetMapping
    public ResponseEntity<List<PersonaBienInmuebleDto>> buscarPersonaBienInmueble() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaBienInmuebleServiceIn.obtenerTodosIn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaBienInmuebleDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaBienInmuebleServiceIn.buscarPorIdIn(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaBienInmuebleDto> actualizar(@PathVariable Long id, @RequestBody PersonaBienInmuebleRequest personaBienInmuebleRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaBienInmuebleServiceIn.actualizarIn(id, personaBienInmuebleRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaBienInmuebleDto> eliminar(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(personaBienInmuebleServiceIn.eliminarIn(id));

    }



}
