package com.codigo.mssalazaramoroto.infraestructure.mapper;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.infraestructure.entity.BienInmueble;
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
        dto.setUsuaCrea(entity.getUsuaCrea());
        dto.setDateCreate(entity.getDateCreate());
        dto.setUsuaModif(entity.getUsuaModif());
        dto.setDateModif(entity.getDateModif());
        dto.setUsuaDelet(entity.getUsuaDelet());
        dto.setDateDelet(entity.getDateDelet());
        return dto;
    }
}
