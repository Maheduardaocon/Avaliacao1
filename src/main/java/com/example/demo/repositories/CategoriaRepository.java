package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	@Query(value = "SELECT * FROM Categoria l WHERE lower(l.nome) LIKE %:nome", nativeQuery = true)
	List<Categoria> buscarPorNome(@Param("nome")String nome);
	
}