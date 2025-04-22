package com.facturacion_servicios.controller;



import com.facturacion_servicios.model.Factura;
import com.facturacion_servicios.service.FacturacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "*")
public class FacturacionController {
    

    public FacturacionController(FacturacionService facturacionService) {
        this.facturacionService = facturacionService;
    }

    @Autowired
    private FacturacionService facturacionService;

    @GetMapping
    public List<Factura> getAllFacturas () {
        return facturacionService.getAllFacturas();
    }

    @GetMapping("/{id}")
    public Optional<Factura> getFacturaById (@PathVariable long id) {
        return facturacionService.getFacturaById(id);
    }

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura) {
        return facturacionService.createFactura(factura);
    }

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura factura) {
        return facturacionService.updateFactura(id, factura);
    }

    
    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id){
        facturacionService.deleteFactura(id);
    }

   
}

