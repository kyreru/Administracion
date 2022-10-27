package com.example.prueba2022.implement;

import com.example.prueba2022.dao.ApartamentoDao;
import com.example.prueba2022.model.Apartamento;
import com.example.prueba2022.servicios.ApartamentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApartamentoServiceImplement implements ApartamentoService {

    @Autowired
    private ApartamentoDao apartamentoDao;

    @Override
    @Transactional(readOnly = false)
    public Apartamento save(Apartamento apartamento) {
        
        return apartamentoDao.save(apartamento);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        
        apartamentoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Apartamento FindByid(Integer id) {

        return apartamentoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Apartamento> findAll() {

        return (List<Apartamento>) apartamentoDao.findAll();
    }

}
