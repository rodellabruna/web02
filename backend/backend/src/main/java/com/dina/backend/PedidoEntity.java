package com.dina.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo_pedido;
    private int codigo_cliente;
    private String nome_cliente;
    private String nome_produto;
    private String categoria;
    private String tipo_produto;
    private String marca;
    private String cor;
    private double preco;
    
}
