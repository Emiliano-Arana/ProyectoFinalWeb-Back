package com.back_ADS.BackendADS.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name="garden_product")
public class HuertoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGardenProduct;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="idGarden",nullable = false)
    private Huerto huerto;

    @ManyToOne
    @JoinColumn(name="idProduct")
    private Producto producto;

    @Column(nullable = false)
    private Integer stock;

    public Long getIdGardenProduct() {
        return idGardenProduct;
    }

    public void setIdGardenProduct(Long idGardenProduct) {
        this.idGardenProduct = idGardenProduct;
    }

    public Huerto getHuerto() {
        return huerto;
    }

    public void setHuerto(Huerto huerto) {
        this.huerto = huerto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
