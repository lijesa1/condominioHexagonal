-- Consultar todos los tipos de bien inmueble
SELECT id, descripcion, estado, usuario_creacion, fecha_creacion, usuario_actualizacion, fecha_actualizacion,
usuario_eliminacion, fecha_eliminacion FROM tipo_bien_inmueble;

-- Bien Inmueble
SELECT * FROM bien_inmueble;
SELECT id,torre, piso_torre,num_dpto,num_estacionamiento,num_comercio,en_uso,en_alquiler,estado,usuario_creacion,
fecha_creacion, usuario_actualizacion, fecha_actualizacion, usuario_eliminacion, fecha_eliminacion,tipo_bien_inmueble_id
FROM bien_inmueble;

-- Tipo Documento
SELECT id, tipo_documento,estado,usua_crea,
date_create, usua_modif, date_modif, usua_delet, date_delet  FROM tipo_documento;

-- TipoPersona
SELECT id,descripcion,estado,usua_crea,
date_create, usua_modif, date_modif, usua_delet, date_delet FROM tipo_persona;