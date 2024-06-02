package com.codigo.mssalazaramoroto.infraestructure.adapters;

import com.codigo.mssalazaramoroto.domain.aggregates.request.TipoBienInmuebleRequest;
import com.codigo.mssalazaramoroto.domain.impl.TipoBienInmuebleServiceImpl;
import com.codigo.mssalazaramoroto.domain.ports.out.TipoBienInmuebleServiceOut;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
class TipoBienInmuebleAdapterTest {

    @Mock
    private TipoBienInmuebleServiceOut tipoBienInmuebleServiceOut;

    @InjectMocks
    private TipoBienInmuebleServiceImpl tipoBienInmuebleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearTipoBienInmuebleOut() {
    }

/*
    @Test
       void testCrearTipoBienInmuebleExistente(){
        // Arrange
        TipoBienInmuebleRequest tipoBienInmuebleRequest = new TipoBienInmuebleRequest();
        tipoBienInmuebleRequest.setDescripcion("Departamento");
        tipoBienInmuebleRequest.setEstado("Activo");
        TipoBienInmueble tipoBienInmuebleDepartamento = new TipoBienInmueble();
        request.setNumeroDocumento("123456789");
        //simular|preparar el compartamiento del mock
        when(tipoBienInmuebleRepository.existsByNumeroDocumento(anyString())).thenReturn(true);

        //ACT
        ResponseEntity<BaseResponse> response = tipoBienInmueble.crear(request);

        //ASSERT
        assertEquals(Constants.CODE_EXIST, response.getBody().getCode());
        assertEquals(Constants.MSJ_EXIST, response.getBody().getMessage());
        //assertTrue(response.getBody().getEntidad()));
    }

    @Test
    void testCrearTipoBienInmuebleNueva(){
        //ARRANGE
        TipoBienInmuebleRequest tipoBienInmuebleRequest = new TipoBienInmuebleRequest();
        TipoBienInmuebleRequest.("");
        TipoBienInmueble tipoBienInmueble = new TipoBienInmueble();

        //CONFIGURAR EL MOCK
        when(tipoBienInmuebleRepository.existsByNumeroDocumento(anyString())).thenReturn(false);
        when(tipoBienInmuebleRepository.save(any(TipoBienInmueble.class))).thenReturn(tipoBienInmueble);

        //llama a mi metodo de la clase real (impl)
        ResponseEntity<BaseResponse> response = tipoBienInmuebleService.crear(tipoBienInmuebleRequest);

        //ASSERT
        assertEquals(Constants.CODE_OK, response.getBody().getCode());
        assertEquals(Constants.MSJ_OK, response.getBody().getMessage());
        //assertTrue(response.getBody().getEntidad());
        //assertSame(empresa, response.getBody().getEntidad());
    }



    @Test

    void testObtenerTipoBienInmuebleNoExistente() {
        Long id = 1L;
        when(tipoBienInmuebleRepository.findById(id)).thenReturn(Optional.empty());
        ResponseEntity<BaseResponse> respose = tipoBienInmuebleService.obtenerTipoBienInmueble(id);
        assertEquals(Constants.CODE_EMPRESA_NO_EXIST, respose.getBody().getCode());
        assertEquals(Constants.MSJ_EMPRESA_NO_EXIST, respose.getBody().getMessage());
        //assertTrue(respose.getBody().getEntidad().isEmpty());
        assertSame(Optional.empty(), respose.getBody().getEntidad());
    }




    @Test
    void  testObtenerListaTipoBienInmuebleExistentes(){
        List<TipoBienInmueble> tipoBienInmueble = new ArrayList<>();
        tipoBienInmueble.add(new TipoBienInmueble());
        when(TipoBienInmuebleRepository.findAll()).thenReturn(tipoBienInmueble);
        ResponseEntity<BaseResponse> respose = tipoBienInmuebleService.obtenerTodos();
        assertEquals(Constants.CODE_OK, respose.getBody().getCode());
        assertEquals(Constants.MSJ_OK, respose.getBody().getMessage());
        //assertTrue(respose.getBody().getEntidad().isPresent());
        //assertSame(empresas, respose.getBody().getEntidad());
    }




    @Test
    void  testObtenerListaTipoBienInmuebleVacia(){
        List<TipoBienInmueble> tipoBienInmuebleLisempresas = new ArrayList<>();
        when(TipoBienInmuebleRepository.findAll()).thenReturn(tipoBienInmueble);
        ResponseEntity<BaseResponse> respose = TipoBienInmuebleService.obtenerTodos();
        assertEquals(Constants.CODE_EMPRESA_NO_EXIST, respose.getBody().getCode());
        assertEquals(Constants.MSJ_EMPRESA_NO_EXIST, respose.getBody().getMessage());
        //assertTrue(respose.getBody().getEntidad().isEmpty());
        assertSame(Optional.empty(), respose.getBody().getEntidad());
    }










    @Test
    void testTipoBienInmuebleActualizado(){
        TipoBienInmuebleRequest request = new TipoBienInmuebleRequest();
        TipoBienInmueble tipoBienInmueble = new TipoBienInmueble();
        when(tipoBienInmuebleRepository.existsById(anyLong())).thenReturn(true);
        when(tipoBienInmuebleRepository.findById(anyLong())).thenReturn(Optional.of(tipoBienInmueble));
        when(tipoBienInmuebleRepository.save(tipoBienInmueble)).thenReturn(tipoBienInmueble);

        ResponseEntity<BaseResponse> respose = tipoBienInmuebleService.actualizar(anyLong(), request);

        assertEquals(Constants.CODE_OK, respose.getBody().getCode());
        assertEquals(Constants.MSJ_OK, respose.getBody().getMessage());
        //assertTrue(respose.getBody().getEntidad().isPresent());
        //assertSame(empresa, respose.getBody().getEntidad());
    }

    @Test
    void testTipoBienInmuebleNoActualizado(){
        TipoBienInmuebleRequest tipoBienInmuebleRequest = new TipoBienInmuebleRequest();
        when(TipoBienInmuebleRepository.existsById(anyLong())).thenReturn(false);

        ResponseEntity<BaseResponse> respose = TipoBienInmuebleService.actualizar(anyLong(), request);
        assertEquals(Constants.CODE_EMPRESA_NO_EXIST, respose.getBody().getCode());
        assertEquals(Constants.MSJ_EMPRESA_NO_EXIST, respose.getBody().getMessage());
        //assertTrue(respose.getBody().getEntidad().isEmpty());
        assertSame(Optional.empty(), respose.getBody().getEntidad());
    }

    @Test
    void testTipoBienInmuebleBorrada(){
        TipoBienInmueble tipoBienInmueble = new TipoBienInmueble();
        when(tipoBienInmuebleRepository.existsById(anyLong())).thenReturn(true);
        when(tipoBienInmuebleRepository.findById(anyLong())).thenReturn(Optional.of(tipoBienInmueble));
        when(tipoBienInmuebleRepository.save(tipoBienInmueble)).thenReturn(tipoBienInmueble);
        ResponseEntity<BaseResponse> respose = tipoBienInmuebleService.delete(anyLong());
        assertEquals(Constants.CODE_OK, respose.getBody().getCode());
        assertEquals(Constants.MSJ_OK, respose.getBody().getMessage());
        //assertTrue(respose.getBody().getEntidad().isPresent());
        //assertSame(empresa, respose.getBody().getEntidad());
    }

    @Test
    void testTipoBienInmuebleNoBorrada(){
        when(tipoBienInmuebleRepository.existsById(anyLong())).thenReturn(false);
        ResponseEntity<BaseResponse> respose = tipoBienInmuebleService.delete(anyLong());
        assertEquals(Constants.CODE_EMPRESA_NO_EXIST, respose.getBody().getCode());
        assertEquals(Constants.MSJ_EMPRESA_NO_EXIST, respose.getBody().getMessage());
        //assertTrue(respose.getBody().getEntidad().isEmpty());
        assertSame(Optional.empty(), respose.getBody().getEntidad());
    }













    @Test
    void buscarTodosOut() {


    }

    @Test
    void buscarPorIdOut() {
    }

    @Test
    void actualizarOut() {
    }

    @Test
    void eliminarOut() {
    }*/
}