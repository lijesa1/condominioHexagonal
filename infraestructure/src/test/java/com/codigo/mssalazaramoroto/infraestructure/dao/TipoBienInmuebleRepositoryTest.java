package com.codigo.mssalazaramoroto.infraestructure.dao;
import com.codigo.mssalazaramoroto.domain.aggregates.constants.Constant;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoBienInmueble;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Timestamp;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
/*
//@SpringBootTest(classes=com.codigo.mssalazaramoroto.infraestructure.dao.TipoBienInmuebleRepository.class)
@ContextConfiguration(classes=com.codigo.mssalazaramoroto.infraestructure.dao.TipoBienInmuebleRepository.class)
@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

class TipoBienInmuebleRepositoryTest {
@Autowired
    private TipoBienInmuebleRepository tipoBienInmuebleRepository;
    @Autowired
    private TestEntityManager entityManager;

@Test
    public void testCreateFirstTipoInmueble(){

    TipoBienInmueble tipoBienInmuebleDpto = TipoBienInmueble.builder()
            .descripcion("Departamento")
            .estado("Activo")
            .usuarioCreacion(Constant.USU_ADMIN)
            .fechaCreacion(getTimestamp())
            .build();
    TipoBienInmueble savedTipoBienInmueble =tipoBienInmuebleRepository.save(tipoBienInmuebleDpto);
    assertThat(savedTipoBienInmueble.getId()).isGreaterThan(0);
    }

    private Timestamp getTimestamp() {
        long currenTime = System.currentTimeMillis();
        return new Timestamp(currenTime);
    }

}*/