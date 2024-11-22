package com.pedidosapp.controller;

import com.pedidosapp.model.Pedido;
import com.pedidosapp.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // Obtener todos los pedidos
    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    // Obtener un pedido por ID
    @GetMapping("/{id}")
    public Optional<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    // Crear nuevo pedido
    @PostMapping
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidoService.crearPedido(pedido);
    }

    // Actualizar estado de un pedido
    @PutMapping("/{id}")
    public Pedido actualizarEstado(@PathVariable Long id, @RequestParam String estado) {
        return pedidoService.actualizarEstado(id, estado);
    }
}
