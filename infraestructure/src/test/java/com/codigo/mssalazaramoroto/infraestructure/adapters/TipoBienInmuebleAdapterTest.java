package com.codigo.mssalazaramoroto.infraestructure.adapters;
import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.response.BaseResponse;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoBienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import com.codigo.mssalazaramoroto.infraestructure.mapper.TipoBienInmuebleMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class TipoBienInmuebleAdapterTest {

    @Mock
    private TipoBienInmuebleRepository tipoBienInmuebleRepository;
    @Mock
    private TipoBienInmuebleMapper tipoBienInmuebleMapper;

    @InjectMocks
    private TipoBienInmuebleAdapter tipoBienInmuebleAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        tipoBienInmuebleAdapter = new TipoBienInmuebleAdapter(tipoBienInmuebleRepository, tipoBienInmuebleMapper);
    }

    @Test
    void crearTipoBienInmuebleOutSuccess() {
        // Arrange
        TipoBienInmuebleRequest tipoBienInmuebleRequest = new TipoBienInmuebleRequest("Departamento", "Activo");
        TipoBienInmueble tipoBienInmueble = new TipoBienInmueble(1L, "Departamento", "Activo", "lsalazar", new Timestamp(System.currentTimeMillis()), "lsalazar", new Timestamp(System.currentTimeMillis()), "lsalazar", new Timestamp(System.currentTimeMillis()));
        BaseResponse responseEsperado = new BaseResponse();
        responseEsperado.setCode(1000);
        when(tipoBienInmuebleRepository.existsByDescripcion(anyString())).thenReturn(false);
        when(tipoBienInmuebleMapper.mapToDto(tipoBienInmuebleRepository.save(tipoBienInmueble))).thenReturn(responseEsperado);
        // Act
        BaseResponse tipoBienInmuebleDtoRecibido = tipoBienInmuebleAdapter.crearTipoBienInmuebleOut(tipoBienInmuebleRequest);
        // Assert
         assertEquals(responseEsperado.getCode(), tipoBienInmuebleDtoRecibido.getCode());
    }
    @Test
    void crearTipoBienInmuebleOutExists() {
        // Arrange
        TipoBienInmuebleRequest tipoBienInmuebleRequest = new TipoBienInmuebleRequest("Departamento", "Activo");
        TipoBienInmueble tipoBienInmueble = new TipoBienInmueble(1L, "Departamento", "Activo", "lsalazar", new Timestamp(System.currentTimeMillis()), "lsalazar", new Timestamp(System.currentTimeMillis()), "lsalazar", new Timestamp(System.currentTimeMillis()));
        BaseResponse responseEsperado = new BaseResponse();
        responseEsperado.setCode(1001);
        when(tipoBienInmuebleRepository.existsByDescripcion(anyString())).thenReturn(true);
        when(tipoBienInmuebleMapper.mapToDto(tipoBienInmuebleRepository.save(tipoBienInmueble))).thenReturn(responseEsperado);
        // Act
        BaseResponse tipoBienInmuebleDtoRecibido = tipoBienInmuebleAdapter.crearTipoBienInmuebleOut(tipoBienInmuebleRequest);
        // Assert
        assertEquals(responseEsperado.getCode(), tipoBienInmuebleDtoRecibido.getCode());
    }
}