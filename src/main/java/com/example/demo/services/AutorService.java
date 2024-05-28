package com.example.demo.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.demo.entities.Autor;
import com.example.demo.repositories.AutorRepository;


@Service
public class AutorService {
	private final AutorRepository autorRepository;


	public AutorService(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}

	public Autor saveAutor(Autor autor) {
		return autorRepository.save(autor);
	}

	public List<Autor> getAllCAutor() {
		return autorRepository.findAll();
	}

	public Autor getCAutorById(Long id) {
		return autorRepository.findById(id).orElse(null);

	}

	public void deleteAutor(long id) {
		autorRepository.deleteById(id);

	}
		public List<Autor> buscarPorNome( String nome){
		return autorRepository.buscarPorNome(nome);
		}		

}
