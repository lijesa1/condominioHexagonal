package com.codigo.mssalazaramoroto.infraestructure.mapper;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoPersonaDto;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoPersona;
import org.springframework.stereotype.Service;

@Service
public class TipoPersonaMapper {

    public static TipoPersonaDto fromEntity(TipoPersona entity) {
        TipoPersonaDto dto = new TipoPersonaDto();
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        return dto;
    }
}
