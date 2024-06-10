package com.codigo.mssalazaramoroto.infraestructure.mapper;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaBienInmuebleDto;
import com.codigo.mssalazaramoroto.infraestructure.entity.PersonaBienInmueble;
import org.springframework.stereotype.Service;

@Service
public class PersonaBienInmuebleMapper {
    public static PersonaBienInmuebleDto fromEntity(PersonaBienInmueble entity) {
        PersonaBienInmuebleDto dto = new PersonaBienInmuebleDto();
        dto.setEstado(entity.getEstado());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioActualizacion(entity.getUsuarioActualizacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());
        dto.setUsuarioEliminacion(entity.getUsuarioEliminacion());
        dto.setFechaEliminacion(entity.getFechaEliminacion());
        return dto;
    }

}
