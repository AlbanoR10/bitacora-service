package com.bitacora.service.controlador;

import com.bitacora.service.entidad.Bitacora;
import com.bitacora.service.modelo.BitacoraModelo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bitacora")
public class BitacoraController {
    @Autowired
    private BitacoraModelo bitacoraModelo;

@GetMapping("/{id}")
    public ResponseEntity<Bitacora> obtenerBitacora(@PathVariable("id") int id){
        Bitacora bitacora = bitacoraModelo.getBitacoraById(id);
        if(bitacora==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bitacora);
    }
    
    @PostMapping
    public ResponseEntity<Bitacora> guardarBitacora(@RequestBody Bitacora bitacora){
        Bitacora nuevaBitacora = bitacoraModelo.save(bitacora);
        if(nuevaBitacora==null){
            return ResponseEntity.unprocessableEntity().build();
        }
        return ResponseEntity.ok(nuevaBitacora);
    }
    
    @GetMapping
    public ResponseEntity<List<Bitacora>> listarBitacora(){
        List<Bitacora> bitacoras = bitacoraModelo.getAll();
        if(bitacoras.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bitacoras);
    }
}