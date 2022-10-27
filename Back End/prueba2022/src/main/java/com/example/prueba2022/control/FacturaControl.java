package com.example.prueba2022.control;

import com.example.prueba2022.model.Factura;
import com.example.prueba2022.servicios.FacturaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/factura")
public class FacturaControl {

    @Autowired
    private FacturaService facturaService;

    @PostMapping
    public ResponseEntity<Factura> agregar(@RequestBody Factura factura) {
        Factura obj = facturaService.save(factura);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Factura> eliminar(@PathVariable Integer id) {
        Factura obj = facturaService.FindByid(id);
        if (obj != null) {
            facturaService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<Factura> editar(@RequestBody Factura factura) {
        Factura obj = facturaService.FindByid(factura.getConsecutivo());
        if (obj != null) {
            obj.setPeriodo_facturado(factura.getPeriodo_facturado());
            obj.setFecha_generacion(factura.getFecha_generacion());
            obj.setTotal(factura.getTotal());
            obj.setApartamento(factura.getApartamento());
            obj.setResidente(factura.getResidente());
            obj.setTorre(factura.getTorre());
            facturaService.save(obj);

        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Factura> buscartodo() {
        return facturaService.findAll();
    }

    @GetMapping("/list/{id}")
    public Factura buscarporId(@PathVariable Integer id) {
        return facturaService.FindByid(id);
    }

}
