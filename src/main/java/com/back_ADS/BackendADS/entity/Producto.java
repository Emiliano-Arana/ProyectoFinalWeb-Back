package com.back_ADS.BackendADS.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Product")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @Column(nullable = false)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "producto",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<HuertoProducto> huertoProductos;

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HuertoProducto> getHuertoProductos() {
        return huertoProductos;
    }

    public void setHuertoProductos(List<HuertoProducto> huertoProductos) {
        this.huertoProductos = huertoProductos;
    }
}
