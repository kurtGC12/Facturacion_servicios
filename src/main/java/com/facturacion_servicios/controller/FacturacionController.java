package com.facturacion_servicios.controller;



import com.facturacion_servicios.model.Factura;
import com.facturacion_servicios.service.FacturacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/facturacion")
public class FacturacionController {
    private final FacturacionService facturacionService;

    public FacturacionController(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }

    @GetMapping("/facturas")
    public List<Factura> obtenerFacturas() {
        return facturacionService.obtenerFacturas();
    }

    @GetMapping("/facturas/{id}")
    public Factura obtenerFactura(@PathVariable int id) {
        return facturacionService.obtenerFactura(id);
    }

    @GetMapping("/facturas/total")
    public double calcularTotal() {
        return facturacionService.calcularTotal();
    }

    @GetMapping("/servicios")
    public List<String> obtenerServicios() {
        return facturacionService.obtenerServicios();
    }
}
