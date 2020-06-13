package com.soluction.CategoriaRepositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.soluction.model.Cidade;

@Repository
public interface CidadeRepositorie extends JpaRepository<Cidade, Integer>{

}
