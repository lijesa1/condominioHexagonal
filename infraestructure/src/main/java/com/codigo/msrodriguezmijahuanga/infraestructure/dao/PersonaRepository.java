package com.codigo.msrodriguezmijahuanga.infraestructure.dao;

import com.codigo.msrodriguezmijahuanga.infraestructure.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
