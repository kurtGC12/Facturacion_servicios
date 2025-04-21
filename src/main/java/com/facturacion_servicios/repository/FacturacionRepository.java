package com.facturacion_servicios.repository;

import com.facturacion_servicios.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


   //extiende todas las librerias de jpa y ya no es necesario crear la tabla en el repositorio
    public interface FacturacionRepository extends JpaRepository<Factura, Long>{
    
}


