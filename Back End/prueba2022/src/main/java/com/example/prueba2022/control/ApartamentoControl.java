package com.example.prueba2022.control;

import com.example.prueba2022.model.Apartamento;
import com.example.prueba2022.servicios.ApartamentoService;
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
@RequestMapping("/apartamento")
public class ApartamentoControl {

    @Autowired
    private ApartamentoService apartamentoService;

    @PostMapping(value = "/")
    public ResponseEntity<Apartamento> agregar(@RequestBody Apartamento apartamento) {
        Apartamento obj = apartamentoService.save(apartamento);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "id")
    public ResponseEntity<Apartamento> eliminar(@PathVariable Integer id) {
        Apartamento obj = apartamentoService.FindByid(id);
        if (obj != null) {
            apartamentoService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Apartamento> editar(@RequestBody Apartamento apartamento) {
        Apartamento obj = apartamentoService.FindByid(apartamento.getId_apartamento());
        if (obj != null) {
            obj.setTipo(apartamento.getTipo());
            obj.setMensualidad(apartamento.getMensualidad());
            obj.setResidente(apartamento.getResidente());
            obj.setTorre(apartamento.getTorre());
            apartamentoService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Apartamento> buscarTodo() {
        return apartamentoService.findAll();
    }

    @GetMapping(("/list/{id}"))
    public Apartamento buscarporId(@PathVariable Integer id) {
        return apartamentoService.FindByid(id);
    }

}
