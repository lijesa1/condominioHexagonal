package com.codigo.mssalazaramoroto.infraestructure.mapper;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.infraestructure.entity.BienInmueble;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;

@Service
public class BienInmuebleMapper {
    public static BienInmuebleDto fromEntity(BienInmueble entity){
        BienInmuebleDto dto=new BienInmuebleDto();
        dto.setId(entity.getId());
        dto.setTorre(entity.getTorre());
        dto.setPisoTorre(entity.getPisoTorre());
        dto.setNumDpto(entity.getNumDpto());
        dto.setNumEstacionamiento(entity.getNumEstacionamiento());
        dto.setNumComercio(entity.getNumComercio());
        dto.setEnUso(entity.getEnUso());
        dto.setEnAlquiler(entity.getEnAlquiler());
        dto.setEstado(entity.getEstado());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioModificacion(entity.getUsuarioModificacion());
        dto.setFechaModificacion(entity.getFechaModificacion());
        dto.setUsuarioActualizacion(entity.getUsuarioActualizacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());
        dto.setUsuarioEliminacion(entity.getUsuarioEliminacion());
        dto.setFechaEliminacion(entity.getFechaEliminacion());
        return dto;
    }
}
