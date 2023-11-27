package com.dina.backend;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@CrossOrigin("*")
public class ProdutoController {
    @Autowired
    ProdutoRepository repository;

    @PostMapping("/api/produto")
    public ResponseEntity<String> 
        inserir(@RequestBody ProdutoEntity obj){
        repository.save(obj);
        String mensagem = "produto cadastrado";
        return ResponseEntity.ok(mensagem);        
    }
    @PutMapping("/api/produto/{id_produto}")
    public ResponseEntity<String> 
        alterar(@RequestBody ProdutoEntity obj){
        repository.save(obj);        
        String mensagem = "produto atualizado";
        return ResponseEntity.ok(mensagem);        
    }    
    @GetMapping("/api/produto/{id_produto}")
    public ResponseEntity<ProdutoEntity> 
        carregar(@PathVariable int id_produto){
        Optional<ProdutoEntity> obj = repository.findById(id_produto);
            if(obj.isPresent())    
                return ResponseEntity.ok(obj.get());
            else
                return ResponseEntity.ok(new ProdutoEntity()); 
    }

    @GetMapping("/api/produto/lista")
    public ResponseEntity<List<ProdutoEntity>> 
        lista(){
        List<ProdutoEntity> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/produto/{id_produto}")
    public ResponseEntity<String> remover(@PathVariable int id_produto){
        repository.deleteById(id_produto);
        String mensagem = "produto removido da base";
        return ResponseEntity.ok(mensagem);    
    }

    @PostMapping("/api/produtos")
    public ResponseEntity<String> inserirVarios(@RequestBody List<ProdutoEntity> produto) {
    repository.saveAll(produto);
    String mensagem = "Produtos cadastrados";
    return ResponseEntity.ok(mensagem);
}


}
