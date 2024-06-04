package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.out.TipoBienInmuebleServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoBienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import com.codigo.mssalazaramoroto.infraestructure.mapper.TipoBienInmuebleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoBienInmuebleAdapter implements TipoBienInmuebleServiceOut {
    private final TipoBienInmuebleRepository tipoBienInmuebleRepository;

    @Override
    public ResponseEntity<BaseResponse> crearTipoBienInmuebleOut(TipoBienInmuebleRequest tipoBienInmuebleRequest) {
        boolean exist = tipoBienInmuebleRepository.existsByDescripcion(tipoBienInmuebleRequest.getDescripcion());
        BaseResponse baseResponse = new BaseResponse();
        if (!exist) {
            TipoBienInmueble tipoBienInmuebleEntity = getEntity(tipoBienInmuebleRequest, false, null);
            baseResponse.setCode(Constant.CODE_POST_TIPO_BIEN_INMUEBLE_OK);
            baseResponse.setMessage(Constant.MSG_POST_TIPO_BIEN_INMUEBLE_OK);
            baseResponse.setEntidad(tipoBienInmuebleRepository.save(tipoBienInmuebleEntity));
        } else {
            baseResponse.setCode(Constant.CODE_POST_TIPO_BIEN_INMUEBLE_KO);
            baseResponse.setMessage(Constant.MSG_POST_TIPO_BIEN_INMUEBLE_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> buscarTodosOut() {
        BaseResponse baseResponse = new BaseResponse();
        List<TipoBienInmueble> tipoBienInmuebleList = tipoBienInmuebleRepository.findAll();
        if (!tipoBienInmuebleList.isEmpty()) {
            baseResponse.setCode(Constant.CODE_GET_TODOS_TIPO_BIEN_INMUEBLE_OK);
            baseResponse.setMessage(Constant.MSG_GET_TODOS_TIPO_BIEN_INMUEBLE_OK);
            baseResponse.setEntidad(tipoBienInmuebleList);
        } else {
            baseResponse.setCode(Constant.CODE_GET_TODOS_TIPO_BIEN_INMUEBLE_KO);
            baseResponse.setMessage(Constant.MSG_GET_TODOS_TIPO_BIEN_INMUEBLE_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdOut(Long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<TipoBienInmueble> tipoBienInmuebleBuscar = tipoBienInmuebleRepository.findById(id);
        if (tipoBienInmuebleBuscar.isPresent()) {
            baseResponse.setCode(Constant.CODE_GET_ID_TIPO_BIEN_INMUEBLE_OK);
            baseResponse.setMessage(Constant.MSG_GET_ID_TIPO_BIEN_INMUEBLE_OK);
            baseResponse.setEntidad(tipoBienInmuebleBuscar);
        } else {
            baseResponse.setCode(Constant.CODE_GET_ID_TIPO_BIEN_INMUEBLE_KO);
            baseResponse.setMessage(Constant.MSG_GET_ID_TIPO_BIEN_INMUEBLE_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarOut(Long id, TipoBienInmuebleRequest tipoBienInmuebleRequest) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<TipoBienInmueble> tipoBienInmuebleRecuperado = tipoBienInmuebleRepository.findById(id);
        if (tipoBienInmuebleRecuperado.isPresent()) {
            TipoBienInmueble tipoBienInmuebleEntity = getEntity(tipoBienInmuebleRequest, true, id);
            baseResponse.setCode(Constant.CODE_PUT_ID_TIPO_BIEN_INMUEBLE_OK);
            baseResponse.setMessage(Constant.MSG_PUT_ID_TIPO_BIEN_INMUEBLE_OK);
            tipoBienInmuebleEntity.setEstado(tipoBienInmuebleRecuperado.get().getEstado());
            tipoBienInmuebleEntity.setUsuarioCreacion(tipoBienInmuebleRecuperado.get().getUsuarioCreacion());
            tipoBienInmuebleEntity.setFechaCreacion(tipoBienInmuebleRecuperado.get().getFechaCreacion());
            tipoBienInmuebleEntity.setUsuarioActualizacion(Constant.USU_ADMIN);
            tipoBienInmuebleEntity.setFechaActualizacion(getTimestamp());
            baseResponse.setEntidad(tipoBienInmuebleRepository.save(tipoBienInmuebleEntity));
        } else {
            baseResponse.setCode(Constant.CODE_PUT_ID_TIPO_BIEN_INMUEBLE_KO);
            baseResponse.setMessage(Constant.MSG_PUT_ID_TIPO_BIEN_INMUEBLE_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarOut(Long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<TipoBienInmueble> tipoBienInmuebleRecuperado = tipoBienInmuebleRepository.findById(id);
        if (tipoBienInmuebleRecuperado.isPresent()) {
            baseResponse.setCode(Constant.CODE_DELETE_ID_TIPO_BIEN_INMUEBLE_OK);
            baseResponse.setMessage(Constant.MSG_DELETE_ID_TIPO_BIEN_INMUEBLE_OK);
            tipoBienInmuebleRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            tipoBienInmuebleRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            tipoBienInmuebleRecuperado.get().setFechaEliminacion(getTimestamp());
            baseResponse.setEntidad(tipoBienInmuebleRecuperado);
        } else {
            baseResponse.setCode(Constant.CODE_DELETE_ID_TIPO_BIEN_INMUEBLE_KO);
            baseResponse.setMessage(Constant.MSG_DELETE_ID_TIPO_BIEN_INMUEBLE_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    private TipoBienInmueble getEntity(TipoBienInmuebleRequest tipoBienInmuebleRequest, boolean actualiza, Long id) {
        TipoBienInmueble entity = new TipoBienInmueble();
        entity.setDescripcion(tipoBienInmuebleRequest.getDescripcion());
        entity.setEstado(tipoBienInmuebleRequest.getEstado());
        if (actualiza) {
            entity.setId(id);
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
