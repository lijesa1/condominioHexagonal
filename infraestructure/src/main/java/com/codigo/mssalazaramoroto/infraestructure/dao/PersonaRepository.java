package com.codigo.mssalazaramoroto.infraestructure.dao;

import com.codigo.mssalazaramoroto.infraestructure.entity.Persona;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    boolean existsByNumDocumento(String numDocumento);
}
