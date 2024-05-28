package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Livro;
import com.example.demo.services.LivroService;


@RestController
@RequestMapping("/livro")
public class LivroController {
	@Autowired
	private final LivroService livroService;

	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}

	@PostMapping
	public Livro createlivro(@RequestBody Livro livro) {
		return livroService.saveLivro(livro);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> getlivro(@PathVariable Long id) {
		Livro livro = livroService.getLivroById(id);
		if (livro != null) {
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	public void deletelivro(@PathVariable Long id) {
		livroService.deleteLivro(id);
	}

	@GetMapping("/titulo/{titulo}")
	public List<Livro> buscarPorTitulo(@PathVariable String titulo){
		return livroService.buscarPorTitulo(titulo);
	}

}
