package com.dina.backend;

import jakarta.persistence.Column;
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
    private int id_pedido;
    private int id_cliente;
    private double valor_pedido;
    @Column(columnDefinition = "TEXT")
    private String carrinho;
    
    public int getId_pedido() {
        return id_pedido;
    }
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }
   public int getId_cliente() {
       return id_cliente;
   }
   public void setId_cliente(int id_cliente) {
       this.id_cliente = id_cliente;
   }
   public double getValor_pedido() {
       return valor_pedido;
  }
   public void setValor_pedido(double valor_pedido) {
       this.valor_pedido = valor_pedido;
   }
    public String getCarrinho() {
        return carrinho;
    }
    public void setCarrinho(String carrinho) {
        this.carrinho = carrinho;
    }

}
