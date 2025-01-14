package com.back_ADS.BackendADS.repository;

import com.back_ADS.BackendADS.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
