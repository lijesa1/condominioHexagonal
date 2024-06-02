package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.ReniecDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.domain.aggregates.response.ReniecResponse;
import com.codigo.mssalazaramoroto.infraestructure.client.ClientReniec;
import com.codigo.mssalazaramoroto.infraestructure.dao.PersonaRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoDocumentoRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoPersonaRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.Persona;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoDocumento;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoPersona;
import com.codigo.mssalazaramoroto.infraestructure.mapper.PersonaMapper;
import com.codigo.mssalazaramoroto.infraestructure.redis.RedisService;
import com.codigo.mssalazaramoroto.infraestructure.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class PersonaAdapterTest {
    @Mock
    private PersonaRepository personaRepository;
    @Mock
    private TipoDocumentoRepository tipoDocumentoRepository;
    @Mock
    private TipoDocumento tipoDocumento;
    @Mock
    private TipoPersona tipoPersona;
    @Mock
    private TipoPersonaRepository tipoPersonaRepository;
    @Mock
    private PersonaMapper personaMapper;
    @Mock
    private ClientReniec reniec;
    @Mock
    private ReniecResponse reniecResponse;
    @Mock
    private RedisService redisService;
    @Mock
    private Util util;
    @InjectMocks
    private PersonaAdapter personaAdapter;
    private Persona persona;
    private PersonaRequest request;
    private BaseResponse response1;
    private BaseResponse response2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        tipoDocumento = new TipoDocumento();
        tipoDocumento.setTipoDocumento("DNI");

        tipoPersona = new TipoPersona();
        tipoPersona.setDescripcion("Propietario");

        request = new PersonaRequest();
        request.setNumDocumento("41181961");
        request.setTipoDocumento("DNI");
        request.setCelular("999888777");
        request.setEmail("xyz@gmail.com");
        request.setFechaNac(new Date());
        request.setTipoPersona("Propietario");
        request.setLogin("");

        reniecResponse = new ReniecResponse().builder()
                .nombres("Juan")
                .apellidoPaterno("Perez")
                .apellidoMaterno("Sosa")
                .tipoDocumento("1")
                .numeroDocumento("41181961")
                .digitoVerificador("")
                .build();

        persona = new Persona();
        persona.setNombre(reniecResponse.getNombres());
        persona.setApellidoPaterno(reniecResponse.getApellidoPaterno());
        persona.setApellidoMaterno(reniecResponse.getApellidoMaterno());
        persona.setCelular(request.getCelular());
        persona.setEmail(request.getEmail());
        persona.setNumDocumento(request.getNumDocumento());
        persona.setFechaNac(request.getFechaNac());
        persona.setLogin(request.getLogin());
    }

    @Test
    void testCrearPersonaExistente() {
        //ARRANGE
        PersonaRequest request = new PersonaRequest();
        request.setNumDocumento("41180000");
        //simular | preparar el compartamiento del mock
        when(personaRepository.existsByNumDocumento(anyString())).thenReturn(true);

        //ACT
        BaseResponse response = personaAdapter.crearPersonaOut(request);

        //ASSERT
        assertEquals(Constant.CODE_EXIST, response.getCode());
        assertEquals(Constant.MSG_EXIST, response.getMessage());
    }

   /* @Test
    void testCrearPersonaNueva() {
        //ARRANGE


        //simular | preparar el compartamiento del mock

        when(personaRepository.existsByNumDocumento(request.getNumDocumento())).thenReturn(false);
        when(reniec.getInfoReniec(anyString(), anyString())).thenReturn(reniecResponse);
        when(tipoDocumentoRepository.findByTipoDocumento(anyString())).thenReturn(tipoDocumento);
        when(tipoPersonaRepository.findByDescripcion(anyString())).thenReturn(tipoPersona);
        when(personaRepository.save(any(Persona.class))).thenReturn(persona);
        when(personaMapper.mapToDto(persona)).thenReturn(response1);

        //ACT

        response2 = personaAdapter.crearPersonaOut(request);
        System.out.println(response2.getCode());
        System.out.println(response2.getMessage());
        System.out.println(response2.getEntidad());

        //ASSERT
        assertEquals(Constant.CODE_NOEXIST, response2.getCode());
        assertEquals(Constant.MSG_OK, response2.getMessage());
        //assertTrue(Arrays.asList(response.getEntidad()));
    }*/
}