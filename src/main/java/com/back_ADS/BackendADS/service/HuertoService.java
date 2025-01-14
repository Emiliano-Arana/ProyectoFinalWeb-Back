package com.back_ADS.BackendADS.service;

import com.back_ADS.BackendADS.entity.Huerto;
import com.back_ADS.BackendADS.repository.HuertoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuertoService {
    @Autowired
    private HuertoRepository huertoRepository;

    public List<Huerto> findAll() {
        return huertoRepository.findAll();
    }

    public Optional<Huerto> findById(Long id) {
        return huertoRepository.findById(id);
    }

    public List<Huerto> findByUserId(Long idUser) {
        return huertoRepository.findByUsuarioIdUser(idUser);
    }

    public List<Huerto> findByProductName(String name) {
        return huertoRepository.findByHuertoProductosProductoName(name);
    }

    public Huerto save(Huerto huerto) {
        return huertoRepository.save(huerto);
    }

    public Huerto update(Long id, Huerto huertoDetails) {
        Optional<Huerto> optionalHuerto = huertoRepository.findById(id);
        if (optionalHuerto.isPresent()) {
            Huerto huerto = optionalHuerto.get();

            huerto.setName(huertoDetails.getName());
            huerto.setLatitude(huertoDetails.getLatitude());
            huerto.setLongitude(huertoDetails.getLongitude());
            huerto.setDescription(huertoDetails.getDescription());
            return huertoRepository.save(huerto);
        }
        return null;
    }

    public void delete(Long id) {
        huertoRepository.deleteById(id);
    }
}
