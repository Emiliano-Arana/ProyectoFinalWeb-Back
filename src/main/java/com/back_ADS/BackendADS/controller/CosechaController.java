package com.back_ADS.BackendADS.controller;

import com.back_ADS.BackendADS.entity.Cosecha;
import com.back_ADS.BackendADS.service.CosechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cosechas")
@CrossOrigin(origins = "http://localhost:4200/")
public class CosechaController {

    @Autowired
    private CosechaService cosechaService;

    @GetMapping
    public List<Cosecha> getAllCosechas() {
        return cosechaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cosecha> getById(@PathVariable Long id) {
        Optional<Cosecha> cosecha = cosechaService.findById(id);
        return cosecha.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cosecha> create(@RequestBody Cosecha cosecha) {
        Cosecha newCosecha = cosechaService.save(cosecha);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCosecha);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cosechaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
