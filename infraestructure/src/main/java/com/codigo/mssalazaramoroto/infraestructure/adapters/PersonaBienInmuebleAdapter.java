package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaBienInmuebleDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaBienInmuebleRequest;

import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.out.PersonaBienInmuebleServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.BienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.PersonaBienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.PersonaRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.PersonaBienInmueble;

import com.codigo.mssalazaramoroto.infraestructure.entity.PersonaBienInmueblePKId;
import com.codigo.mssalazaramoroto.infraestructure.mapper.PersonaBienInmuebleMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaBienInmuebleAdapter implements PersonaBienInmuebleServiceOut {
    private final PersonaBienInmuebleRepository personaBienInmuebleRepository;
    private final PersonaRepository personaRepository;
    private final BienInmuebleRepository bienInmuebleRepository;

    @Override
    public ResponseEntity<BaseResponse> crearPersonaBienInmuebleOut(PersonaBienInmuebleRequest personaBienInmuebleRequest) {
        boolean existsPersona = personaRepository.existsById(personaBienInmuebleRequest.getPersonaId());
        boolean existsBienInmueble = bienInmuebleRepository.existsById(personaBienInmuebleRequest.getBienInmuebleId());
        BaseResponse baseResponse = new BaseResponse();
        if (existsPersona) {
            if (existsBienInmueble) {
                PersonaBienInmueble personaBienInmueble = getEntity(personaBienInmuebleRequest, false, null);
                baseResponse.setCode(Constant.CODE_POST_PERSONA_BIEN_INMUEBLE_OK);
                baseResponse.setMessage(Constant.MSG_POST_PERSONA_BIEN_INMUEBLE_OK);
                baseResponse.setEntidad(personaBienInmuebleRepository.save(personaBienInmueble));
            } else {
                baseResponse.setCode(Constant.CODE_POST_PERSONA_BIEN_INMUEBLE_NOT_EXISTS_BIEN_INMUEBLE_KO);
                baseResponse.setMessage(Constant.MSG_POST_PERSONA_BIEN_INMUEBLE_NOT_EXISTS_BIEN_INMUEBLE_KO);
                baseResponse.setEntidad(Optional.empty());
            }
        } else {
            if (existsBienInmueble) {
                baseResponse.setCode(Constant.CODE_POST_PERSONA_BIEN_INMUEBLE_NOT_EXISTS_PERSONA_KO);
                baseResponse.setMessage(Constant.MSG_POST_PERSONA_BIEN_INMUEBLE_NOT_EXISTS_PERSONA_KO);
                baseResponse.setEntidad(Optional.empty());
            } else {
                baseResponse.setCode(Constant.CODE_POST_PERSONA_BIEN_INMUEBLE_NOT_EXISTS_BIEN_INMUEBLE_PERSONA_KO);
                baseResponse.setMessage(Constant.MSG_POST_PERSONA_BIEN_INMUEBLE_NOT_EXISTS_BIEN_INMUEBLE_PERSONA_KO);
                baseResponse.setEntidad(Optional.empty());
            }
        }
        return ResponseEntity.ok(baseResponse);
    }

    /*@Override
    public ResponseEntity<BaseResponse> crearPersonaBienInmuebleOut(PersonaBienInmuebleRequest personaBienInmuebleRequest) {
        return null;
    }*/

    @Override
    public ResponseEntity<BaseResponse> buscarTodosOut() {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdOut(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarOut(Long id, PersonaBienInmuebleRequest personaBienInmuebleRequest) {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarOut(Long id) {
        return null;
    }

    /*@Override
    public List<PersonaBienInmuebleDto> buscarTodosOut() {
        List<PersonaBienInmuebleDto> listaDto = new ArrayList<>();
        List<PersonaBienInmueble> entidades = personaBienInmuebleRepository.findAll();
        for (PersonaBienInmueble dato : entidades) {
            listaDto.add(PersonaBienInmuebleMapper.fromEntity(dato));
        }
        return listaDto;
    }

    @Override
    public Optional<PersonaBienInmuebleDto> buscarPorIdOut(Long id) {
        PersonaBienInmuebleDto personaBienInmuebleDto = PersonaBienInmuebleMapper.fromEntity(personaBienInmuebleRepository.findById(id).get());
        return Optional.of(personaBienInmuebleDto);
    }

    @Override
    public PersonaBienInmuebleDto actualizarOut(Long id, PersonaBienInmuebleRequest personaBienInmuebleRequest) {
        Optional<PersonaBienInmueble> personaBienInmuebleRecuperado = personaBienInmuebleRepository.findById(id);
        if (personaBienInmuebleRecuperado.isPresent()) {
           PersonaBienInmueble personaBienInmueble = getEntity(personaBienInmuebleRequest, true, id);
            return PersonaBienInmuebleMapper.fromEntity(personaBienInmuebleRepository.save(personaBienInmueble));
        } else {
            throw new RuntimeException("No se encontro la persona bien inmueble");
        }
    }

    @Override
    public PersonaBienInmuebleDto eliminarOut(Long id) {
        Optional<PersonaBienInmueble> personaBienInmuebleRecuperado = personaBienInmuebleRepository.findById(id);
        if (personaBienInmuebleRecuperado.isPresent()) {
           personaBienInmuebleRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            personaBienInmuebleRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
           personaBienInmuebleRecuperado.get().setFechaEliminacion(getTimestamp());
            return PersonaBienInmuebleMapper.fromEntity(personaBienInmuebleRepository.save(personaBienInmuebleRecuperado.get()));
        } else {
            throw new RuntimeException("No se encontró el Tipo Bien Inmueble");
        }
    }*/

    private PersonaBienInmueble getEntity(PersonaBienInmuebleRequest personaBienInmuebleRequest, boolean actualiza, Long id) {
        PersonaBienInmueble entity = new PersonaBienInmueble();
        //entity.setBienInmueble(bienInmuebleRepository.findById(personaBienInmuebleRequest.getBienInmuebleId()).get());
        PersonaBienInmueblePKId personaBienInmueblePKId = new PersonaBienInmueblePKId(personaBienInmuebleRequest.getBienInmuebleId(), personaBienInmuebleRequest.getPersonaId());
        //entity.setPersonaBienInmueblePKId(personaBienInmueblePKId);
        entity.setEstado(personaBienInmuebleRequest.getEstado());
        //entity.setPersona(personaRepository.findById(personaBienInmuebleRequest.getPersonaId()).get());
        //entity.setEstado(personaBienInmuebleRequest.getEstado());
        if (actualiza) {
            //entity.setId(id);
            entity.setUsuarioCreacion(Constant.USU_ADMIN);
            entity.setFechaCreacion(getTimestamp());
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

