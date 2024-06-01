package com.codigo.mssalazaramoroto.infraestructure.dao;

import com.codigo.mssalazaramoroto.infraestructure.entity.TipoDocumento;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoPersona;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoPersonaRepository extends JpaRepository<TipoPersona, Long> {

    TipoPersona findByDescripcion(@Param("descripcion") String descripcion);

    // Optional<TipoPersona> findByDescripcion(String descripcion);
}
