package com.codigo.mssalazaramoroto.infraestructure.mapper;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TipoBienInmuebleMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public BaseResponse mapToDto(TipoBienInmueble entity) {
        return new BaseResponse<TipoBienInmueble>(Constant.CODE_NOEXIST, Constant.MSG_OK, mapToEntity(modelMapper.map(entity, TipoBienInmuebleDto.class)));

    }

    public TipoBienInmueble mapToEntity(TipoBienInmuebleDto tipoBienInmuebleDto) {
        return modelMapper.map(tipoBienInmuebleDto, TipoBienInmueble.class);
    }


    /*public static TipoBienInmuebleDto fromEntity(TipoBienInmueble entity) {
        TipoBienInmuebleDto dto = new TipoBienInmuebleDto();
        dto.setId(entity.getId());
        dto.setDescripcion(entity.getDescripcion());
        dto.setEstado(entity.getEstado());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioActualizacion(entity.getUsuarioActualizacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());
        dto.setUsuarioEliminacion(entity.getUsuarioEliminacion());
        dto.setFechaEliminacion(entity.getFechaEliminacion());
        return dto;
    }*/
}
