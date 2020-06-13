package com.soluction.CategoriaRepositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soluction.model.Endereco;

@Repository
public interface EnderecoRepositorie extends JpaRepository<Endereco, Integer> {

}
