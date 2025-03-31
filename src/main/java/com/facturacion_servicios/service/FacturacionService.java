package com.facturacion_servicios.service;




import com.facturacion_servicios.model.Factura;
import com.facturacion_servicios.repository.FacturacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacturacionService {
    private final FacturacionRepository facturacionRepository;

    public FacturacionService(FacturacionRepository facturacionRepository) {
        this.facturacionRepository = facturacionRepository;
    }

    public List<Factura> obtenerFacturas() {
        return facturacionRepository.findAll();
    }

    public Factura obtenerFactura(int id) {
        return facturacionRepository.findById(id);
    }

    public double calcularTotal() {
        return facturacionRepository.findAll().stream().mapToDouble(Factura::getCosto).sum();
    }

    public List<String> obtenerServicios() {
        return facturacionRepository.findAll().stream()
                .map(Factura::getServicio)
                .collect(Collectors.toList());
    }
}
