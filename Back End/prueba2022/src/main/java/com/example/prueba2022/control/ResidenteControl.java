package com.example.prueba2022.control;

import com.example.prueba2022.model.Residente;
import com.example.prueba2022.servicios.ResidenteService;
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
@RequestMapping("/residente")
public class ResidenteControl {

    @Autowired
    private ResidenteService residenteService;

    @PostMapping(value = "/")
    public ResponseEntity<Residente> agregar(@RequestBody Residente residente) {
        Residente obj = residenteService.save(residente);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Residente> eliminar(@PathVariable Integer id) {
        Residente obj = residenteService.FindByid(id);
        if (obj != null) {
            residenteService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping(value = "/")
    public ResponseEntity<Residente> editar(@RequestBody Residente residente) {
        Residente obj = residenteService.FindByid(residente.getId_residente());
        if (obj != null) {
            obj.setPrimer_nombre(residente.getPrimer_nombre());
            obj.setSegundo_nombre(residente.getSegundo_nombre());
            obj.setPrimer_apellido(residente.getPrimer_apellido());
            obj.setSegundo_apellido(residente.getSegundo_apellido());
            obj.setTelefono(residente.getTelefono());
            obj.setCorreo(residente.getCorreo());
            obj.setFecha_nacimiento(residente.getFecha_nacimiento());
            residenteService.save(obj);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);

    }

    @GetMapping("/list")
    public List<Residente> consultartodo() {
        return residenteService.findAll();

    }

    @GetMapping("/list/{id}")
    public Residente consulporId(@PathVariable Integer id) {
        return residenteService.FindByid(id);
    }

}
