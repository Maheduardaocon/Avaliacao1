package com.example.demo.services;

import java.util.List;



import org.springframework.stereotype.Service;

import com.example.demo.entities.Livro;
import com.example.demo.repositories.LivroRepository;


@Service
public class LivroService {
	private final LivroRepository livroRepository;


	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}

	public List<Livro> getAllLivro() {
		return livroRepository.findAll();
	}

	public Livro getLivroById(Long id) {
		return livroRepository.findById(id).orElse(null);

	}

	public void deleteLivro(long id) {
		livroRepository.deleteById(id);
	}
		public List<Livro> buscarPorTitulo( String titulo){
		return livroRepository.buscarPorTitulo(titulo);
		}		

}