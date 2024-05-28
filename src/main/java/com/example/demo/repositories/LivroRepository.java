package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	@Query(value = "SELECT * FROM Livro l WHERE lower(l.titulo) LIKE %:titulo", nativeQuery = true)
	List<Livro> buscarPorTitulo(@Param("titulo")String titulo);
	
}
