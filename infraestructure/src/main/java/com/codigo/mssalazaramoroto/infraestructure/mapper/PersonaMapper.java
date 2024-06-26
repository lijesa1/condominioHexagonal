package com.codigo.mssalazaramoroto.infraestructure.mapper;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.infraestructure.entity.Persona;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Optional;

@Service
public class PersonaMapper {
   /* private static final ModelMapper modelMapper = new ModelMapper();

    public PersonaDto mapToDto(Optional<Persona> entity){
        return modelMapper.map(entity, PersonaDto.class);
    }
    public Persona mapToEntity(PersonaDto personaDto){
        return modelMapper.map(personaDto, Persona.class);
    }*/

    public static PersonaDto fromEntity(Persona entity) {
        PersonaDto dto = new PersonaDto();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setCelular(entity.getCelular());
        dto.setEmail(entity.getEmail());
        dto.setNumDocumento(entity.getNumDocumento());
        dto.setTipoDocumento(entity.getTipoDocumento().getDescripcion());
        dto.setTipoPersona(entity.getTipoPersona().getDescripcion());
        dto.setFechaNac(entity.getFechaNac());
        dto.setLogin(entity.getLogin());
        dto.setEstado(entity.getEstado());
        dto.setUsuarioCreacion(entity.getUsuarioCreacion());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setUsuarioActualizacion(entity.getUsuarioActualizacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());
        dto.setUsuarioEliminacion(entity.getUsuarioEliminacion());
        dto.setFechaEliminacion(entity.getFechaEliminacion());
        return dto;
    }
}
