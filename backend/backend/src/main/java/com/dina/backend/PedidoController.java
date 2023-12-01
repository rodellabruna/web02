package com.dina.backend;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PedidoController {
    @Autowired
    PedidoRepository repository;

    
    @GetMapping("/api/pedido")
    public ResponseEntity<List<PedidoEntity>> listar
    (@RequestParam(required = false) String search,
    @RequestParam(required = false) String categoria) {
        List<PedidoEntity> pedidos;
        pedidos = repository.findAll();
   
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/api/pedido")
    public ResponseEntity<PedidoEntity> 
        inserir(@RequestBody PedidoEntity obj){
        var pedido = repository.save(obj);
        return new ResponseEntity<PedidoEntity>(pedido, HttpStatus.CREATED);
    }

    @GetMapping("/api/pedido/{id_pedido}")
    public ResponseEntity<PedidoEntity> 
        carregar(@PathVariable int id_pedido){
        Optional<PedidoEntity> obj = repository.findById(id_pedido);
            if(obj.isPresent())    
                return ResponseEntity.ok(obj.get());
            else
                return ResponseEntity.ok(new PedidoEntity()); 
    }

    
}
