package com.example.prueba2022.servicios;

import com.example.prueba2022.model.Residente;
import java.util.List;

public interface ResidenteService {

    public Residente save(Residente residente);

    public void delete(Integer id);

    public Residente FindByid(Integer id);

    public List<Residente> findAll();
}
