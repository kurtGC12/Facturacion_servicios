package com.facturacion_servicios.controller;



import com.facturacion_servicios.model.Factura;
import com.facturacion_servicios.service.FacturacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//importacion de librerias
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.CollectionModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

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
    public ResponseEntity<CollectionModel<EntityModel<Factura>>> getAllFacturas() {
    List<Factura> facturas = facturacionService.getAllFacturas();

    List<EntityModel<Factura>> recursos = facturas.stream()
        .map(factura -> EntityModel.of(factura,
                linkTo(methodOn(FacturacionController.class).getFacturaById(factura.getId())).withSelfRel()))
        .toList();

    CollectionModel<EntityModel<Factura>> collectionModel = CollectionModel.of(
        recursos,
        linkTo(methodOn(FacturacionController.class).getAllFacturas()).withSelfRel()
    );

    return ResponseEntity.ok(collectionModel);
}
  // verifica si la factura existe
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Factura>> getFacturaById(@PathVariable long id) {
    Optional<Factura> facturaOptional = facturacionService.getFacturaById(id);

    if (facturaOptional.isEmpty()) {
        return ResponseEntity.notFound().build();
    }

    Factura factura = facturaOptional.get();

    EntityModel<Factura> recurso = EntityModel.of(factura,
            linkTo(methodOn(FacturacionController.class).getFacturaById(id)).withSelfRel(),
            linkTo(methodOn(FacturacionController.class).getAllFacturas()).withRel("todas-las-facturas")
    );

    return ResponseEntity.ok(recurso);
}

    @PostMapping
    public ResponseEntity<Factura> createFactura(@RequestBody Factura factura) {
    Factura nuevaFactura = facturacionService.createFactura(factura);

    nuevaFactura.add(linkTo(methodOn(FacturacionController.class).getFacturaById(nuevaFactura.getId())).withSelfRel());
    nuevaFactura.add(linkTo(methodOn(FacturacionController.class).getAllFacturas()).withRel("todas-las-facturas"));

    return ResponseEntity
            .created(linkTo(methodOn(FacturacionController.class).getFacturaById(nuevaFactura.getId())).toUri())
            .body(nuevaFactura);
}

    @PutMapping("/{id}")
    public ResponseEntity<Factura> updateFactura(@PathVariable Long id, @RequestBody Factura factura) {
    Factura facturaActualizada = facturacionService.updateFactura(id, factura);

    facturaActualizada.add(linkTo(methodOn(FacturacionController.class).getFacturaById(facturaActualizada.getId())).withSelfRel());
    facturaActualizada.add(linkTo(methodOn(FacturacionController.class).getAllFacturas()).withRel("todas-las-facturas"));

    return ResponseEntity.ok(facturaActualizada);
}

    
    @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteFactura(@PathVariable Long id){
    facturacionService.deleteFactura(id);
    return ResponseEntity.noContent().build(); 
}

   
}

