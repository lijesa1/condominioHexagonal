package com.codigo.mssalazaramoroto.application;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoBienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoDocumentoRepository;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoPersonaRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoDocumento;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoPersona;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@ComponentScan("com.codigo.*")
@EnableJpaRepositories("com.codigo")
@EntityScan("com.codigo.*")
@EnableFeignClients("com.codigo.*")
public class Launcher {
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    /*@Bean
    CommandLineRunner init(TipoBienInmuebleRepository tipoBienInmuebleRepository, TipoDocumentoRepository tipoDocumentoRepository, TipoPersonaRepository tipoPersonaRepository) {
        return args -> {
            // Crear los 3 TipoBienInmueble
            TipoBienInmueble tipoBienInmuebleDpto = TipoBienInmueble.builder()
                    .descripcion("Departamento")
                    .estado("Activo")
                    .usuarioCreacion(Constant.USU_ADMIN)
                    .fechaCreacion(getTimestamp())
                    .build();

            TipoBienInmueble tipoBienInmuebleEstacionamiento = TipoBienInmueble.builder()
                    .descripcion("Estacionamiento")
                    .estado("Activo")
                    .usuarioCreacion(Constant.USU_ADMIN)
                    .fechaCreacion(getTimestamp())
                    .build();

            TipoBienInmueble tipoBienInmuebleComercio = TipoBienInmueble.builder()
                    .descripcion("Comercio")
                    .estado("Activo")
                    .usuarioCreacion(Constant.USU_ADMIN)
                    .fechaCreacion(getTimestamp())
                    .build();
            tipoBienInmuebleRepository.saveAll(List.of(tipoBienInmuebleDpto, tipoBienInmuebleEstacionamiento, tipoBienInmuebleComercio));

            // Crear los 3 tipos de documentos
            TipoDocumento tipoDocumentoDNI = TipoDocumento.builder()
                    .tipoDocumento("DNI")
                    .estado("Activo")
                    .usuarioCreacion(Constant.USU_ADMIN)
                    .fechaCreacion(getTimestamp())
                    .build();
            TipoDocumento tipoDocumentoRUC = TipoDocumento.builder()
                    .tipoDocumento("RUC")
                    .estado("Activo")
                    .usuarioCreacion(Constant.USU_ADMIN)
                    .fechaCreacion(getTimestamp())
                    .build();
            TipoDocumento tipoDocumentoCE = TipoDocumento.builder()
                    .tipoDocumento("CE")
                    .estado("Activo")
                    .usuarioCreacion(Constant.USU_ADMIN)
                    .fechaCreacion(getTimestamp())
                    .build();
            TipoDocumento tipoDocumentoPas = TipoDocumento.builder()
                    .tipoDocumento("PAS")
                    .estado("Activo")
                    .usuarioCreacion(Constant.USU_ADMIN)
                    .fechaCreacion(getTimestamp())
                    .build();
            tipoDocumentoRepository.saveAll(List.of(tipoDocumentoDNI, tipoDocumentoRUC, tipoDocumentoCE, tipoDocumentoPas));

            // Crear los Tipo Persona
            TipoPersona tipoPersonaPropietario = TipoPersona.builder()
                    .descripcion("Propietario")
                    .estado("Activo")
                    .usuarioCreacion(Constant.USU_ADMIN)
                    .fechaCreacion(getTimestamp())
                    .build();
            TipoPersona tipoPersonaVigilante = TipoPersona.builder()
                    .descripcion("Vigilante")
                    .estado("Activo")
                    .usuarioCreacion(Constant.USU_ADMIN)
                    .fechaCreacion(getTimestamp())
                    .build();
            TipoPersona tipoPersonaLimpieza = TipoPersona.builder()
                    .descripcion("Limpieza")
                    .estado("Activo")
                    .usuarioCreacion(Constant.USU_ADMIN)
                    .fechaCreacion(getTimestamp())
                    .build();

            tipoPersonaRepository.saveAll(List.of(tipoPersonaPropietario, tipoPersonaVigilante, tipoPersonaLimpieza));
        };
    }*/

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }
}
