

package com.facturacion_servicios.service;

import com.facturacion_servicios.model.Factura;
import java.util.List;
import java.util.Optional;

public interface FacturacionService {
    //metodos de cada parametro
    List<Factura> getAllFacturas();
    Optional<Factura> getFacturaById(Long id);
    Factura createFactura(Factura factura);
    Factura updateFactura(Long id, Factura factura);
    void deleteFactura(Long id);
}