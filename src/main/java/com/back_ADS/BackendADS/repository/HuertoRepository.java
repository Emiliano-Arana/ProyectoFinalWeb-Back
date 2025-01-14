package com.back_ADS.BackendADS.repository;

import com.back_ADS.BackendADS.entity.Huerto;
import com.back_ADS.BackendADS.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HuertoRepository extends JpaRepository<Huerto, Long> {
    List<Huerto> findByUsuarioIdUser(Long idUser);
    List<Huerto> findByHuertoProductosProductoName(String name);
}
