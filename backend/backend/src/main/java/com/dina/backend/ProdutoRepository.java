package com.dina.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
 
public interface ProdutoRepository 
extends JpaRepository<ProdutoEntity, Integer>, 
JpaSpecificationExecutor<ProdutoEntity> {

}
