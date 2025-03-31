package com.facturacion_servicios.repository;



import com.facturacion_servicios.model.Factura;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FacturacionRepository{
    private final List<Factura> facturas = new ArrayList<>();

    public FacturacionRepository() {

        facturas.add(new Factura(1, "Consulta General", 
        "Evaluación médica general de la mascota para detectar enfermedades, heridas o problemas de salud.",15000));
        facturas.add(new Factura(2, "Vacuna Séxtuple u Óctuple",
        "Protege contra moquillo, parvovirus, hepatitis, leptospirosis, entre otras.", 25000));
        facturas.add(new Factura(3, "Vacuna Antirrábica","Protección contra la rabia en perros y gatos.", 25000));
        facturas.add(new Factura(4, "Implantación de Microchip",
        "Inserción de un microchip subcutáneo con datos del dueño y la mascota para identificación en caso de extravío.", 20000));
        facturas.add(new Factura(5, "Castración de Gato ","Cirugía para evitar la reproducción y mejorar la calidad de vida de gatos", 35000));
        facturas.add(new Factura(6, "Esterilización de Perra ","Cirugía para evitar la reproducción y mejorar la calidad de vida de perros", 45.000));
        facturas.add(new Factura(7, "Limpieza Dental", "Eliminación de sarro y placa bacteriana en los dientes de la mascota, previniendo enfermedades periodontales.",15000));
        facturas.add(new Factura(8, "Urgencias Veterinarias","Atención inmediata en casos de accidentes, intoxicaciones, infecciones graves o partos complicados.", 90000));
    }

    public List<Factura> findAll() {
        return facturas;
    }

    public Factura findById(int id) {
        return facturas.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
    }
}