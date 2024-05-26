package com.codigo.mssalazaramoroto.application;

import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.infraestructure.dao.TipoBienInmuebleRepository;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
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

    @Bean
    CommandLineRunner init(TipoBienInmuebleRepository tipoBienInmuebleRepository) {
        return args -> {
            // Crear los 3 TipoBienInmueble
            TipoBienInmueble tipoBienInmuebleDpto = TipoBienInmueble.builder()
                    .descripcion("Departamento")
                    .estado("Activo")
                    .usuaCrea(Constant.USU_ADMIN)
                    .dateCreate(getTimestamp())
                    .build();

            TipoBienInmueble tipoBienInmuebleEstacionamiento = TipoBienInmueble.builder()
                    .descripcion("Estacionamiento")
                    .estado("Activo")
                    .usuaCrea(Constant.USU_ADMIN)
                    .dateCreate(getTimestamp())
                    .build();

            TipoBienInmueble tipoBienInmuebleComercio = TipoBienInmueble.builder()
                    .descripcion("Comercio")
                    .estado("Activo")
                    .usuaCrea(Constant.USU_ADMIN)
                    .dateCreate(getTimestamp())
                    .build();
            tipoBienInmuebleRepository.saveAll(List.of(tipoBienInmuebleDpto, tipoBienInmuebleEstacionamiento, tipoBienInmuebleComercio));
        };
    }
    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }
}
