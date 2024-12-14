package com.pedidosapp.model;

import jakarta.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) 
    private String cliente;

    @Column(nullable = false) 
    private String producto;

    private int cantidad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) 
    private EstadoPedido estado;

    public Pedido() {}

    public Pedido(String cliente, String producto, int cantidad, EstadoPedido estado) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public enum EstadoPedido {
        PENDIENTE, PROCESADO, ENVIADO, ENTREGADO, CANCELADO
    }
}
