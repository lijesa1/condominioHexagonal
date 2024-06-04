package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoDocumentoRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.ports.out.TipoDocumentoServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoDocumentoRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoDocumento;
import com.codigo.mssalazaramoroto.infraestructure.mapper.TipoDocumentoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TipoDocumentoAdapter implements TipoDocumentoServiceOut {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public ResponseEntity<BaseResponse> crearTipoDocumentoServiceOut(TipoDocumentoRequest tipoDocumentoRequest) {
        boolean exist = tipoDocumentoRepository.existsByDescripcion(tipoDocumentoRequest.getDescripcion());
        BaseResponse baseResponse = new BaseResponse();
        if (!exist) {
            TipoDocumento tipoDocumentoEntity = getEntity(tipoDocumentoRequest, false, null);
            baseResponse.setCode(Constant.CODE_POST_TIPO_DOCUMENTO_OK);
            baseResponse.setMessage(Constant.MSG_POST_TIPO_DOCUMENTO_OK);
            baseResponse.setEntidad(tipoDocumentoRepository.save(tipoDocumentoEntity));
        } else {
            baseResponse.setCode(Constant.CODE_POST_TIPO_DOCUMENTO_KO);
            baseResponse.setMessage(Constant.MSG_POST_TIPO_DOCUMENTO_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> buscarTodosOut() {
        BaseResponse baseResponse = new BaseResponse();
        List<TipoDocumento> tipoDocumentoList = tipoDocumentoRepository.findAll();
        if (!tipoDocumentoList.isEmpty()) {
            baseResponse.setCode(Constant.CODE_GET_TODOS_TIPO_DOCUMENTO_OK);
            baseResponse.setMessage(Constant.MSG_GET_TODOS_TIPO_DOCUMENTO_OK);
            baseResponse.setEntidad(tipoDocumentoList);
        } else {
            baseResponse.setCode(Constant.CODE_GET_TODOS_TIPO_DOCUMENTO_KO);
            baseResponse.setMessage(Constant.MSG_GET_TODOS_TIPO_DOCUMENTO_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);

    }

    @Override
    public ResponseEntity<BaseResponse> buscarPorIdOut(Long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<TipoDocumento> tipoDocumentoBuscar = tipoDocumentoRepository.findById(id);
        if (tipoDocumentoBuscar.isPresent()) {
            baseResponse.setCode(Constant.CODE_GET_ID_TIPO_DOCUMENTO_OK);
            baseResponse.setMessage(Constant.MSG_GET_ID_TIPO_DOCUMENTO_OK);
            baseResponse.setEntidad(tipoDocumentoBuscar);
        } else {
            baseResponse.setCode(Constant.CODE_GET_ID_TIPO_DOCUMENTO_KO);
            baseResponse.setMessage(Constant.MSG_GET_ID_TIPO_DOCUMENTO_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> actualizarOut(Long id, TipoDocumentoRequest tipoDocumentoRequest) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<TipoDocumento> tipoDocumentoRecuperado = tipoDocumentoRepository.findById(id);
        if (tipoDocumentoRecuperado.isPresent()) {
            TipoDocumento tipoDocumentoEntity = getEntity(tipoDocumentoRequest, true, id);
            baseResponse.setCode(Constant.CODE_PUT_TIPO_DOCUMENTO_OK);
            baseResponse.setMessage(Constant.MSG_PUT_TIPO_DOCUMENTO_OK);
            baseResponse.setEntidad(tipoDocumentoRepository.save(tipoDocumentoEntity));
        } else {
            baseResponse.setCode(Constant.CODE_PUT_TIPO_DOCUMENTO_KO);
            baseResponse.setMessage(Constant.MSG_PUT_TIPO_DOCUMENTO_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    @Override
    public ResponseEntity<BaseResponse> eliminarOut(Long id) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<TipoDocumento> tipoDocumentoRecuperado = tipoDocumentoRepository.findById(id);
        if (tipoDocumentoRecuperado.isPresent()) {
            tipoDocumentoRecuperado.get().setEstado(Constant.STATUS_INACTIVE);
            tipoDocumentoRecuperado.get().setUsuarioEliminacion(Constant.USU_ADMIN);
            tipoDocumentoRecuperado.get().setFechaEliminacion(getTimestamp());
            baseResponse.setCode(Constant.CODE_DELETE_TIPO_DOCUMENTO_OK);
            baseResponse.setMessage(Constant.MSG_DELETE_TIPO_DOCUMENTO_OK);
            baseResponse.setEntidad(tipoDocumentoRepository.save(tipoDocumentoRecuperado.get()));
        } else {
            baseResponse.setCode(Constant.CODE_DELETE_TIPO_DOCUMENTO_KO);
            baseResponse.setMessage(Constant.MSG_DELETE_TIPO_DOCUMENTO_KO);
            baseResponse.setEntidad(Optional.empty());
        }
        return ResponseEntity.ok(baseResponse);
    }

    private TipoDocumento getEntity(TipoDocumentoRequest tipoDocumentoRequest, boolean actualiza, Long id) {
        TipoDocumento entity = new TipoDocumento();
        entity.setDescripcion(tipoDocumentoRequest.getDescripcion());
        entity.setEstado(tipoDocumentoRequest.getEstado());
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
