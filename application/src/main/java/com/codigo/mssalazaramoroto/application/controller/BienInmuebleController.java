package com.codigo.mssalazaramoroto.application.controller;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.BienInmuebleServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<BienInmuebleDto>> buscarBienInmueble() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bienInmuebleServiceIn.obtenerTodosIn());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BienInmuebleDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bienInmuebleServiceIn.buscarPorIdIn(id).get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<BienInmuebleDto> actualizar(@PathVariable Long id, @RequestBody BienInmuebleRequest bienInmuebleRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bienInmuebleServiceIn.actualizarIn(id, bienInmuebleRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BienInmuebleDto> eliminar(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bienInmuebleServiceIn.eliminarIn(id));

    }
}
