package com.back_ADS.BackendADS.service;

import com.back_ADS.BackendADS.entity.HuertoProducto;
import com.back_ADS.BackendADS.repository.HuertoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HuertoProductoService {
    @Autowired
    private HuertoProductoRepository huertoProductoRepository;

    public List<HuertoProducto> findAll() {
        return huertoProductoRepository.findAll();
    }

    public Optional<HuertoProducto> findById(Long id) {
        return huertoProductoRepository.findById(id);
    }

    public List<HuertoProducto> findByIdGarden(Long idGarden) {
        return huertoProductoRepository.findByHuertoIdGarden(idGarden);
    }

    public List<HuertoProducto> findByProductName(String productName) {
        return huertoProductoRepository.findByProductoName(productName);
    }

    public HuertoProducto save(HuertoProducto huertoProducto) {
        return huertoProductoRepository.save(huertoProducto);
    }

    public HuertoProducto update(Long id, HuertoProducto huertoProductoDetails) {
        Optional<HuertoProducto> optionalHuertoProducto = huertoProductoRepository.findById(id);
        if (optionalHuertoProducto.isPresent()) {
            HuertoProducto huertoProducto = optionalHuertoProducto.get();

            huertoProducto.setStock(huertoProductoDetails.getStock());
            return huertoProductoRepository.save(huertoProducto);
        }
        return null;
    }

    public void delete(Long id) {
        huertoProductoRepository.deleteById(id);
    }
}
