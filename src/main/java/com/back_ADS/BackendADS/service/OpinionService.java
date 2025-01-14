package com.back_ADS.BackendADS.service;

import com.back_ADS.BackendADS.entity.Opinion;
import com.back_ADS.BackendADS.repository.OpinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpinionService {
    @Autowired
    private OpinionRepository opinionRepository;

    public List<Opinion> findAll() {
        return opinionRepository.findAll();
    }

    public Optional<Opinion> findById(Long id) {
        return opinionRepository.findById(id);
    }

    public Opinion save(Opinion opinion) {
        return opinionRepository.save(opinion);
    }

    public void delete(Long id) {
        opinionRepository.deleteById(id);
    }
}
