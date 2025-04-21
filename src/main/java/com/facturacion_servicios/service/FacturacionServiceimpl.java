


package com.facturacion_servicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturacion_servicios.model.Factura;
import com.facturacion_servicios.repository.FacturacionRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


// aqui estan los metodos que retornan al repositorio
@Service
@Transactional

public class FacturacionServiceimpl implements FacturacionService {
    @Autowired
    private FacturacionRepository facturacionRepository;

    @Override
    public List<Factura> getAllFacturas() {
        return facturacionRepository.findAll();
    }

    @Override
    public Optional<Factura> getFacturaById(Long id) {
        return facturacionRepository.findById(id);
    }

    @Override
    public Factura createFactura(Factura factura) {
        return facturacionRepository.save(factura);
    }

    @Override
    public Factura updateFactura(Long id, Factura factura) {
        if (facturacionRepository.existsById(id)) {
            factura.setId(id);
            return facturacionRepository.save(factura);
        } else {
            return null;
        }
    }
    
    @Override
    public void deleteFactura(Long id) {
        if (facturacionRepository.existsById(id)) {
            facturacionRepository.deleteById(id);
        }
    }
    
}