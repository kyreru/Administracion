
package com.example.prueba2022.servicios;

import com.example.prueba2022.model.Apartamento;
import java.util.List;


public interface ApartamentoService {
    public Apartamento save(Apartamento apartamento);

    public void delete(Integer id);

    public Apartamento FindByid(Integer id);

    public List<Apartamento> findAll();
}
