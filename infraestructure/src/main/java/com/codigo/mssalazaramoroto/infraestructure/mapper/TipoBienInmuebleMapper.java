package com.codigo.mssalazaramoroto.infraestructure.mapper;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoBienInmuebleDto;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import org.springframework.stereotype.Service;

@Service
public class TipoBienInmuebleMapper {
    public static TipoBienInmuebleDto fromEntity(TipoBienInmueble entity) {
        TipoBienInmuebleDto dto = new TipoBienInmuebleDto();
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
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
