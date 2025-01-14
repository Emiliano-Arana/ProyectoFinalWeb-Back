package com.back_ADS.BackendADS.service;

import com.back_ADS.BackendADS.entity.Cosecha;
import com.back_ADS.BackendADS.repository.CosechaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CosechaService {
    @Autowired
    private CosechaRepository cosechaRepository;

    public List<Cosecha> findAll() {
        return cosechaRepository.findAll();
    }

    public Optional<Cosecha> findById(Long id) {
        return cosechaRepository.findById(id);
    }

    public Cosecha save(Cosecha cosecha) {
        return cosechaRepository.save(cosecha);
    }

    public void delete(Long id) {
        cosechaRepository.deleteById(id);
    }
}
