package com.pedidosapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void enviarMensaje(String cola, String mensaje) {
        jmsTemplate.convertAndSend(cola, mensaje);
        System.out.println("Mensaje enviado a la cola: " + cola);
    }
}
