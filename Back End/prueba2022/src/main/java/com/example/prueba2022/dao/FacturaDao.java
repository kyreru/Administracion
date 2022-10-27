
package com.example.prueba2022.dao;

import com.example.prueba2022.model.Factura;
import org.springframework.data.repository.CrudRepository;


public interface FacturaDao extends CrudRepository<Factura, Integer>{
    
}
