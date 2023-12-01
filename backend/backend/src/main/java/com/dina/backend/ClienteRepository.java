package com.dina.backend;
import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
 
public interface ClienteRepository
extends JpaRepository<ClienteEntity, Integer>,
JpaSpecificationExecutor<ClienteEntity> {   
}