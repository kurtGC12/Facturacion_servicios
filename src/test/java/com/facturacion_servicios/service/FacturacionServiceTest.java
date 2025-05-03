package com.facturacion_servicios.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.facturacion_servicios.model.Factura;
import com.facturacion_servicios.repository.FacturacionRepository;

@ExtendWith(MockitoExtension.class)
public class FacturacionServiceTest {

    @InjectMocks
    private FacturacionServiceimpl facturacionService;

    @Mock
    private FacturacionRepository facturacionRepository;

    @Test
    public void guardarFacturaTest() {
        Factura factura = new Factura();
        factura.setServicio("Cirugía");
        factura.setDescripcion("Cirugía de emergencia");
        factura.setCosto(45000.0);

        when(facturacionRepository.save(any(Factura.class))).thenReturn(factura);

        Factura resultado = facturacionService.createFactura(factura);

        assertEquals("Cirugía", resultado.getServicio());
        assertEquals("Cirugía de emergencia", resultado.getDescripcion());
        assertEquals(45000.0, resultado.getCosto());
    }
}
