package com.pedidosapp.service;

import com.pedidosapp.model.Pedido;
import com.pedidosapp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido crearPedido(Pedido pedido) {
        // Verifica si el pedido tiene los campos obligatorios correctamente configurados
        pedido.setEstado("Pendiente");  // Estado por defecto
        return pedidoRepository.save(pedido);
    }

    public Pedido actualizarEstado(Long id, String nuevoEstado) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(id);
        if (pedidoOpt.isPresent()) {
            Pedido pedido = pedidoOpt.get();
            pedido.setEstado(nuevoEstado); // Asegúrate de que el setter de estado esté disponible en la clase Pedido
            return pedidoRepository.save(pedido);
        }
        return null;
    }
}
