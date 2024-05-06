package com.codigo.mssalazaramoroto.domain.ports.in;

import com.codigo.mssalazaramoroto.domain.aggregates.request.EmpresaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.EmpresaDto;

import java.util.List;
import java.util.Optional;

public interface EmpresaServiceIn {
    EmpresaDto crearEmpresaIn(EmpresaRequest empresaRequest);

    Optional<EmpresaDto> obtenerEmpresaByNumeroDocumentoIn(String numDoc);

    Optional<EmpresaDto> buscarXIdIn(Long id);

    List<EmpresaDto> obtenerTodosIn();

    EmpresaDto actualizarIn(Long id, EmpresaRequest empresaRequest);

    EmpresaDto deleteIn(Long id);
}
