package com.dina.backend;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    ClienteRepository repository;
 
 
    @PostMapping("/api/cliente")
    public ResponseEntity<String>
            inserir(@RequestBody ClienteEntity obj){
        repository.save(obj);
        String mensagem = "cadastro efetuado com sucesso";
        return ResponseEntity.ok(mensagem);        
    }
    @PutMapping("/api/cliente")
    public ResponseEntity<String>
        alterar(@RequestBody ClienteEntity obj){
        repository.save(obj);
        String mensagem = "cadastro atualizado";
        return ResponseEntity.ok(mensagem);        
    }    
    @GetMapping("/api/cliente/{codigo}")
    public ResponseEntity<ClienteEntity>
        carregar(@PathVariable int codigo){
        Optional<ClienteEntity> obj = repository.findById(codigo);
        if(obj.isPresent())    
            return ResponseEntity.ok(obj.get());
        else
            return ResponseEntity.ok(new ClienteEntity());    
    }
 
    @GetMapping("/api/cliente/lista")
    public ResponseEntity<List<ClienteEntity>>
        lista(){
        List<ClienteEntity> lista = repository.findAll();
        return ResponseEntity.ok(lista);
    }
    @DeleteMapping("/api/cliente/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        repository.deleteById(codigo);
        String mensagem = "cliente removido !";
        return ResponseEntity.ok(mensagem);    
    }

 
}