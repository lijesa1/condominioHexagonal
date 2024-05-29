package com.codigo.mssalazaramoroto.infraestructure.adapters;
import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaBienInmuebleDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaBienInmuebleRequest;

import com.codigo.mssalazaramoroto.domain.ports.out.PersonaBienInmuebleServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.PersonaBienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.PersonaBienInmueble;

import com.codigo.mssalazaramoroto.infraestructure.mapper.PersonaBienInmuebleMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PersonaBienInmuebleAdapter implements PersonaBienInmuebleServiceOut {
    private final PersonaBienInmuebleRepository personaBienInmuebleRepository;


    @Override
    public PersonaBienInmuebleDto crearPersonaBienInmuebleOut(PersonaBienInmuebleRequest personaBienInmuebleRequest) {
        PersonaBienInmueble personaBienInmuebleEntity = getEntity(personaBienInmuebleRequest, false, null);
        return PersonaBienInmuebleMapper.fromEntity(personaBienInmuebleRepository.save(personaBienInmuebleEntity));
    }

    @Override
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
    }

        private PersonaBienInmueble getEntity(PersonaBienInmuebleRequest  personaBienInmuebleRequest, boolean actualiza, Long id) {
            PersonaBienInmueble entity = new PersonaBienInmueble();
           // entity.setsetBienInmueble(personaBienInmuebleRequest.getpersonaBienInmuebleId());
            entity.setEstado(personaBienInmuebleRequest.getEstado());
            if (actualiza) {
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

