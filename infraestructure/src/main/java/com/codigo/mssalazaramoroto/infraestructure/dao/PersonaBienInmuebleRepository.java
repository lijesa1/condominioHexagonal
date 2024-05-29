package com.codigo.mssalazaramoroto.infraestructure.dao;

import com.codigo.mssalazaramoroto.infraestructure.entity.PersonaBienInmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaBienInmuebleRepository extends JpaRepository<PersonaBienInmueble, Long> {
}
