package com.codigo.mssalazaramoroto.infraestructure.mapper;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoDocumentoDto;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoDocumento;
import org.springframework.stereotype.Service;

@Service
public class TipoDocumentoMapper {

    public static TipoDocumentoDto fromEntity(TipoDocumento entity) {
        TipoDocumentoDto dto = new TipoDocumentoDto();
        dto.setId(entity.getId());
        dto.setTipoDocumento(entity.getDescripcion());
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
