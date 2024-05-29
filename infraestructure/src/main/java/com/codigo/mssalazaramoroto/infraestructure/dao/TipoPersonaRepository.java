package com.codigo.mssalazaramoroto.infraestructure.dao;

import com.codigo.mssalazaramoroto.infraestructure.entity.TipoPersona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoPersonaRepository extends JpaRepository<TipoPersona, Long> {
    Optional<TipoPersona> findByDescripcion(String descripcion);
}
