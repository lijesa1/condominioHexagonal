package com.codigo.mssalazaramoroto.infraestructure.adapters;
import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.ports.out.BienInmuebleServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.BienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoBienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.BienInmueble;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import com.codigo.mssalazaramoroto.infraestructure.mapper.BienInmuebleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BienInmuebleAdapter implements BienInmuebleServiceOut {
    private final BienInmuebleRepository bienInmuebleRepository;
    private final TipoBienInmuebleRepository tipoBienInmuebleRepository;

    @Override
    public BienInmuebleDto crearBienInmuebleOut(BienInmuebleRequest bienInmuebleRequest) {
        BienInmueble bienInmueble = getEntity(bienInmuebleRequest, false, null);
        return BienInmuebleMapper.fromEntity(bienInmuebleRepository.save(bienInmueble));
    }

    @Override
    public List<BienInmuebleDto> buscarTodosOut() {
        List<BienInmuebleDto> listaDto = new ArrayList<>();
        List<BienInmueble> entidades = bienInmuebleRepository.findAll();
        for (BienInmueble dato : entidades) {
            listaDto.add(BienInmuebleMapper.fromEntity(dato));
        }
        return listaDto;
    }

    @Override
    public Optional<BienInmuebleDto> buscarPorIdOut(Long id) {
        BienInmuebleDto bienInmuebleDto = BienInmuebleMapper.fromEntity(bienInmuebleRepository.findById(id).get());
        return Optional.of(bienInmuebleDto);
    }

    @Override
    public BienInmuebleDto actualizarOut(Long id, BienInmuebleRequest bienInmuebleRequest) {
        Optional<BienInmueble> bienInmuebleRecuperado = bienInmuebleRepository.findById(id);
        if (bienInmuebleRecuperado.isPresent()) {
            BienInmueble bienInmuebleEntity = getEntity(bienInmuebleRequest, true, id);
            return BienInmuebleMapper.fromEntity(bienInmuebleRepository.save(bienInmuebleEntity));
        } else {
            throw new RuntimeException("No se encontró el Bien Inmueble");
        }
    }

    @Override
    public BienInmuebleDto eliminarOut(Long id) {
        Optional<BienInmueble> bienInmuebleRecuperado = bienInmuebleRepository.findById(id);
        if (bienInmuebleRecuperado.isPresent()) {
            bienInmuebleRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            bienInmuebleRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            bienInmuebleRecuperado.get().setFechaEliminacion(getTimestamp());
            return BienInmuebleMapper.fromEntity(bienInmuebleRepository.save(bienInmuebleRecuperado.get()));
        } else {
            throw new RuntimeException("No se encontró el Bien Inmueble");
        }
    }

    private BienInmueble getEntity(BienInmuebleRequest bienInmuebleRequest, boolean actualiza, Long id) {
        TipoBienInmueble tipoBienInmueble = tipoBienInmuebleRepository.findByDescripcion(bienInmuebleRequest.getTipoBienInmueble()).get();
        BienInmueble entity = new BienInmueble();
        entity.setTorre(bienInmuebleRequest.getTorre());
        entity.setPisoTorre(bienInmuebleRequest.getPisoTorre());
        entity.setNumDpto(bienInmuebleRequest.getNumDpto());
        entity.setNumEstacionamiento(bienInmuebleRequest.getNumEstacionamiento());
        entity.setNumComercio(bienInmuebleRequest.getNumComercio());
        entity.setEnUso(bienInmuebleRequest.getEnUso());
        entity.setEnAlquiler(bienInmuebleRequest.getEnAlquiler());
        entity.setEstado(bienInmuebleRequest.getEstado());
        entity.setTipoBienInmueble(tipoBienInmueble);
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
