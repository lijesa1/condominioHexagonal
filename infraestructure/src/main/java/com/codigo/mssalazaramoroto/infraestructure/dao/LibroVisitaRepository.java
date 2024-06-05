package com.codigo.mssalazaramoroto.infraestructure.dao;

import com.codigo.mssalazaramoroto.infraestructure.entity.LibroVisita;
import com.codigo.mssalazaramoroto.infraestructure.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface LibroVisitaRepository extends JpaRepository<LibroVisita, Long> {
    boolean existsByPersona(Optional<Persona> persona);
}
