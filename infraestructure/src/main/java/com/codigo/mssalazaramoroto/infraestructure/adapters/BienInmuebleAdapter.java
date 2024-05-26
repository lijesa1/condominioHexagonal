package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoBienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.ports.out.BienInmuebleServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.BienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoBienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.BienInmueble;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import com.codigo.mssalazaramoroto.infraestructure.mapper.BienInmuebleMapper;
import com.codigo.mssalazaramoroto.infraestructure.mapper.TipoBienInmuebleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
