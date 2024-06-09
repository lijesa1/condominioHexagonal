-- Consultar todos los tipos de bien inmueble
SELECT id, descripcion, estado, usuario_creacion, fecha_creacion, usuario_actualizacion, fecha_actualizacion,
usuario_eliminacion, fecha_eliminacion FROM tipo_bien_inmueble;

-- Bien Inmueble
SELECT * FROM bien_inmueble;
SELECT id,torre, piso_torre,num_dpto,num_estacionamiento,num_comercio,en_uso,en_alquiler,estado,usuario_creacion,
fecha_creacion, usuario_actualizacion, fecha_actualizacion, usuario_eliminacion, fecha_eliminacion,tipo_bien_inmueble_id
FROM bien_inmueble;

-- Tipo Documento
SELECT  *  FROM tipo_documento;

-- TipoPersona
SELECT * FROM tipo_persona;

-- Persona
SELECT id, nombres, apellido_paterno, apellido_materno, num_documento, celular, email,fecha_nac, estado,login, password, tipo_documento_id,
tipo_persona_id, usuario_creacion, fecha_creacion,usuario_actualizacion, fecha_actualizacion, usuario_eliminacion, fecha_eliminacion
FROM persona;

-- Libro de Visita
SELECT id,fecha_visita,persona_registrador_id, observaciones_libro_visita, estado,usuario_creacion,
fecha_creacion, usuario_actualizacion, fecha_actualizacion, usuario_eliminacion, fecha_eliminacion FROM libro_visita;

-- Detalle Libro Visita
SELECT lv.id, (SELECT nombres FROM persona WHERE id = lv.persona_registrador_id),lv.observaciones_libro_visita,
lv.fecha_visita, (SELECT nombres FROM persona WHERE id=dlv.persona_visitante_id) ,(SELECT num_documento FROM persona WHERE id=dlv.persona_visitante_id) 
FROM libro_visita lv,detalle_libro_visita dlv  WHERE persona_registrador_id = (SELECT id FROM persona WHERE num_documento = '41181961');