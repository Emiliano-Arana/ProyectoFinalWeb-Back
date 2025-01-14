package com.back_ADS.BackendADS.repository;

import com.back_ADS.BackendADS.entity.Huerto;
import com.back_ADS.BackendADS.entity.HuertoProducto;
import com.back_ADS.BackendADS.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HuertoProductoRepository extends JpaRepository<HuertoProducto, Long> {
    List<HuertoProducto> findByHuertoIdGarden(Long idGarden);
    List<HuertoProducto> findByProductoName(String productName);

}
