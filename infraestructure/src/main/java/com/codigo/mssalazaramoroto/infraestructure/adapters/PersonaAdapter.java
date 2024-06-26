package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
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
import org.springframework.http.ResponseEntity;
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
    private final PersonaMapper personaMapper;
    private final ClientReniec reniec;
    private final RedisService redisService;
    private final Util util;

    @Value("${token.reniec}")
    private String tokenApi;

    private Persona getEntity(PersonaRequest personaRequest, boolean actualiza, Long id) {
        ReniecResponse reniecResponse = getExecutionReniec(personaRequest.getNumDocumento());
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findByDescripcion(personaRequest.getTipoDocumento());
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

    @Override
    public ResponseEntity<BaseResponse> crearPersonaOut(PersonaRequest personaRequest) {
        boolean exist = personaRepository.existsByNumDocumento(personaRequest.getNumDocumento());
        BaseResponse baseResponse = new BaseResponse();
        if (!exist) {
            Persona persona = getEntity(personaRequest, false, null);
            baseResponse.setCode(Constant.CODE_POST_PERSONA_OK);
            baseResponse.setMessage(Constant.MSG_POST_PERSONA_OK);
            baseResponse.setEntidad(personaRepository.save(persona));
        } else {
            baseResponse.setCode(Constant.CODE_POST_PERSONA_KO);
            baseResponse.setMessage(Constant.MSG_POST_PERSONA_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> buscarTodosOut() {
        BaseResponse baseResponse = new BaseResponse();
        List<Persona> personas = personaRepository.findAll();
        if (!personas.isEmpty()) {
            baseResponse.setCode(Constant.CODE_GET_TODOS_PERSONA_OK);
            baseResponse.setMessage(Constant.MSG_GET_TODOS_PERSONA_OK);
            baseResponse.setEntidad(personas);
        } else {
            baseResponse.setCode(Constant.CODE_GET_TODOS_PERSONA_KO);
            baseResponse.setMessage(Constant.MSG_GET_TODOS_PERSONA_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdOut(Long id) {
        BaseResponse baseResponse = new BaseResponse();
        String redisInfo = redisService.getFromRedis(Constant.REDIS_KEY_OBTENERPERSONA + id);
        if (redisInfo != null) {
            PersonaDto personaDto = util.convertFromJson(redisInfo, PersonaDto.class);
            baseResponse.setCode(Constant.CODE_GET_ID_PERSONA_OK);
            baseResponse.setMessage(Constant.MSG_GET_ID_PERSONA_OK);
            baseResponse.setEntidad(personaDto);
        } else {
            PersonaDto dto = PersonaMapper.fromEntity(personaRepository.findById(id).get());
            String dataForRedis = util.convertToJson(dto);
            redisService.saveInRedis(Constant.REDIS_KEY_OBTENERPERSONA + id, dataForRedis, 10);
            baseResponse.setCode(Constant.CODE_GET_ID_PERSONA_OK);
            baseResponse.setMessage(Constant.MSG_GET_ID_PERSONA_OK);
            baseResponse.setEntidad(dto);
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarOut(Long id, PersonaRequest personaRequest) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Persona> personaRecuperada = personaRepository.findById(id);
        if (personaRecuperada.isPresent()) {
            Persona persona = getEntity(personaRequest, true, id);
            baseResponse.setCode(Constant.CODE_PUT_PERSONA_OK);
            baseResponse.setMessage(Constant.MSG_PUT_PERSONA_OK);
            baseResponse.setEntidad(personaRepository.save(persona));
        } else {
            baseResponse.setCode(Constant.CODE_PUT_PERSONA_KO);
            baseResponse.setMessage(Constant.MSG_PUT_PERSONA_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarOut(Long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Persona> personaRecuperada = personaRepository.findById(id);
        if (personaRecuperada.isPresent()) {
            personaRecuperada.get().setEstado(Constant.STATUS_INACTIVE);
            personaRecuperada.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            personaRecuperada.get().setFechaEliminacion(getTimestamp());
            baseResponse.setCode(Constant.CODE_DELETE_PERSONA_OK);
            baseResponse.setMessage(Constant.MSG_DELETE_PERSONA_OK);
            baseResponse.setEntidad(personaRepository.save(personaRecuperada.get()));
        } else {
            baseResponse.setCode(Constant.CODE_DELETE_PERSONA_KO);
            baseResponse.setMessage(Constant.MSG_DELETE_PERSONA_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }
}
