package com.example.prueba2022.servicios;

import com.example.prueba2022.model.Factura;
import java.util.List;

public interface FacturaService {

    public Factura save(Factura factura);

    public void delete(Integer id);

    public Factura FindByid(Integer id);

    public List<Factura> findAll();
}
