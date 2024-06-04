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
    private final TipoBienInmuebleMapper tipoBienInmuebleMapper;

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
            tipoBienInmuebleRecuperado.get().setUsuarioCreacion(tipoBienInmuebleEntity.getUsuarioCreacion());
            tipoBienInmuebleRecuperado.get().setFechaCreacion(tipoBienInmuebleEntity.getFechaCreacion());
            tipoBienInmuebleRecuperado.get().setUsuarioActualizacion(Constant.USU_ADMIN);
            tipoBienInmuebleRecuperado.get().setFechaActualizacion(getTimestamp());
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


    /*@Override
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
            tipoBienInmuebleRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            tipoBienInmuebleRecuperado.get().setFechaEliminacion(getTimestamp());
            return TipoBienInmuebleMapper.fromEntity(tipoBienInmuebleRepository.save(tipoBienInmuebleRecuperado.get()));
        } else {
            throw new RuntimeException("No se encontró el Tipo Bien Inmueble");
        }
    }*/

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
