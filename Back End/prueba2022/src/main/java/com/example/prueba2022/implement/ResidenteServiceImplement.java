package com.example.prueba2022.implement;

import com.example.prueba2022.dao.ResidenteDao;
import com.example.prueba2022.model.Residente;
import com.example.prueba2022.servicios.ResidenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ResidenteServiceImplement implements ResidenteService {

    @Autowired
    private ResidenteDao residenteDao;

    @Override
    @Transactional(readOnly = false)
    public Residente save(Residente residente) {
        return residenteDao.save(residente);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        residenteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Residente FindByid(Integer id) {

        return residenteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Residente> findAll() {

        return (List<Residente>) residenteDao.findAll();
    }

}
