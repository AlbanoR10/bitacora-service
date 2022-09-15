package com.bitacora.service.modelo;

import com.bitacora.service.entidad.Bitacora;
import com.bitacora.service.repositorio.BitacoraRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BitacoraModelo {
    @Autowired
    BitacoraRepository bitacoraRepository;
    
    public List<Bitacora> getAll() {
        return bitacoraRepository.findAll();
    }
    
    public Bitacora getBitacoraById(int d){
        return bitacoraRepository.findById(d).orElse(null);
    }
    
    public Bitacora save(Bitacora bitacora){
        Bitacora nuevaBitacora = bitacoraRepository.save(bitacora);
        return nuevaBitacora;
    }
}
