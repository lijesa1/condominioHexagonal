package com.codigo.mssalazaramoroto.infraestructure.mapper;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.DetalleLibroVisitaDto;
import com.codigo.mssalazaramoroto.infraestructure.entity.DetalleLibroVisita;
import org.springframework.stereotype.Service;
@Service
public class DetalleLibroVisitaMapper {

    public static DetalleLibroVisitaDto fromEntity(DetalleLibroVisita entity){
        DetalleLibroVisitaDto dto=new DetalleLibroVisitaDto();
        dto.setId(entity.getId());
        dto.setObservacionesPersonaVisitante(entity.getObservacionesPersonaVisitante());
        dto.setEstadoVisitante(entity.getEstadoVisitante());
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