package com.back_ADS.BackendADS.service;

import com.back_ADS.BackendADS.entity.Producto;
import com.back_ADS.BackendADS.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public List<Producto> findByNombre(String nombre) {
        return productoRepository.findByName(nombre);
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto update(Long id, Producto productoDetails) {
        Optional<Producto> optionalProducto = productoRepository.findById(id);
        if (optionalProducto.isPresent()) {
            Producto producto = optionalProducto.get();

            producto.setName(productoDetails.getName());
            return productoRepository.save(producto);
        }
        return null;
    }

    public void delete(Long id) {
        productoRepository.deleteById(id);
    }
}
