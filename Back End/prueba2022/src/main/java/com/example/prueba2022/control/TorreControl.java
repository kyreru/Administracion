package com.example.prueba2022.control;

import com.example.prueba2022.model.Torre;
import com.example.prueba2022.servicios.TorreService;
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
@RequestMapping("/torre")
public class TorreControl {

    @Autowired
    private TorreService torreCervice;

    @PostMapping(value = "/")
    public ResponseEntity<Torre> agregar(@RequestBody Torre torre) {

        Torre obj = torreCervice.save(torre);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Torre> eliminar(@PathVariable Integer id) {

        Torre obj = torreCervice.FindByid(id);
        if (obj != null) {
            torreCervice.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Torre> editar(@RequestBody Torre torre) {
        
        Torre obj = torreCervice.FindByid(torre.getId_torre());
        if (obj != null) {
            obj.setConjunto(torre.getConjunto());
            torreCervice.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Torre> consultartodo() {
        return torreCervice.findAll();

    }

    @GetMapping("/list/{id}")
    public Torre consulporId(@PathVariable Integer id) {
        return torreCervice.FindByid(id);
    }
}
