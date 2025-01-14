package com.back_ADS.BackendADS.controller;

import com.back_ADS.BackendADS.entity.Opinion;
import com.back_ADS.BackendADS.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/opiniones")
@CrossOrigin(origins = "http://localhost:4200/")
public class OpinionController {
    @Autowired
    private OpinionService opinionService;

    @GetMapping
    public List<Opinion> getAllOpinions(){
        return opinionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opinion> getOpinionById(@PathVariable Long id){
        Optional<Opinion> opinion = opinionService.findById(id);
        return opinion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Opinion> create(@RequestBody Opinion opinion){
        Opinion newOpinion = opinionService.save(opinion);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOpinion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        opinionService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
