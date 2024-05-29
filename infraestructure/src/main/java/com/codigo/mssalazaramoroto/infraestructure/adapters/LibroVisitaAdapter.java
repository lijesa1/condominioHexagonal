package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.LibroVisitaDto;

import com.codigo.mssalazaramoroto.domain.aggregates.request.LibroVisitaRequest;

import com.codigo.mssalazaramoroto.domain.ports.out.LibroVisitaServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.LibroVisitaRepository;

import com.codigo.mssalazaramoroto.infraestructure.entity.LibroVisita;

import com.codigo.mssalazaramoroto.infraestructure.mapper.LibroVisitaMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibroVisitaAdapter implements LibroVisitaServiceOut {

    private final LibroVisitaRepository libroVisitaRepository;


    @Override
    public LibroVisitaDto crearLibroVisitaServiceOut(LibroVisitaRequest libroVisitaRequest) {
        LibroVisita libroVisitaDtoEntity = getEntity(libroVisitaRequest, false, null);
        return LibroVisitaMapper.fromEntity(libroVisitaRepository.save(libroVisitaDtoEntity));
    }

    @Override
    public List<LibroVisitaDto> buscarTodosOut() {
        List<LibroVisitaDto> listaDto = new ArrayList<>();
        List<LibroVisita> entidades = libroVisitaRepository.findAll();
        for (LibroVisita dato : entidades) {
            listaDto.add(LibroVisitaMapper.fromEntity(dato));
        }
        return listaDto;
    }

    @Override
    public Optional<LibroVisitaDto> buscarPorIdOut(Long id) {
        LibroVisitaDto libroVisitaDto = LibroVisitaMapper.fromEntity(libroVisitaRepository.findById(id).get());
        return Optional.of(libroVisitaDto);
    }

    @Override
    public LibroVisitaDto actualizarOut(Long id, LibroVisitaRequest libroVisitaRequest) {
        Optional<LibroVisita> libroVisitaRecuperado = libroVisitaRepository.findById(id);
        if (libroVisitaRecuperado.isPresent()) {
            LibroVisita libroVisita = getEntity(libroVisitaRequest, true, id);
            return LibroVisitaMapper.fromEntity(libroVisitaRepository.save(libroVisita));
        } else {
            throw new RuntimeException("No se encontro el Tipo Bien Inmueble");
        }
    }

    @Override
    public LibroVisitaDto eliminarOut(Long id) {
        Optional<LibroVisita> LibroVisitaRecuperado = libroVisitaRepository.findById(id);
        if (LibroVisitaRecuperado.isPresent()) {
            LibroVisitaRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            LibroVisitaRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            LibroVisitaRecuperado.get().setFechaEliminacion(getTimestamp());
            return LibroVisitaMapper.fromEntity(libroVisitaRepository.save(LibroVisitaRecuperado.get()));
        } else {
            throw new RuntimeException("No se encontró el libro visita");
        }
    }

    private LibroVisita getEntity(LibroVisitaRequest libroVisitaRequest, boolean actualiza, Long id) {
        LibroVisita entity = new LibroVisita();
       // entity.setDescripcion(libroVisitaRequest.getDescripcion());
        //entity.setEstado(libroVisitaRequest.getEstado());
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
