package com.codigo.mssalazaramoroto.infraestructure.dao;
import com.codigo.mssalazaramoroto.infraestructure.entity.TipoDocumento;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {
   TipoDocumento findByTipoDocumento(@Param("tipoDocumento") String tipoDocumento);
}
