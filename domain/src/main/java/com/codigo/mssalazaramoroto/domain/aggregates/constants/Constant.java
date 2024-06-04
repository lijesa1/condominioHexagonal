package com.codigo.mssalazaramoroto.domain.aggregates.constants;

public class Constant {
    public static final String STATUS_ACTIVE = "Activo";
    public static final String STATUS_INACTIVE = "Inactivo";
    public static final String USU_ADMIN = "lsalazar";
    public static final String REDIS_KEY_OBTENERPERSONA = "MS:REGISTRO:PERSONA:";
    public static final String REDIS_KEY_OBTENEREMPRESA = "MS:REGISTRO:EMPRESA:";

    public static final String OP_CREAR = "CREAR";
    public static final Integer CODE_NOEXIST = 1000;
    public static final Integer CODE_OK = 2001;

    // Mensajes TipoBienInmueble
    // Post
    public static final Integer CODE_POST_TIPO_BIEN_INMUEBLE_OK = 10000;
    public static final String MSG_POST_TIPO_BIEN_INMUEBLE_OK = "Tipo de Bien Inmueble registrado satisfactoriamente";

    public static final Integer CODE_POST_TIPO_BIEN_INMUEBLE_KO = 10001;
    public static final String MSG_POST_TIPO_BIEN_INMUEBLE_KO = "Un tipo de Bien Inmueble con esta descripción ya fue registrado anteriormente";

    // Get Todos
    public static final Integer CODE_GET_TODOS_TIPO_BIEN_INMUEBLE_KO = 20001;
    public static final String MSG_GET_TODOS_TIPO_BIEN_INMUEBLE_KO = "Sin Tipos Bien Inmueble registrados";

    public static final Integer CODE_GET_TODOS_TIPO_BIEN_INMUEBLE_OK = 20000;
    public static final String MSG_GET_TODOS_TIPO_BIEN_INMUEBLE_OK = "Listado de Tipos Bien Inmuebles registrados";

    // Get Id
    public static final Integer CODE_GET_ID_TIPO_BIEN_INMUEBLE_KO = 30001;
    public static final String MSG_GET_ID_TIPO_BIEN_INMUEBLE_KO = "No se encontró el TipoBienInmueble";

    public static final Integer CODE_GET_ID_TIPO_BIEN_INMUEBLE_OK = 30000;
    public static final String MSG_GET_ID_TIPO_BIEN_INMUEBLE_OK = "Se encontró un TipoBienInmueble";

    // Put
    public static final Integer CODE_PUT_ID_TIPO_BIEN_INMUEBLE_KO = 40001;
    public static final String MSG_PUT_ID_TIPO_BIEN_INMUEBLE_KO = "No se encontró el TipoBienInmueble a actualizar";

    public static final Integer CODE_PUT_ID_TIPO_BIEN_INMUEBLE_OK = 40000;
    public static final String MSG_PUT_ID_TIPO_BIEN_INMUEBLE_OK = "Se actualizó un TipoBienInmueble";

    // Delete
    public static final Integer CODE_DELETE_ID_TIPO_BIEN_INMUEBLE_KO = 50001;
    public static final String MSG_DELETE_ID_TIPO_BIEN_INMUEBLE_KO = "No se encontró el TipoBienInmueble a eliminar";

    public static final Integer CODE_DELETE_ID_TIPO_BIEN_INMUEBLE_OK = 50000;
    public static final String MSG_DELETE_ID_TIPO_BIEN_INMUEBLE_OK = "Se eliminó un TipoBienInmueble";


    public static final String MSG_TRX_OK = "Transacción exitosa";
    public static final String MSG_OK = "Se registró satisfactoriamente";
}
