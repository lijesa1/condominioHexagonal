package com.codigo.mssalazaramoroto.infraestructure.dao;

import com.codigo.mssalazaramoroto.infraestructure.entity.BienInmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BienInmuebleRepository extends JpaRepository<BienInmueble, Long> {
}
