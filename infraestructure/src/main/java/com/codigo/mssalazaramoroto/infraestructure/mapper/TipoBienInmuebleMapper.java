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
