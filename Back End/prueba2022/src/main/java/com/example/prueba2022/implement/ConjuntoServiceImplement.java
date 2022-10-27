package com.example.prueba2022.implement;

import com.example.prueba2022.dao.ConjuntoDao;
import com.example.prueba2022.model.Conjunto;
import com.example.prueba2022.servicios.ConjuntoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConjuntoServiceImplement implements ConjuntoService {
    
    @Autowired
    public ConjuntoDao conjuntoDao;
    
    @Override
    @Transactional(readOnly = false)    
    public Conjunto save(Conjunto conjunto) {
        return conjuntoDao.save(conjunto);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        
        conjuntoDao.deleteById(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Conjunto FindByid(Integer id) {
        
        return conjuntoDao.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Conjunto> findAll() {
        
        return (List<Conjunto>) conjuntoDao.findAll();
    }
    
}
