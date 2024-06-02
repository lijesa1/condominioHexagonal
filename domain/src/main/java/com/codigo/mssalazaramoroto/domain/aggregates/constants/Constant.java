package com.codigo.mssalazaramoroto.domain.aggregates.constants;

public class Constant {
    public static final String STATUS_ACTIVE = "Activo";
    public static final String STATUS_INACTIVE = "Inactivo";
    public static final String USU_ADMIN = "lsalazar";
    public static final String REDIS_KEY_OBTENERPERSONA="MS:REGISTRO:PERSONA:";
    public static final String REDIS_KEY_OBTENEREMPRESA="MS:REGISTRO:EMPRESA:";

    public static final String OP_CREAR = "CREAR";
    public static final Integer CODE_NOEXIST=1000;
    public static final Integer CODE_EXIST=1001;
    public static final String MSG_OK="La persona  fue registrada con exito";
    public static final String MSG_EXIST="La persona ya fue registrada anteriormente";
}
