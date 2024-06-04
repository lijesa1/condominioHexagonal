package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.BienInmuebleDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.BienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.out.BienInmuebleServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.BienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoBienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.BienInmueble;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import com.codigo.mssalazaramoroto.infraestructure.mapper.BienInmuebleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<BaseResponse> crearBienInmuebleOut(BienInmuebleRequest bienInmuebleRequest) {
        boolean exist = tipoBienInmuebleRepository.existsByDescripcion(bienInmuebleRequest.getTipoBienInmueble());
        BaseResponse baseResponse = new BaseResponse();
        if (!exist) {
            baseResponse.setCode(Constant.CODE_POST_BIEN_INMUEBLE_KO);
            baseResponse.setMessage(Constant.MSG_POST_BIEN_INMUEBLE_KO);
            baseResponse.setEntidad(Optional.empty());
            return ResponseEntity.ok(baseResponse);
        } else {
            BienInmueble bienInmueble = getEntity(bienInmuebleRequest, false, null);
            bienInmueble.setTipoBienInmueble(tipoBienInmuebleRepository.findByDescripcion(bienInmuebleRequest.getTipoBienInmueble()).get());
            baseResponse.setCode(Constant.CODE_POST_BIEN_INMUEBLE_OK);
            baseResponse.setMessage(Constant.MSG_POST_BIEN_INMUEBLE_OK);
            baseResponse.setEntidad(bienInmuebleRepository.save(bienInmueble));
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> buscarTodosOut() {
        BaseResponse baseResponse = new BaseResponse();
        List<BienInmueble> bienInmuebleList = bienInmuebleRepository.findAll();
        if (!bienInmuebleList.isEmpty()) {
            baseResponse.setCode(Constant.CODE_GET_TODOS_BIEN_INMUEBLE_OK);
            baseResponse.setMessage(Constant.MSG_GET_TODOS_BIEN_INMUEBLE_OK);
            baseResponse.setEntidad(bienInmuebleList);
        } else {
            baseResponse.setCode(Constant.CODE_GET_TODOS_BIEN_INMUEBLE_KO);
            baseResponse.setMessage(Constant.MSG_GET_TODOS_BIEN_INMUEBLE_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdOut(Long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<BienInmueble> bienInmuebleBuscar = bienInmuebleRepository.findById(id);
        if (bienInmuebleBuscar.isPresent()) {
            baseResponse.setCode(Constant.CODE_GET_ID_BIEN_INMUEBLE_OK);
            baseResponse.setMessage(Constant.MSG_GET_ID_BIEN_INMUEBLE_OK);
            baseResponse.setEntidad(bienInmuebleBuscar);
        } else {
            baseResponse.setCode(Constant.CODE_GET_ID_BIEN_INMUEBLE_KO);
            baseResponse.setMessage(Constant.MSG_GET_ID_BIEN_INMUEBLE_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarOut(Long id, BienInmuebleRequest bienInmuebleRequest) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<BienInmueble> bienInmuebleRecuperado = bienInmuebleRepository.findById(id);
        if (bienInmuebleRecuperado.isPresent()) {
            BienInmueble bienInmuebleEntity = getEntity(bienInmuebleRequest, true, id);
            bienInmuebleEntity.setTipoBienInmueble(tipoBienInmuebleRepository.findByDescripcion(bienInmuebleRequest.getTipoBienInmueble()).get());
            baseResponse.setCode(Constant.CODE_PUT_BIEN_INMUEBLE_OK);
            baseResponse.setMessage(Constant.MSG_PUT_BIEN_INMUEBLE_OK);
            baseResponse.setEntidad(bienInmuebleRepository.save(bienInmuebleEntity));
        } else {
            baseResponse.setCode(Constant.CODE_PUT_BIEN_INMUEBLE_KO);
            baseResponse.setMessage(Constant.MSG_PUT_BIEN_INMUEBLE_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarOut(Long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<BienInmueble> bienInmuebleRecuperado = bienInmuebleRepository.findById(id);
        if (bienInmuebleRecuperado.isPresent()) {
            bienInmuebleRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            bienInmuebleRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            bienInmuebleRecuperado.get().setFechaEliminacion(getTimestamp());
            baseResponse.setCode(Constant.CODE_DELETE_BIEN_INMUEBLE_OK);
            baseResponse.setMessage(Constant.MSG_DELETE_BIEN_INMUEBLE_OK);
            baseResponse.setEntidad(bienInmuebleRepository.save(bienInmuebleRecuperado.get()));
        } else {
            baseResponse.setCode(Constant.CODE_DELETE_BIEN_INMUEBLE_KO);
            baseResponse.setMessage(Constant.MSG_DELETE_BIEN_INMUEBLE_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
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
        entity.setNumPlaca(bienInmuebleRequest.getNumPlaca());
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
