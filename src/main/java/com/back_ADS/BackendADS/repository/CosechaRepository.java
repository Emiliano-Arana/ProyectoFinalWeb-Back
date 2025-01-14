package com.back_ADS.BackendADS.repository;

import com.back_ADS.BackendADS.entity.Cosecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CosechaRepository extends JpaRepository<Cosecha, Long> {

}
