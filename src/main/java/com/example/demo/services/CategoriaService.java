package com.example.demo.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.entities.Categoria;
import com.example.demo.repositories.CategoriaRepository;


@Service
public class CategoriaService {
	private final CategoriaRepository categoriaRepository;


	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public Categoria saveCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	public List<Categoria> getAllCategoria() {
		return categoriaRepository.findAll();
	}

	public Categoria getCategoriaById(Long id) {
		return categoriaRepository.findById(id).orElse(null);

	}

	public void deleteCategoria(long id) {
		categoriaRepository.deleteById(id);

	}
		public List<Categoria> buscarPorNome( String nome){
		return categoriaRepository.buscarPorNome(nome);
		}		

}