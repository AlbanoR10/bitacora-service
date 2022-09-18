package com.bitacora.service.repositorio;

import com.bitacora.service.entidad.Bitacora;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface BitacoraRepository extends CrudRepository<Bitacora, String>{
    
}