package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoDocumentoDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoDocumentoRequest;
import com.codigo.mssalazaramoroto.domain.ports.out.TipoDocumentoServiceOut;

import com.codigo.mssalazaramoroto.infraestructure.dao.TipoDocumentoRepository;

import com.codigo.mssalazaramoroto.infraestructure.entity.TipoDocumento;
import com.codigo.mssalazaramoroto.infraestructure.mapper.TipoDocumentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoDocumentoAdapter implements TipoDocumentoServiceOut {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public TipoDocumentoDto crearTipoDocumentoServiceOut(TipoDocumentoRequest tipoDocumentoRequest) {
        TipoDocumento tipoDocumentoEntity = getEntity(tipoDocumentoRequest, false, null);
        return TipoDocumentoMapper.fromEntity(tipoDocumentoRepository.save(tipoDocumentoEntity));
    }

    @Override
    public List<TipoDocumentoDto> buscarTodosOut() {
        List<TipoDocumentoDto> listaDto = new ArrayList<>();
        List<TipoDocumento> entidades = tipoDocumentoRepository.findAll();
        for (TipoDocumento dato : entidades) {
            listaDto.add(TipoDocumentoMapper.fromEntity(dato));
        }
        return listaDto;
    }

    @Override
    public Optional<TipoDocumentoDto> buscarPorIdOut(Long id) {
        TipoDocumentoDto tipoDocumentoDto = TipoDocumentoMapper.fromEntity(tipoDocumentoRepository.findById(id).get());
        return Optional.of(tipoDocumentoDto);
    }

    @Override
    public TipoDocumentoDto actualizarOut(Long id, TipoDocumentoRequest tipoDocumentoRequest) {
        Optional<TipoDocumento> tipoDocumentoRecuperado = tipoDocumentoRepository.findById(id);
        if (tipoDocumentoRecuperado.isPresent()) {
            TipoDocumento tipoDocumentoEntity = getEntity(tipoDocumentoRequest, true, id);
            return TipoDocumentoMapper.fromEntity(tipoDocumentoRepository.save(tipoDocumentoEntity));
        } else {
            throw new RuntimeException("No se encontró el TipoDocumento");
        }
    }

    @Override
    public TipoDocumentoDto eliminarOut(Long id) {
        Optional<TipoDocumento> tipoDocumentoRecuperado = tipoDocumentoRepository.findById(id);
        if(tipoDocumentoRecuperado.isPresent()){
            tipoDocumentoRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            tipoDocumentoRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            tipoDocumentoRecuperado.get().setFechaEliminacion(getTimestamp());
            return TipoDocumentoMapper.fromEntity(tipoDocumentoRepository.save(tipoDocumentoRecuperado.get()));
        }else{
            throw new RuntimeException("No se encontró el TipoDocumento");
        }
    }

    private TipoDocumento getEntity(TipoDocumentoRequest tipoDocumentoRequest, boolean actualiza, Long id) {
        TipoDocumento entity = new TipoDocumento();
        entity.setTipoDocumento(tipoDocumentoRequest.getTipoDocumento());
        if (actualiza) {
            entity.setId(id);
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
