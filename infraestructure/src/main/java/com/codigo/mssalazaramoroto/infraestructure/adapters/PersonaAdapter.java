package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.ports.out.PersonaServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.PersonaRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoDocumentoRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoPersonaRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.Persona;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoDocumento;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoPersona;
import com.codigo.mssalazaramoroto.infraestructure.mapper.PersonaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaAdapter implements PersonaServiceOut {
    private final PersonaRepository personaRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final TipoPersonaRepository tipoPersonaRepository;

    @Override
    public PersonaDto crearPersonaOut(PersonaRequest personaRequest) {
        Persona persona = getEntity(personaRequest,false,null);
        return PersonaMapper.fromEntity(personaRepository.save(persona));

    }

    @Override
    public List<PersonaDto> buscarTodosOut() {
        return List.of();
    }

    @Override
    public Optional<PersonaDto> buscarPorIdOut(Long id) {
        return Optional.empty();
    }

    @Override
    public PersonaDto actualizarOut(Long id, PersonaRequest personaRequest) {
        return null;
    }

    @Override
    public PersonaDto eliminarOut(Long id) {
        return null;
    }

    private Persona getEntity(PersonaRequest personaRequest, boolean actualiza, Long id) {
        TipoPersona tipoPersona = tipoPersonaRepository.findByDescripcion(personaRequest.getTipoPersona()).get();
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findByTipoDocumento(personaRequest.getTipoDocumento()).get();

        Persona entity = new Persona();
        entity.setNombre(personaRequest.getNombres());
        entity.setApellidoPaterno(personaRequest.getApellidoPaterno());
        entity.setApellidoMaterno(personaRequest.getApellidoMaterno());
        entity.setCelular(personaRequest.getCelular());
        entity.setEmail(personaRequest.getEmail());
        entity.setNumDocumento(personaRequest.getNumDocumento());
        entity.setTipoDocumento(tipoDocumento);
        entity.setTipoPersona(tipoPersona);
        entity.setFechaNac(personaRequest.getFechaNac());
        entity.setLogin(personaRequest.getLogin());
        entity.setPassword(personaRequest.getPassword());
        if (actualiza) {
            entity.setId(id);
            entity.setId(id);
            entity.setUsuarioCreacion(Constant.USU_ADMIN);
            entity.setFechaCreacion(getTimestamp());
            entity.setUsuarioModificacion(Constant.USU_ADMIN);
            entity.setFechaModificacion(getTimestamp());
        } else {
            entity.setUsuarioCreacion(Constant.USU_ADMIN);
            entity.setFechaCreacion(getTimestamp());
        }
        return entity;
    }

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }
}
