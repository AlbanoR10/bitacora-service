/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bitacora.service.consumir;

import com.bitacora.service.entidad.Bitacora;
import com.bitacora.service.modelo.BitacoraModelo;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Consumer {
    
    @Autowired
    private BitacoraModelo bitacoraModelo;
    
    @RabbitListener(queues = {"${sacavix.queue.name}"})
    public void receive(@Payload String mensaje) {
        
        Bitacora bitacora = new Bitacora();
        
        bitacora.setMensaje(mensaje);
        bitacora.setFecha(new Date());
        bitacoraModelo.save(bitacora);
        log.info("Mensaje recibido = {}", mensaje);
    }
}