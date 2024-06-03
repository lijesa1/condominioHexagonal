package com.codigo.mssalazaramoroto.infraestructure.mapper;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.infraestructure.entity.Persona;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class PersonaMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public BaseResponse mapToDto(Persona entity){
        return new BaseResponse<Persona>(Constant.CODE_NOEXIST,Constant.MSG_OK,mapToEntity(modelMapper.map(entity, PersonaDto.class)));
    }
    public Persona mapToEntity(PersonaDto personaDto){
        return modelMapper.map(personaDto, Persona.class);
    }

    /*
    public static PersonaDto fromEntity(Persona entity) {
        PersonaDto dto = new PersonaDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setCelular(entity.getCelular());
        dto.setEmail(entity.getEmail());
        dto.setNumDocumento(entity.getNumDocumento());
        dto.setTipoDocumento(entity.getTipoDocumento().getTipoDocumento());
        dto.setTipoPersona(entity.getTipoPersona().getDescripcion());
        dto.setFechaNac(entity.getFechaNac());
        dto.setLogin(entity.getLogin());
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
    }*/
}
