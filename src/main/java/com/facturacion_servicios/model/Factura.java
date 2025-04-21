package com.facturacion_servicios.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


// 
@Entity
@Table(name = "factura") // nombre de la tabla
public class Factura {

    @Id // clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // se genera automaticamente 
    @Column(name = "id")
    private long id;
    @Column(name = "servicio")
    private String servicio;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "costo")
    private double costo;

    public Factura() {
        // Este constructor es necesario para JPA/Hibernate
    }

    public Factura(long id, String servicio, String descripcion, double costo) {
        this.id = id;
        this.servicio = servicio;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    // GEt y Set de las respectivas columnas

    public long getId() {
        return id;
    }

    public String getServicio() {
        return servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }


}