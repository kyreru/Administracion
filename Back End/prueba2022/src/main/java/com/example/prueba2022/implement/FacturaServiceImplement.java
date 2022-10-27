
package com.example.prueba2022.implement;

import com.example.prueba2022.dao.FacturaDao;
import com.example.prueba2022.model.Factura;
import com.example.prueba2022.servicios.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FacturaServiceImplement implements FacturaService{
   
     @Autowired
     public FacturaDao facturaDao;
    
    
    @Override
    @Transactional(readOnly = false)
    public Factura save(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
       facturaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura FindByid(Integer id) {
        return facturaDao.findById(id).orElse(null);
      
    }

    @Override
    @Transactional(readOnly = true)
    public List<Factura> findAll() {
       return (List<Factura>) facturaDao.findAll();
    }
    
}
