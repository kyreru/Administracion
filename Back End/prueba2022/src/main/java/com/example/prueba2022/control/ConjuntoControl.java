
package com.example.prueba2022.control;

import com.example.prueba2022.model.Conjunto;
import com.example.prueba2022.servicios.ConjuntoService;
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
@RequestMapping("/conjunto")
public class ConjuntoControl {
    
    @Autowired
    private ConjuntoService conjuntoService;
    
   @PostMapping(value = "/")
   public ResponseEntity<Conjunto> agregar(@RequestBody Conjunto conjunto){
       Conjunto obj = conjuntoService.save(conjunto);
       return new ResponseEntity<>(obj, HttpStatus.OK);
   }
   
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Conjunto> eliminar(@PathVariable Integer id){
        Conjunto obj = conjuntoService.FindByid(id);
        if (obj != null) {
            conjuntoService.delete(id);
        } else {
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @PutMapping(value = "/")
    public ResponseEntity<Conjunto> editar(@RequestBody Conjunto conjunto){
        Conjunto obj = conjuntoService.FindByid(conjunto.getId_conjunto());
        if(obj != null){
            obj.setNombre(conjunto.getNombre());
            obj.setDireccion(conjunto.getDireccion());
            obj.setTelefono(conjunto.getTelefono());
            obj.setCiudad(conjunto.getCiudad());
            conjuntoService.save(obj);
        }else{
            return new ResponseEntity<>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public List<Conjunto> consultartodo() {
      return conjuntoService.findAll();
    
    }
    
    @GetMapping("/list/{id}")
    public Conjunto consulporId(@PathVariable Integer id) {
      return conjuntoService.FindByid(id);
    }
}
