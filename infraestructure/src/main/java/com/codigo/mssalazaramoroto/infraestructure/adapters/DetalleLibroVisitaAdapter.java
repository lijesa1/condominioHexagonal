package com.codigo.mssalazaramoroto.infraestructure.adapters;
import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.DetalleLibroVisitaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.DetalleLibroVisitaRequest;
import com.codigo.mssalazaramoroto.domain.ports.out.DetalleLibroVisitaServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.DetalleLibroVisitaRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.DetalleLibroVisita;
import com.codigo.mssalazaramoroto.infraestructure.mapper.DetalleLibroVisitaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetalleLibroVisitaAdapter implements DetalleLibroVisitaServiceOut {

    private final DetalleLibroVisitaRepository detalleLibroVisitaRepository;
    @Override
    public DetalleLibroVisitaDto crearDetalleLibroVisitaOut(DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        DetalleLibroVisita detalleLibroVisitaEntity = getEntity(detalleLibroVisitaRequest, false, null);
        return DetalleLibroVisitaMapper.fromEntity(detalleLibroVisitaRepository.save(detalleLibroVisitaEntity));
    }

    @Override
    public List<DetalleLibroVisitaDto> buscarTodosOut() {
        List<DetalleLibroVisitaDto> listaDto = new ArrayList<>();
        List<DetalleLibroVisita> entidades = detalleLibroVisitaRepository.findAll();
        for (DetalleLibroVisita dato : entidades) {
            listaDto.add(DetalleLibroVisitaMapper.fromEntity(dato));
        }
        return listaDto;
    }

    @Override
    public Optional<DetalleLibroVisitaDto> buscarPorIdOut(Long id) {
        DetalleLibroVisitaDto detalleLibroVisitaDto = DetalleLibroVisitaMapper.fromEntity(detalleLibroVisitaRepository.findById(id).get());
        return Optional.of(detalleLibroVisitaDto);
    }

    @Override
    public DetalleLibroVisitaDto actualizarOut(Long id, DetalleLibroVisitaRequest detalleLibroVisitaRequest) {
        Optional<DetalleLibroVisita> detalleLibroVisitaRecuperado = detalleLibroVisitaRepository.findById(id);
        if (detalleLibroVisitaRecuperado.isPresent()) {
            DetalleLibroVisita detalleLibroVisita = getEntity(detalleLibroVisitaRequest, true, id);
            return DetalleLibroVisitaMapper.fromEntity(detalleLibroVisitaRepository.save(detalleLibroVisita));
        } else {
            throw new RuntimeException("No se encontro el Tipo Bien Inmueble");
        }
    }

    @Override
    public DetalleLibroVisitaDto eliminarOut(Long id) {
        Optional<DetalleLibroVisita> detalleLibroVisitaRecuperado = detalleLibroVisitaRepository.findById(id);
        if (detalleLibroVisitaRecuperado.isPresent()) {
            detalleLibroVisitaRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            detalleLibroVisitaRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            detalleLibroVisitaRecuperado.get().setFechaEliminacion(getTimestamp());
            return DetalleLibroVisitaMapper.fromEntity(detalleLibroVisitaRepository.save(detalleLibroVisitaRecuperado.get()));
        } else {
            throw new RuntimeException("No se encontró el Tipo Bien Inmueble");
        }
    }


    private DetalleLibroVisita getEntity(DetalleLibroVisitaRequest detalleLibroVisitaRequest, boolean actualiza, Long id) {
        DetalleLibroVisita entity = new DetalleLibroVisita();
        entity.setObservacionesPersonaVisitante(detalleLibroVisitaRequest.getObservacionesPersonaVisitante());
        entity.setEstado(detalleLibroVisitaRequest.getEstado());
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
