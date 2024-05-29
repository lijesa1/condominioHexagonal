package com.codigo.mssalazaramoroto.infraestructure.mapper;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.LibroVisitaDto;
import com.codigo.mssalazaramoroto.infraestructure.entity.LibroVisita;
import org.springframework.stereotype.Service;
@Service
public class LibroVisitaMapper {

    public static LibroVisitaDto fromEntity(LibroVisita entity){
        LibroVisitaDto dto=new LibroVisitaDto();
        dto.setId(entity.getId());
        dto.setFechaVisita(entity.getFechaVisita());

        dto.setObservacionesLibroVisita(entity.getObservacionesLibroVisita());
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
