package com.example.prueba2022.servicios;

import com.example.prueba2022.model.Torre;
import java.util.List;

public interface TorreService {

    public Torre save(Torre torre);

    public void delete(Integer id);

    public Torre FindByid(Integer id);

    public List<Torre> findAll();
}
