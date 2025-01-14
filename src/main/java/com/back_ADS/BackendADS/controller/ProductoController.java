package com.back_ADS.BackendADS.controller;

import com.back_ADS.BackendADS.entity.Producto;
import com.back_ADS.BackendADS.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins="http://localhost:4200/")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getAll() {
        return productoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Long id) {
        Optional<Producto> productoOpt = productoService.findById(id);
        return productoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{nombre}")
    public List<Producto> getByName(@PathVariable String nombre) {
        return productoService.findByNombre(nombre);
    }

    @PostMapping
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        Producto savedProducto = productoService.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto productoDetails) {
        Producto updatedProducto = productoService.update(id, productoDetails);
        if (updatedProducto != null) {
            return ResponseEntity.ok(updatedProducto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
