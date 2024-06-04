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

    // Mensajes BienInmueble
    // Post
    public static final Integer CODE_POST_BIEN_INMUEBLE_OK = 60000;
    public static final String MSG_POST_BIEN_INMUEBLE_OK = "Bien Inmueble registrado satisfactoriamente";

    public static final Integer CODE_POST_BIEN_INMUEBLE_KO = 60001;
    public static final String MSG_POST_BIEN_INMUEBLE_KO = "El tipo de bien inmueble a registrar no existe";

    // Get Todos
    public static final Integer CODE_GET_TODOS_BIEN_INMUEBLE_OK = 70000;
    public static final String MSG_GET_TODOS_BIEN_INMUEBLE_OK = "Listado de Bienes Inmuebles registrados";

    public static final Integer CODE_GET_TODOS_BIEN_INMUEBLE_KO = 70001;
    public static final String MSG_GET_TODOS_BIEN_INMUEBLE_KO = "Sin Bienes Inmueble registrados";

    // Get Id
    public static final Integer CODE_GET_ID_BIEN_INMUEBLE_KO = 80001;
    public static final String MSG_GET_ID_BIEN_INMUEBLE_KO = "No se encontró el BienInmueble";

    public static final Integer CODE_GET_ID_BIEN_INMUEBLE_OK = 80000;
    public static final String MSG_GET_ID_BIEN_INMUEBLE_OK = "Se encontró un BienInmueble";

    // Put
    public static final Integer CODE_PUT_BIEN_INMUEBLE_KO = 90001;
    public static final String MSG_PUT_BIEN_INMUEBLE_KO = "No se encontró el BienInmueble a actualizar";

    public static final Integer CODE_PUT_BIEN_INMUEBLE_OK = 90000;
    public static final String MSG_PUT_BIEN_INMUEBLE_OK = "Se actualizó un BienInmueble";

    // Delete
    public static final Integer CODE_DELETE_BIEN_INMUEBLE_KO = 100001;
    public static final String MSG_DELETE_BIEN_INMUEBLE_KO = "No se encontró el BienInmueble a eliminar";

    public static final Integer CODE_DELETE_BIEN_INMUEBLE_OK = 100000;
    public static final String MSG_DELETE_BIEN_INMUEBLE_OK = "Se eliminó un BienInmueble";

    // Mensajes TipoDocumento
    // Post
    public static final Integer CODE_POST_TIPO_DOCUMENTO_OK = 11000;
    public static final String MSG_POST_TIPO_DOCUMENTO_OK = "Tipo de Documento registrado satisfactoriamente";

    public static final Integer CODE_POST_TIPO_DOCUMENTO_KO = 11001;
    public static final String MSG_POST_TIPO_DOCUMENTO_KO = "Un tipo de Documento con esta descripción ya fue registrado anteriormente";

    // Get Todos
    public static final Integer CODE_GET_TODOS_TIPO_DOCUMENTO_KO = 12001;
    public static final String MSG_GET_TODOS_TIPO_DOCUMENTO_KO = "Sin Tipos de Documentos registrados";

    public static final Integer CODE_GET_TODOS_TIPO_DOCUMENTO_OK = 12000;
    public static final String MSG_GET_TODOS_TIPO_DOCUMENTO_OK = "Listado de Tipos de Documentos registrados";

    // Get Id
    public static final Integer CODE_GET_ID_TIPO_DOCUMENTO_KO = 13001;
    public static final String MSG_GET_ID_TIPO_DOCUMENTO_KO = "No se encontró el Tipo Documento";

    public static final Integer CODE_GET_ID_TIPO_DOCUMENTO_OK = 13000;
    public static final String MSG_GET_ID_TIPO_DOCUMENTO_OK = "Se encontró un Tipo Documento";

    // Put
    public static final Integer CODE_PUT_TIPO_DOCUMENTO_KO = 14001;
    public static final String MSG_PUT_TIPO_DOCUMENTO_KO = "No se encontró el TipoDocumento a actualizar";

    public static final Integer CODE_PUT_TIPO_DOCUMENTO_OK = 14000;
    public static final String MSG_PUT_TIPO_DOCUMENTO_OK = "Se actualizó un TipoDocumento";

    // Delete
    public static final Integer CODE_DELETE_TIPO_DOCUMENTO_KO = 15001;
    public static final String MSG_DELETE_TIPO_DOCUMENTO_KO = "No se encontró el TipoBienInmueble a eliminar";

    public static final Integer CODE_DELETE_TIPO_DOCUMENTO_OK = 15000;
    public static final String MSG_DELETE_TIPO_DOCUMENTO_OK = "Se eliminó un TipoBienInmueble";

    // Mensajes TipoPersona
    // Post
    public static final Integer CODE_POST_TIPO_PERSONA_OK = 16000;
    public static final String MSG_POST_TIPO_PERSONA_OK = "Tipo de Persona registrado satisfactoriamente";

    public static final Integer CODE_POST_TIPO_PERSONA_KO = 16001;
    public static final String MSG_POST_TIPO_PERSONA_KO = "Un tipo de Persona con esta descripción ya fue registrado anteriormente";

    // Get Todos
    public static final Integer CODE_GET_TODOS_TIPO_PERSONA_KO = 17001;
    public static final String MSG_GET_TODOS_TIPO_PERSONA_KO = "Sin Tipos de Personas registrados";

    public static final Integer CODE_GET_TODOS_TIPO_PERSONA_OK = 17000;
    public static final String MSG_GET_TODOS_TIPO_PERSONA_OK = "Listado de Tipos de Personas registrados";

    // Get Id
    public static final Integer CODE_GET_ID_TIPO_PERSONA_KO = 18001;
    public static final String MSG_GET_ID_TIPO_PERSONA_KO = "No se encontró el Tipo Persona";

    public static final Integer CODE_GET_ID_TIPO_PERSONA_OK = 18000;
    public static final String MSG_GET_ID_TIPO_PERSONA_OK = "Se encontró un Tipo Persona";

    // Put
    public static final Integer CODE_PUT_TIPO_PERSONA_KO = 19001;
    public static final String MSG_PUT_TIPO_PERSONA_KO = "No se encontró el TipoPersona a actualizar";

    public static final Integer CODE_PUT_TIPO_PERSONA_OK = 19000;
    public static final String MSG_PUT_TIPO_PERSONA_OK = "Se actualizó un TipoPersona";

    // Delete
    public static final Integer CODE_DELETE_TIPO_PERSONA_KO = 20001;
    public static final String MSG_DELETE_TIPO_PERSONA_KO = "No se encontró el TipoBienInmueble a eliminar";

    public static final Integer CODE_DELETE_TIPO_PERSONA_OK = 20000;
    public static final String MSG_DELETE_TIPO_PERSONA_OK = "Se eliminó un TipoBienInmueble";

    // Mensajes Persona
    // Post
    public static final Integer CODE_POST_PERSONA_OK = 21000;
    public static final String MSG_POST_PERSONA_OK = "Persona registrada satisfactoriamente";

    public static final Integer CODE_POST_PERSONA_KO = 21001;
    public static final String MSG_POST_PERSONA_KO = "Una Persona con esta descripción ya fue registrada anteriormente";

    // Get Todos
    public static final Integer CODE_GET_TODOS_PERSONA_KO = 22001;
    public static final String MSG_GET_TODOS_PERSONA_KO = "Sin Personas registradas";

    public static final Integer CODE_GET_TODOS_PERSONA_OK = 22000;
    public static final String MSG_GET_TODOS_PERSONA_OK = "Listado de Personas registradas";

    // Get ID
    public static final Integer CODE_GET_ID_PERSONA_KO = 23001;
    public static final String MSG_GET_ID_PERSONA_KO = "No se encontró la Persona";

    public static final Integer CODE_GET_ID_PERSONA_OK = 23000;
    public static final String MSG_GET_ID_PERSONA_OK = "Se encontró una Persona";

    // Put
    public static final Integer CODE_PUT_PERSONA_KO = 24001;
    public static final String MSG_PUT_PERSONA_KO = "No se encontró la Persona a actualizar";

    public static final Integer CODE_PUT_PERSONA_OK = 24000;
    public static final String MSG_PUT_PERSONA_OK = "Se actualizó una Persona";

    // Delete
    public static final Integer CODE_DELETE_PERSONA_KO = 25001;
    public static final String MSG_DELETE_PERSONA_KO = "No se encontró la Persona a eliminar";

    public static final Integer CODE_DELETE_PERSONA_OK = 25000;
    public static final String MSG_DELETE_PERSONA_OK = "Se eliminó una Persona";
}
