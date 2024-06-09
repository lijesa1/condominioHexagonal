package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.DetalleLibroVisitaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.DetalleLibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.out.DetalleLibroVisitaServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.DetalleLibroVisitaRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.LibroVisitaRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.PersonaRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.DetalleLibroVisita;
import com.codigo.mssalazaramoroto.infraestructure.entity.LibroVisita;
import com.codigo.mssalazaramoroto.infraestructure.entity.Persona;
import com.codigo.mssalazaramoroto.infraestructure.mapper.DetalleLibroVisitaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetalleLibroVisitaAdapter implements DetalleLibroVisitaServiceOut {

    private final DetalleLibroVisitaRepository detalleLibroVisitaRepository;
    private final LibroVisitaRepository libroVisitaRepository;
    private final PersonaRepository personaRepository;

    @Override
    public ResponseEntity<BaseResponse> crearDetalleLibroVisitaOut(DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        Optional<LibroVisita> libroVisita = libroVisitaRepository.findById(detalleLibroVisitaRequest.getLibroVisitaId());
        BaseResponse baseResponse = new BaseResponse();
        if (libroVisita == null) {
            System.out.println("No se identificó el libro de visita");
            baseResponse.setCode(Constant.CODE_POST_DETALLE_LIBRO_VISITA_LIBRO_VISITA_KO);
            baseResponse.setMessage(Constant.MSG_POST_DETALLE_LIBRO_VISITA_LIBRO_VISITA_KO);
            baseResponse.setEntidad(Optional.empty());
        } else {
            System.out.println("Se identificó el libro de visita");
            Optional<Persona> persona = personaRepository.findById(detalleLibroVisitaRequest.getPersonaVisitante());
            if (persona == null) {
                System.out.println("No se identificó a la persona visitante");
                baseResponse.setCode(Constant.CODE_POST_DETALLE_LIBRO_VISITA_PERSONA_KO);
                baseResponse.setMessage(Constant.MSG_POST_DETALLE_LIBRO_VISITA_PERSONA_KO);
                baseResponse.setEntidad(Optional.empty());
            } else {
                System.out.println("Libro de visita y persona visitante identificadas OK");
                DetalleLibroVisita detalleLibroVisita = getEntity(detalleLibroVisitaRequest, false, null);
                baseResponse.setCode(Constant.CODE_POST_DETALLE_LIBRO_VISITA_OK);
                baseResponse.setMessage(Constant.MSG_POST_DETALLE_LIBRO_VISITA_OK);
                baseResponse.setEntidad(detalleLibroVisitaRepository.save(detalleLibroVisita));
            }
        }
        return ResponseEntity.ok(baseResponse);

/*        boolean exist = detalleLibroVisitaRepository.existsByObservacionesPersonaVisitante(detalleLibroVisitaRequest.getObservacionesPersonaVisitante());
        DetalleLibroVisita detalleLibroVisitaEntity = getEntity(detalleLibroVisitaRequest, false, null);
        return DetalleLibroVisitaMapper.fromEntity(detalleLibroVisitaRepository.save(detalleLibroVisitaEntity));*/
    }

    @Override
    public ResponseEntity<BaseResponse> buscarTodosOut() {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdOut(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarOut(Long id, DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarOut(Long id) {
        return null;
    }

    /*@Override
    public ResponseEntity<BaseResponse> buscarTodosOut() {
        List<DetalleLibroVisitaDto> listaDto = new ArrayList<>();
        List<DetalleLibroVisita> entidades = detalleLibroVisitaRepository.findAll();
        for (DetalleLibroVisita dato : entidades) {
            listaDto.add(DetalleLibroVisitaMapper.fromEntity(dato));
        }
        return listaDto;
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdOut(Long id) {
        DetalleLibroVisitaDto detalleLibroVisitaDto = DetalleLibroVisitaMapper.fromEntity(detalleLibroVisitaRepository.findById(id).get());
        return Optional.of(detalleLibroVisitaDto);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarOut(Long id, DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        Optional<DetalleLibroVisita> detalleLibroVisitaRecuperado = detalleLibroVisitaRepository.findById(id);
        if (detalleLibroVisitaRecuperado.isPresent()) {
            DetalleLibroVisita detalleLibroVisita = getEntity(detalleLibroVisitaRequest, true, id);
            return DetalleLibroVisitaMapper.fromEntity(detalleLibroVisitaRepository.save(detalleLibroVisita));
        } else {
            throw new RuntimeException("No se encontro el Tipo Bien Inmueble");
        }
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarOut(Long id) {
        Optional<DetalleLibroVisita> detalleLibroVisitaRecuperado = detalleLibroVisitaRepository.findById(id);
        if (detalleLibroVisitaRecuperado.isPresent()) {
            detalleLibroVisitaRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            detalleLibroVisitaRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            detalleLibroVisitaRecuperado.get().setFechaEliminacion(getTimestamp());
            return DetalleLibroVisitaMapper.fromEntity(detalleLibroVisitaRepository.save(detalleLibroVisitaRecuperado.get()));
        } else {
            throw new RuntimeException("No se encontró el Tipo Bien Inmueble");
        }
    }*/


    private DetalleLibroVisita getEntity(DetalleLibroVisitaRequest detalleLibroVisitaRequest, boolean actualiza, Long id) {
        DetalleLibroVisita entity = new DetalleLibroVisita();
        entity.setObservacionesPersonaVisitante(detalleLibroVisitaRequest.getObservacionesPersonaVisitante());
        entity.setEstadoVisitante(detalleLibroVisitaRequest.getEstadoVisitante());
        entity.setLibroVisita(libroVisitaRepository.findById(detalleLibroVisitaRequest.getLibroVisitaId()).get());
        entity.setPersona(personaRepository.findById(detalleLibroVisitaRequest.getPersonaVisitante()).get());
        if (actualiza) {
            entity.setId(id);
            entity.setUsuarioCreacion(Constant.USU_ADMIN);
            entity.setFechaCreacion(getTimestamp());
            entity.setUsuarioActualizacion(Constant.USU_ADMIN);
            entity.setFechaActualizacion(getTimestamp());
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
