package com.codigo.mssalazaramoroto.domain.ports.out;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.EmpresaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.EmpresaRequest;

import java.util.List;
import java.util.Optional;

public interface EmpresaServiceOut {
    EmpresaDto crearEmpresaOut(EmpresaRequest empresaRequest);
    Optional<EmpresaDto> obtenerEmpresaByNumeroDocumentoOut(String numDoc);
    Optional<EmpresaDto> buscarXIdOut(Long id);
    List<EmpresaDto> buscarTodasOut();
    EmpresaDto actualizarOut(Long id, EmpresaRequest empresaRequest);
    EmpresaDto deleteOut(Long id);
}
