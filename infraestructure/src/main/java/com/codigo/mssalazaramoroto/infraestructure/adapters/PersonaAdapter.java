package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.ReniecDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.ports.out.PersonaServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.client.ClientReniec;
import com.codigo.mssalazaramoroto.infraestructure.dao.EmpresaRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.PersonaRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.Empresa;
import com.codigo.mssalazaramoroto.infraestructure.entity.Persona;
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
    private final EmpresaRepository empresaRepository;
    private final ClientReniec clientReniec;
    private final RedisService redisService;

    @Value("${token.reniec}")
    private String tokenReniec;

    @Override
    public PersonaDto crearPersonaOut(PersonaRequest personaRequest) {
        Persona personaEntity = getEntity(personaRequest, false, null);
        return PersonaMapper.fromEntity(personaRepository.save(personaEntity));
    }

    private Persona getEntity(PersonaRequest personaRequest, boolean actualiza, Long id) {
        //Exec servicio
        ReniecDto reniecDto = getExecReniec(personaRequest.getNumDoc());
        Empresa empresa = empresaRepository.findByNumeroDocumento(personaRequest.getEmpresa()).get();
        Persona entity = new Persona();
        entity.setNombre(reniecDto.getNombres());
        entity.setApellido(reniecDto.getApellidoPaterno() + " " + reniecDto.getApellidoMaterno());
        entity.setTipoDocumento(reniecDto.getTipoDocumento());
        entity.setNumeroDocumento(reniecDto.getNumeroDocumento());
        entity.setEmail(personaRequest.getEmail());
        entity.setEstado(Constant.STATUS_ACTIVE);
        entity.setTelefono(personaRequest.getTelefono());
        entity.setDireccion(personaRequest.getDireccion());
        entity.setEmpresa(empresa);
        //Datos de auditoria donde corresponda

        if (actualiza) {
            //si Actualizo hago esto
            entity.setId(id);
            entity.setUsuaModif(Constant.USU_ADMIN);
            entity.setDateModif(getTimestamp());

        } else {
            //Sino Actualizo hago esto
            entity.setUsuaCrea(Constant.USU_ADMIN);
            entity.setDateCreate(getTimestamp());
        }

        return entity;
    }


    private ReniecDto getExecReniec(String numDoc) {
        String authorization = "Bearer " + tokenReniec;
        return clientReniec.getInfoReniec(numDoc, authorization);
    }

    private Timestamp getTimestamp() {
        long currenTIme = System.currentTimeMillis();
        return new Timestamp(currenTIme);
    }

    @Override
    public Optional<PersonaDto> buscarXIdOut(Long id) {
        String redisInfo = redisService.getFromRedis(Constant.REDIS_KEY_OBTENERPERSONA + id);
        if (redisInfo != null) {
            PersonaDto personaDto = Util.convertirDesdeString(redisInfo, PersonaDto.class);
            return Optional.of(personaDto);
        } else {
            PersonaDto personaDto = PersonaMapper.fromEntity(personaRepository.findById(id).get());
            String dataForRedis = Util.convertirAString(personaDto);
            redisService.saveInRedis(Constant.REDIS_KEY_OBTENERPERSONA + id, dataForRedis, 2);
            return Optional.of(personaDto);
        }
    }

    @Override
    public List<PersonaDto> obtenerTodosOut() {
        List<PersonaDto> listaDto = new ArrayList<>();
        List<Persona> entidades = personaRepository.findAll();
        for (Persona dato : entidades) {
            listaDto.add(PersonaMapper.fromEntity(dato));
        }
        return listaDto;
    }

    @Override
    public PersonaDto actualziarOut(Long id, PersonaRequest personaRequest) {
        Optional<Persona> datoExtraido = personaRepository.findById(id);
        if (datoExtraido.isPresent()) {
            Persona personaEntity = getEntity(personaRequest, true, id);
            return PersonaMapper.fromEntity(personaRepository.save(personaEntity));
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public PersonaDto deleteOut(Long id) {
        Optional<Persona> datoExtraido = personaRepository.findById(id);
        if (datoExtraido.isPresent()) {
            datoExtraido.get().setEstado(0);
            datoExtraido.get().setUsuaDelet(Constant.USU_ADMIN);
            datoExtraido.get().setDateDelet(getTimestamp());
            return PersonaMapper.fromEntity(personaRepository.save(datoExtraido.get()));
        } else {
            throw new RuntimeException();
        }
    }
}
