package com.back_ADS.BackendADS.controller;

import com.back_ADS.BackendADS.entity.Huerto;
import com.back_ADS.BackendADS.service.HuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/huertos")
@CrossOrigin(origins="http://localhost:4200/")
public class HuertoController {

    @Autowired
    private HuertoService huertoService;

    @GetMapping
    public List<Huerto> getAll() {
        return huertoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Huerto> getById(@PathVariable Long id) {
        Optional<Huerto> huertoOpt = huertoService.findById(id);
        return huertoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{idUser}")
    public List<Huerto> getByUserId(@PathVariable Long idUser) {
        return huertoService.findByUserId(idUser);
    }

    @PostMapping
    public ResponseEntity<Huerto> create(@RequestBody Huerto huerto) {
        Huerto savedHuerto = huertoService.save(huerto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHuerto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Huerto> update(@PathVariable Long id, @RequestBody Huerto huertoDetails) {
        Huerto updatedHuerto = huertoService.update(id, huertoDetails);
        if (updatedHuerto != null) {
            return ResponseEntity.ok(updatedHuerto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        huertoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
