package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.EmpresaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.SunatDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.EmpresaRequest;
import com.codigo.mssalazaramoroto.domain.ports.out.EmpresaServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.EmpresaRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.Empresa;
import com.codigo.mssalazaramoroto.infraestructure.mapper.EmpresaMapper;
import com.codigo.mssalazaramoroto.infraestructure.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.codigo.mssalazaramoroto.infraestructure.client.ClientSunat;

import java.sql.Timestamp;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaAdapter implements EmpresaServiceOut {
    private final EmpresaRepository empresaRepository;
    private final ClientSunat clientSunat;
    private final RedisService redisService;

    @Value("${token.sunat}")
    private String tokenSunat;

    @Override
    public EmpresaDto crearEmpresaOut(EmpresaRequest empresaRequest) {
        Empresa empresaEntity = getEntity(empresaRequest, false, null);
        return EmpresaMapper.fromEntity(empresaRepository.save(empresaEntity));
    }

    @Override
    public Optional<EmpresaDto> obtenerEmpresaByNumeroDocumentoOut(String numDoc) {
        Optional<Empresa> empresa = empresaRepository.findByNumeroDocumento(numDoc);
        return empresa.map(EmpresaMapper::fromEntity);
    }

    private Empresa getEntity(EmpresaRequest empresaRequest, boolean actualiza, Long id) {
        //Exec servicio
        SunatDto sunatDto = getExecSunat(empresaRequest.getNumDoc());
        Empresa entity = new Empresa();
        entity.setRazonSocial(sunatDto.getRazonSocial());
        entity.setTipoDocumento(sunatDto.getTipoDocumento());
        entity.setNumeroDocumento(sunatDto.getNumeroDocumento());
        entity.setEstado(Constant.STATUS_ACTIVE);
        entity.setCondicion(sunatDto.getCondicion());
        entity.setDireccion(sunatDto.getDireccion());
        entity.setDistrito(sunatDto.getDistrito());
        entity.setProvincia(sunatDto.getProvincia());
        entity.setDepartamento(sunatDto.getDepartamento());
        entity.setEsAgenteRetencion(sunatDto.isEsAgenteRetencion());
        //Datos de auditoria donde corresponda

        if (actualiza) {
            //si Actualizo hago esto
            entity.setId(id);
            entity.setUsuaModif(Constant.USU_ADMIN);
            entity.setDateModif(getTimestamp());

        } else {
            //Sino Actualizo hago esto
            entity.setUsuaCrea(Constant.USU_ADMIN);
            entity.setDateCreate(getTimestamp());
        }

        return entity;
    }
    private SunatDto getExecSunat(String numDoc) {
        String authorization = "Bearer " + tokenSunat;
        return clientSunat.getInfoSunat(numDoc, authorization);
    }
    private Timestamp getTimestamp() {
        long currenTIme = System.currentTimeMillis();
        return new Timestamp(currenTIme);
    }

}
