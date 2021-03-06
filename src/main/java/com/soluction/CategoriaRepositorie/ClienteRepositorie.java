package com.soluction.CategoriaRepositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soluction.model.Cliente;

@Repository
public interface ClienteRepositorie extends JpaRepository<Cliente, Integer> {

}
