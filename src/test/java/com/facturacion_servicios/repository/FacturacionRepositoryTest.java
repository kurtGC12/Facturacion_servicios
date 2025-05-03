package com.facturacion_servicios.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.facturacion_servicios.model.Factura;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FacturacionRepositoryTest {

    @Autowired
    private FacturacionRepository facturacionRepository;

    @Test
    public void guardarFacturaTest() {
        Factura factura = new Factura();
        factura.setServicio("Cirugía");
        factura.setDescripcion("Cirugía de emergencia");
        factura.setCosto(45000.0);

        Factura resultado = facturacionRepository.save(factura);

        assertNotNull(resultado.getId());
        assertEquals("Cirugía", resultado.getServicio());
        assertEquals("Cirugía de emergencia", resultado.getDescripcion());
        assertEquals(45000.0, resultado.getCosto());
    }
}
