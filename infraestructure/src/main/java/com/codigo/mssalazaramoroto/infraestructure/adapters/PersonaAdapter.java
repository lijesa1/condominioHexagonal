package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.ReniecResponse;
import com.codigo.mssalazaramoroto.domain.ports.out.PersonaServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.client.ClientReniec;
import com.codigo.mssalazaramoroto.infraestructure.dao.PersonaRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoDocumentoRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoPersonaRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.Persona;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoDocumento;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoPersona;
import com.codigo.mssalazaramoroto.infraestructure.mapper.PersonaMapper;
import com.codigo.mssalazaramoroto.infraestructure.redis.RedisService;
import com.codigo.mssalazaramoroto.infraestructure.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaAdapter implements PersonaServiceOut {
    private final PersonaRepository personaRepository;
    private final TipoDocumentoRepository tipoDocumentoRepository;
    private final TipoPersonaRepository tipoPersonaRepository;
    private final PersonaMapper personaMapper;
    private final ClientReniec reniec;
    private final RedisService redisService;
    private final Util util;


    @Value("${token.reniec}")
    private String tokenApi;

    @Override
    public PersonaDto crearPersonaOut(PersonaRequest personaRequest) {
        Persona persona = getEntity(personaRequest, false, null);
        return personaMapper.mapToDto(personaRepository.save(persona));
    }

    @Override
    public List<PersonaDto> buscarTodosOut() {
        List<PersonaDto> personaDtoList = new ArrayList<>();
        List<Persona> entities = personaRepository.findAll();
        for (Persona persona : entities) {
            PersonaDto personaDto = personaMapper.mapToDto(persona);
            personaDtoList.add(personaDto);
        }
        return personaDtoList;
    }

    @Override
    public Optional<PersonaDto> buscarPorIdOut(Long id) {
        String redisInfo = redisService.getFromRedis(Constant.REDIS_KEY_OBTENERPERSONA + id);
        if (redisInfo != null) {
            PersonaDto personaDto = util.convertFromJson(redisInfo, PersonaDto.class);
            return Optional.of(personaDto);
        } else {
            PersonaDto dto = personaMapper.mapToDto(personaRepository.findById(id).get());
            String redis = util.convertToJson(dto);
            redisService.saveInRedis(Constant.REDIS_KEY_OBTENERPERSONA + id, redis, 10);
            return Optional.of(dto);
        }
    }

    @Override
    public PersonaDto actualizarOut(Long id, PersonaRequest personaRequest) {
        Optional<Persona> personaRecuperada = personaRepository.findById(id);
        if (personaRecuperada.isPresent()) {
            Persona persona = getEntity(personaRequest, true, id);
            return personaMapper.mapToDto(personaRepository.save(persona));
        } else {
            throw new RuntimeException("No se encontro la persona");
        }
    }

    @Override
    public PersonaDto eliminarOut(Long id) {
        Optional<Persona> personaRecuperada = personaRepository.findById(id);
        if (personaRecuperada.isPresent()) {
            personaRecuperada.get().setEstado(Constant.STATUS_INACTIVE);
            personaRecuperada.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            personaRecuperada.get().setFechaEliminacion(getTimestamp());
            return personaMapper.mapToDto(personaRepository.save(personaRecuperada.get()));
        } else {
            throw new RuntimeException("No se encontró la persona");
        }

    }


    private Persona getEntity(PersonaRequest personaRequest, boolean actualiza, Long id) {
        ReniecResponse reniecResponse = getExecutionReniec(personaRequest.getNumDocumento());
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findByTipoDocumento(personaRequest.getTipoDocumento());
        TipoPersona tipoPersona = tipoPersonaRepository.findByDescripcion(personaRequest.getTipoPersona());
        Persona persona = new Persona();
        persona.setNumDocumento(reniecResponse.getNumeroDocumento());
        persona.setNombre(reniecResponse.getNombres());
        persona.setApellidoPaterno(reniecResponse.getApellidoPaterno());
        persona.setApellidoMaterno(reniecResponse.getApellidoMaterno());
        persona.setEstado(Constant.STATUS_ACTIVE);
        persona.setCelular(personaRequest.getCelular());
        persona.setEmail(personaRequest.getEmail());
        persona.setFechaNac(personaRequest.getFechaNac());
        persona.setLogin(personaRequest.getLogin());
        persona.setTipoDocumento(tipoDocumento);
        persona.setTipoPersona(tipoPersona);
        persona.setUsuarioCreacion(Constant.USU_ADMIN);
        persona.setFechaCreacion(getTimestamp());
        if (actualiza) {
            persona.setId(id);
            persona.setUsuarioActualizacion(Constant.USU_ADMIN);
            persona.setFechaActualizacion(getTimestamp());
        }
        return persona;
    }

    public ReniecResponse getExecutionReniec(String numero) {
        String authorization = "Bearer " + tokenApi;
        ReniecResponse reniecResponse = reniec.getInfoReniec(numero, authorization);
        return reniecResponse;
    }


    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }
}
