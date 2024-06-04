package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.TipoPersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoPersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.out.TipoPersonaServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoPersonaRepository;



import com.codigo.mssalazaramoroto.infraestructure.entity.TipoPersona;


import com.codigo.mssalazaramoroto.infraestructure.mapper.TipoPersonaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoPersonaAdapter implements TipoPersonaServiceOut {

    private final TipoPersonaRepository tipoPersonaRepository;

   /* @Override
    public TipoPersonaDto crearTipoPersonaOut(TipoPersonaRequest tipoPersonaRequest) {
        TipoPersona tipoPersonaEntity = getEntity(tipoPersonaRequest, false, null);
        return TipoPersonaMapper.fromEntity(tipoPersonaRepository.save(tipoPersonaEntity));
    }

    @Override
    public List<TipoPersonaDto> buscarTodosOut() {
        List<TipoPersonaDto> listaDto = new ArrayList<>();
        List<TipoPersona> entidades = tipoPersonaRepository.findAll();
        for (TipoPersona dato : entidades) {
            listaDto.add(TipoPersonaMapper.fromEntity(dato));
        }
        return listaDto;
    }

    @Override
    public Optional<TipoPersonaDto> buscarPorIdOut(Long id) {
        TipoPersonaDto tipoPersonaDto = TipoPersonaMapper.fromEntity(tipoPersonaRepository.findById(id).get());
        return Optional.of(tipoPersonaDto);
    }

    @Override
    public TipoPersonaDto actualizarOut(Long id, TipoPersonaRequest tipoPersonaRequest) {
        Optional<TipoPersona> tipoPersonaRecuperado = tipoPersonaRepository.findById(id);
        if (tipoPersonaRecuperado.isPresent()) {
            TipoPersona tipoPersona = getEntity(tipoPersonaRequest, true, id);
            return TipoPersonaMapper.fromEntity(tipoPersonaRepository.save(tipoPersona));
        } else {
            throw new RuntimeException("No se encontro el Tipo de Persona");
        }
    }

    @Override
    public TipoPersonaDto eliminarOut(Long id) {
        Optional<TipoPersona> tipoPersonaRecuperado = tipoPersonaRepository.findById(id);
        if (tipoPersonaRecuperado.isPresent()) {
            tipoPersonaRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            tipoPersonaRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            tipoPersonaRecuperado.get().setFechaEliminacion(getTimestamp());
            return TipoPersonaMapper.fromEntity(tipoPersonaRepository.save(tipoPersonaRecuperado.get()));
        } else {
            throw new RuntimeException("No se encontró el Tipo de Persona");
        }
    }*/


    private TipoPersona getEntity(TipoPersonaRequest tipoPersonaRequest, boolean actualiza, Long id) {
        TipoPersona entity = new TipoPersona();
        entity.setDescripcion(tipoPersonaRequest.getDescripcion());
        entity.setEstado(tipoPersonaRequest.getEstado());
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

    @Override
    public ResponseEntity<BaseResponse> crearTipoPersonaOut(TipoPersonaRequest tipoPersonaRequest) {
        boolean exist = tipoPersonaRepository.existsByDescripcion(tipoPersonaRequest.getDescripcion());
        BaseResponse baseResponse = new BaseResponse();
        if (!exist) {
            TipoPersona tipoPersonaEntity = getEntity(tipoPersonaRequest, false, null);
            baseResponse.setCode(Constant.CODE_POST_TIPO_PERSONA_OK);
            baseResponse.setMessage(Constant.MSG_POST_TIPO_PERSONA_OK);
            baseResponse.setEntidad(Optional.of(tipoPersonaRepository.save(tipoPersonaEntity)));
        } else {
            baseResponse.setCode(Constant.CODE_POST_TIPO_PERSONA_KO);
            baseResponse.setMessage(Constant.MSG_POST_TIPO_PERSONA_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> buscarTodosOut() {
        BaseResponse baseResponse = new BaseResponse();
        List<TipoPersona> tipoPersonaList = tipoPersonaRepository.findAll();
        if (!tipoPersonaList.isEmpty()) {
            baseResponse.setCode(Constant.CODE_GET_TODOS_TIPO_PERSONA_OK);
            baseResponse.setMessage(Constant.MSG_GET_TODOS_TIPO_PERSONA_OK);
            baseResponse.setEntidad(Optional.of(tipoPersonaList));
        } else {
            baseResponse.setCode(Constant.CODE_GET_TODOS_TIPO_PERSONA_KO);
            baseResponse.setMessage(Constant.MSG_GET_TODOS_TIPO_PERSONA_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdOut(Long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<TipoPersona> tipoPersonaBuscar = tipoPersonaRepository.findById(id);
        if (tipoPersonaBuscar.isPresent()) {
            baseResponse.setCode(Constant.CODE_GET_ID_TIPO_PERSONA_OK);
            baseResponse.setMessage(Constant.MSG_GET_ID_TIPO_PERSONA_OK);
            baseResponse.setEntidad(Optional.of(tipoPersonaBuscar));
        } else {
            baseResponse.setCode(Constant.CODE_GET_ID_TIPO_PERSONA_KO);
            baseResponse.setMessage(Constant.MSG_GET_ID_TIPO_PERSONA_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarOut(Long id, TipoPersonaRequest TipoPersonaRequest) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<TipoPersona> tipoPersonaRecuperado = tipoPersonaRepository.findById(id);
        if (tipoPersonaRecuperado.isPresent()) {
            TipoPersona tipoPersonaEntity = getEntity(TipoPersonaRequest, true, id);
            baseResponse.setCode(Constant.CODE_PUT_TIPO_PERSONA_OK);
            baseResponse.setMessage(Constant.MSG_PUT_TIPO_PERSONA_OK);
            tipoPersonaEntity.setEstado(tipoPersonaRecuperado.get().getEstado());
            tipoPersonaEntity.setUsuarioCreacion(tipoPersonaRecuperado.get().getUsuarioCreacion());
            tipoPersonaEntity.setFechaCreacion(tipoPersonaRecuperado.get().getFechaCreacion());
            tipoPersonaEntity.setUsuarioModificacion(Constant.USU_ADMIN);
            tipoPersonaEntity.setFechaModificacion(getTimestamp());
            baseResponse.setEntidad(Optional.of(tipoPersonaRepository.save(tipoPersonaEntity)));
        } else {
            baseResponse.setCode(Constant.CODE_PUT_TIPO_PERSONA_KO);
            baseResponse.setMessage(Constant.MSG_PUT_TIPO_PERSONA_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarOut(Long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<TipoPersona> tipoPersonaRecuperado = tipoPersonaRepository.findById(id);
        if (tipoPersonaRecuperado.isPresent()) {
            tipoPersonaRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            tipoPersonaRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            tipoPersonaRecuperado.get().setFechaEliminacion(getTimestamp());
            baseResponse.setCode(Constant.CODE_DELETE_TIPO_PERSONA_OK);
            baseResponse.setMessage(Constant.MSG_DELETE_TIPO_PERSONA_OK);
            baseResponse.setEntidad(Optional.of(tipoPersonaRepository.save(tipoPersonaRecuperado.get())));
        } else {
            baseResponse.setCode(Constant.CODE_DELETE_TIPO_PERSONA_KO);
            baseResponse.setMessage(Constant.MSG_DELETE_TIPO_PERSONA_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }


}
