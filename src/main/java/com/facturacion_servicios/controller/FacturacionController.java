package com.facturacion_servicios.controller;



import com.facturacion_servicios.model.Factura;
import com.facturacion_servicios.service.FacturacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Factura> createFactura(@RequestBody Factura factura) {
    Factura nuevaFactura = facturacionService.createFactura(factura);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFactura); 
}

    @PutMapping("/{id}")
    public Factura updateFactura(@PathVariable Long id, @RequestBody Factura factura) {
        return facturacionService.updateFactura(id, factura);
    }

    
    @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteFactura(@PathVariable Long id){
    facturacionService.deleteFactura(id);
    return ResponseEntity.noContent().build(); 
}

   
}

