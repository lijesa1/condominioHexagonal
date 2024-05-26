package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;

import com.codigo.mssalazaramoroto.domain.ports.out.TipoBienInmuebleServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoBienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import com.codigo.mssalazaramoroto.infraestructure.mapper.TipoBienInmuebleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoBienInmuebleAdapter implements TipoBienInmuebleServiceOut {
    private final TipoBienInmuebleRepository tipoBienInmuebleRepository;

    @Override
    public TipoBienInmuebleDto crearTipoBienInmuebleOut(TipoBienInmuebleRequest tipoBienInmuebleRequest) {
        TipoBienInmueble tipoBienInmuebleEntity = getEntity(tipoBienInmuebleRequest, false, null);
        return TipoBienInmuebleMapper.fromEntity(tipoBienInmuebleRepository.save(tipoBienInmuebleEntity));
    }

    @Override
    public List<TipoBienInmuebleDto> buscarTodosOut() {
        List<TipoBienInmuebleDto> listaDto = new ArrayList<>();
        List<TipoBienInmueble> entidades = tipoBienInmuebleRepository.findAll();
        for (TipoBienInmueble dato : entidades) {
            listaDto.add(TipoBienInmuebleMapper.fromEntity(dato));
        }
        return listaDto;
    }

    @Override
    public Optional<TipoBienInmuebleDto> buscarPorIdOut(Long id) {
        TipoBienInmuebleDto tipoBienInmuebleDto = TipoBienInmuebleMapper.fromEntity(tipoBienInmuebleRepository.findById(id).get());
        return Optional.of(tipoBienInmuebleDto);
    }

    @Override
    public TipoBienInmuebleDto actualizarOut(Long id, TipoBienInmuebleRequest tipoBienInmuebleRequest) {
        Optional<TipoBienInmueble> tipoBienInmuebleRecuperado = tipoBienInmuebleRepository.findById(id);
        if (tipoBienInmuebleRecuperado.isPresent()) {
            TipoBienInmueble tipoBienInmueble = getEntity(tipoBienInmuebleRequest, true, id);
            return TipoBienInmuebleMapper.fromEntity(tipoBienInmuebleRepository.save(tipoBienInmueble));
        } else {
            throw new RuntimeException("No se encontro el Tipo Bien Inmueble");
        }
    }

    @Override
    public TipoBienInmuebleDto eliminarOut(Long id) {
        Optional<TipoBienInmueble> tipoBienInmuebleRecuperado = tipoBienInmuebleRepository.findById(id);
        if (tipoBienInmuebleRecuperado.isPresent()) {
            tipoBienInmuebleRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            tipoBienInmuebleRecuperado.get().setUsuaDelet(Constant.USU_ADMIN);
            tipoBienInmuebleRecuperado.get().setDateDelet(getTimestamp());
            return TipoBienInmuebleMapper.fromEntity(tipoBienInmuebleRepository.save(tipoBienInmuebleRecuperado.get()));
        } else {
            throw new RuntimeException("No se encontró el Tipo Bien Inmueble");
        }
    }

    private TipoBienInmueble getEntity(TipoBienInmuebleRequest tipoBienInmuebleRequest, boolean actualiza, Long id) {
        TipoBienInmueble entity = new TipoBienInmueble();
        entity.setDescripcion(tipoBienInmuebleRequest.getDescripcion());
        entity.setEstado(tipoBienInmuebleRequest.getEstado());
        if (actualiza) {
            entity.setId(id);
            entity.setUsuaCrea(Constant.USU_ADMIN);
            entity.setDateCreate(getTimestamp());
            entity.setUsuaModif(Constant.USU_ADMIN);
            entity.setDateModif(getTimestamp());
        } else {
            entity.setUsuaCrea(Constant.USU_ADMIN);
            entity.setDateCreate(getTimestamp());
        }
        return entity;
    }

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }
}
