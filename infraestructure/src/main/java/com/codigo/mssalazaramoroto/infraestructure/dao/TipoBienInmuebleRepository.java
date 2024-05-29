package com.codigo.mssalazaramoroto.infraestructure.dao;

import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipoBienInmuebleRepository extends JpaRepository<TipoBienInmueble, Long> {
    Optional<TipoBienInmueble> findByDescripcion(String descripcion);
}
