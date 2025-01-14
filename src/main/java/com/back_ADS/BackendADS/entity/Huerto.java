package com.back_ADS.BackendADS.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "garden")
public class Huerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGarden;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double latitude;
    @Column(nullable = false)
    private double longitude;
    @Column(nullable = false)
    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="idUser",nullable = false)
    private Usuario usuario;

    @JsonManagedReference
    @OneToMany(mappedBy = "huerto",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HuertoProducto> huertoProductos;

    @JsonManagedReference
    @OneToMany(mappedBy = "huerto",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cosecha> cultivos;

    @JsonManagedReference
    @OneToMany(mappedBy = "huerto",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Opinion> opiniones;

    public Long getIdGarden() {
        return idGarden;
    }

    public void setIdGarden(Long idGarden) {
        this.idGarden = idGarden;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<HuertoProducto> getHuertoProductos() {
        return huertoProductos;
    }

    public void setHuertoProductos(List<HuertoProducto> huertoProductos) {
        this.huertoProductos = huertoProductos;
    }

    public List<Cosecha> getCultivos() {
        return cultivos;
    }

    public void setCultivos(List<Cosecha> cultivos) {
        this.cultivos = cultivos;
    }

    public List<Opinion> getOpiniones() {
        return opiniones;
    }

    public void setOpiniones(List<Opinion> opiniones) {
        this.opiniones = opiniones;
    }
}
