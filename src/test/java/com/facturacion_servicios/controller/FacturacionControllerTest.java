package com.facturacion_servicios.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.facturacion_servicios.model.Factura;
import com.facturacion_servicios.service.FacturacionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.List;

@ExtendWith(MockitoExtension.class) 
@WebMvcTest(FacturacionController.class)  // Prueba de un controlador específico
public class FacturacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

   @MockBean
   private FacturacionService facturacionServiceMock;

    @InjectMocks
    private FacturacionController facturacionController;  // Inyectar el controlador con el servicio 

    @Test
    public void obtenerTodasLasFacturasTest() throws Exception {
        Factura factura1 = new Factura();
        factura1.setId(1L);
        factura1.setServicio("Cirugía");
        factura1.setDescripcion("Cirugía de emergencia");
        factura1.setCosto(45000.0);

        Factura factura2 = new Factura();
        factura2.setId(2L);
        factura2.setServicio("Vacunación");
        factura2.setDescripcion("Vacuna contra la rabia");
        factura2.setCosto(15000.0);

        when(facturacionServiceMock.getAllFacturas()).thenReturn(List.of(factura1, factura2));

        mockMvc.perform(get("/factura"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].servicio").value("Cirugía"))
                .andExpect(jsonPath("$[1].servicio").value("Vacunación"));
    }

    @Test
    public void obtenerFacturaPorIdTest() throws Exception {
        Factura factura = new Factura();
        factura.setId(1L);
        factura.setServicio("Cirugía");
        factura.setDescripcion("Cirugía de emergencia");
        factura.setCosto(45000.0);

        when(facturacionServiceMock.getFacturaById(1L)).thenReturn(Optional.of(factura));

        mockMvc.perform(get("/factura/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.servicio").value("Cirugía"))
                .andExpect(jsonPath("$.descripcion").value("Cirugía de emergencia"));
    }

    @Test
    public void crearFacturaTest() throws Exception {
        Factura factura = new Factura();
        factura.setServicio("Cuidado dental");
        factura.setDescripcion("Limpieza y chequeo dental para prevenir problemas");
        factura.setCosto(40000.0);

        when(facturacionServiceMock.createFactura(any(Factura.class))).thenReturn(factura);

        mockMvc.perform(post("/factura")
                .contentType("application/json")
                .content("{\"servicio\": \"Cuidado dental\", \"descripcion\": \"Limpieza y chequeo dental para prevenir problemas\", \"costo\": 40000.0}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.servicio").value("Cuidado dental"))
                .andExpect(jsonPath("$.descripcion").value("Limpieza y chequeo dental para prevenir problemas"));
    }

    @Test
    public void actualizarFacturaTest() throws Exception {
        Factura factura = new Factura();
        factura.setId(1L);
        factura.setServicio("Cuidado dental");
        factura.setDescripcion("Limpieza y chequeo dental para prevenir problemas");
        factura.setCosto(40000.0);

        when(facturacionServiceMock.updateFactura(eq(1L), any(Factura.class))).thenReturn(factura);

        mockMvc.perform(put("/factura/1")
                .contentType("application/json")
                .content("{\"servicio\": \"Cuidado dental\", \"descripcion\": \"Limpieza y chequeo dental para prevenir problemas\", \"costo\": 40000.0}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.servicio").value("Cuidado dental"))
                .andExpect(jsonPath("$.descripcion").value("Limpieza y chequeo dental para prevenir problemas"));
    }

    @Test
    public void eliminarFacturaTest() throws Exception {
        mockMvc.perform(delete("/factura/1"))
                .andExpect(status().isNoContent());  // 204 No Content cuando se elimina exitosamente
    }
}