package com.pedidosapp.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoConsumer {

    @JmsListener(destination = "pedidos-queue")
    public void recibirMensaje(String mensaje) {
        System.out.println("Mensaje recibido de la cola: " + mensaje);
        
    }
}
