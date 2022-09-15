package com.bitacora.service.repositorio;

import com.bitacora.service.entidad.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BitacoraRepository extends JpaRepository<Bitacora, Integer>{
    
}