package com.back_ADS.BackendADS.controller;

import com.back_ADS.BackendADS.entity.HuertoProducto;
import com.back_ADS.BackendADS.entity.Producto;
import com.back_ADS.BackendADS.service.HuertoProductoService;
import com.back_ADS.BackendADS.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/huerto-productos")
@CrossOrigin(origins="http://localhost:4200/")
public class HuertoProductoController {

    @Autowired
    private HuertoProductoService huertoProductoService;

    @GetMapping
    public List<HuertoProducto> getAll() {
        return huertoProductoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HuertoProducto> getById(@PathVariable Long id) {
        Optional<HuertoProducto> huertoProductoOpt = huertoProductoService.findById(id);
        return huertoProductoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/garden/{idGarden}")
    public List<HuertoProducto> getByGardenId(@PathVariable Long idGarden) {
        return huertoProductoService.findByIdGarden(idGarden);
    }

    @GetMapping("/product/{productName}")
    public List<HuertoProducto> getByProductName(@PathVariable String productName) {
        return huertoProductoService.findByProductName(productName);
    }

    @PostMapping
    public ResponseEntity<HuertoProducto> create(@RequestBody HuertoProducto huertoProducto) {
        HuertoProducto savedHuertoProducto = huertoProductoService.save(huertoProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHuertoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HuertoProducto> update(@PathVariable Long id, @RequestBody HuertoProducto huertoProductoDetails) {
        HuertoProducto updatedHuertoProducto = huertoProductoService.update(id, huertoProductoDetails);
        if (updatedHuertoProducto != null) {
            return ResponseEntity.ok(updatedHuertoProducto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        huertoProductoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
