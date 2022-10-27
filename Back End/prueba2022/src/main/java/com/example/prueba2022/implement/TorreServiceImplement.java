package com.example.prueba2022.implement;

import com.example.prueba2022.dao.TorreDao;
import com.example.prueba2022.model.Torre;
import com.example.prueba2022.servicios.TorreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TorreServiceImplement implements TorreService {

    @Autowired
    private TorreDao torreDao;

    @Override
    @Transactional(readOnly = false)
    public Torre save(Torre torre) {
        return torreDao.save(torre);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
       torreDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Torre FindByid(Integer id) {
       return torreDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Torre> findAll() {
        return (List<Torre>) torreDao.findAll();
    }

}
