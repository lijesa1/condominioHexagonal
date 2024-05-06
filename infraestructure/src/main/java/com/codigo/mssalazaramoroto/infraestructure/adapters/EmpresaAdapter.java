package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.EmpresaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.SunatDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.EmpresaRequest;
import com.codigo.mssalazaramoroto.domain.ports.out.EmpresaServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.dao.EmpresaRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.Empresa;
import com.codigo.mssalazaramoroto.infraestructure.entity.Persona;
import com.codigo.mssalazaramoroto.infraestructure.mapper.EmpresaMapper;
import com.codigo.mssalazaramoroto.infraestructure.mapper.PersonaMapper;
import com.codigo.mssalazaramoroto.infraestructure.redis.RedisService;
import com.codigo.mssalazaramoroto.infraestructure.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.codigo.mssalazaramoroto.infraestructure.client.ClientSunat;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public Optional<EmpresaDto> buscarXIdOut(Long id) {
        String redisInfo = redisService.getFromRedis(Constant.REDIS_KEY_OBTENEREMPRESA + id);
        if (redisInfo != null) {
            EmpresaDto empresaDto = Util.convertirDesdeString(redisInfo, EmpresaDto.class);
            return Optional.of(empresaDto);
        } else {
            EmpresaDto empresaDto = EmpresaMapper.fromEntity(empresaRepository.findById(id).get());
            String dataForRedis = Util.convertirEmpAString(empresaDto);
            redisService.saveInRedis(Constant.REDIS_KEY_OBTENEREMPRESA + id, dataForRedis, 10);
            return Optional.of(empresaDto);
        }
    }

    @Override
    public List<EmpresaDto> buscarTodasOut() {
        List<EmpresaDto> listaDto = new ArrayList<>();
        List<Empresa> entidades = empresaRepository.findAll();
        for (Empresa dato : entidades) {
            listaDto.add(EmpresaMapper.fromEntity(dato));
        }
        return listaDto;
    }

    @Override
    public EmpresaDto actualizarOut(Long id, EmpresaRequest empresaRequest) {
        Optional<Empresa> empresaRecuperada = empresaRepository.findById(id);
        if (empresaRecuperada.isPresent()) {
            Empresa empresaEntity = getEntity(empresaRequest, true, id);
            return EmpresaMapper.fromEntity(empresaRepository.save(empresaEntity));
        } else {
            throw new RuntimeException("No se encontró la empresa");
        }
    }

    @Override
    public EmpresaDto deleteOut(Long id) {
        Optional<Empresa> empresaRecuperada = empresaRepository.findById(id);
        if (empresaRecuperada.isPresent()) {
            empresaRecuperada.get().setEstado(Constant.STATUS_INACTIVE);
            empresaRecuperada.get().setUsuaDelet(Constant.USU_ADMIN);
            empresaRecuperada.get().setDateDelet(getTimestamp());
            return EmpresaMapper.fromEntity(empresaRepository.save(empresaRecuperada.get()));
        } else {
            throw new RuntimeException("No se encontró la empresa");
        }
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
            entity.setUsuaCrea(Constant.USU_ADMIN);
            entity.setDateCreate(getTimestamp());
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
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }


}
