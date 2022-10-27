package com.example.prueba2022.servicios;

import com.example.prueba2022.model.Conjunto;
import java.util.List;

public interface ConjuntoService {

    public Conjunto save(Conjunto conjunto);

    public void delete(Integer id);

    public Conjunto FindByid(Integer id);

    public List<Conjunto> findAll();
}
