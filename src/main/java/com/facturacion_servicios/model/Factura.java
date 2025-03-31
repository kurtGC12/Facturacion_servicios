package com.facturacion_servicios.model;



public class Factura {
    private int id;
    private String servicio;
    private String descripcion;
    private double costo;

    public Factura(int id, String servicio, String descripcion, double costo) {
        this.id = id;
        this.servicio = servicio;
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public int getId() {
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
}