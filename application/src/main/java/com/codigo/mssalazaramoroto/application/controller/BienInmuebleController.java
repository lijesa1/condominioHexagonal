package com.codigo.mssalazaramoroto.application.controller;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.BienInmuebleServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ms-condominio/v1/bienInmueble")
@AllArgsConstructor
public class BienInmuebleController {
    private final BienInmuebleServiceIn bienInmuebleServiceIn;

    @PostMapping
    public ResponseEntity<BienInmuebleDto> registrar(@RequestBody BienInmuebleRequest bienInmuebleRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bienInmuebleServiceIn.crearBienInmuebleServiceIn(bienInmuebleRequest));
    }
}
