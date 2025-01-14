package com.back_ADS.BackendADS.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="crop")
public class Cosecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCrop;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private Integer quantity;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "idGarden",nullable = false)
    private Huerto huerto;

    public Long getIdCrop() {
        return idCrop;
    }

    public void setIdCrop(Long idCrop) {
        this.idCrop = idCrop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Huerto getHuerto() {
        return huerto;
    }

    public void setHuerto(Huerto huerto) {
        this.huerto = huerto;
    }
}
