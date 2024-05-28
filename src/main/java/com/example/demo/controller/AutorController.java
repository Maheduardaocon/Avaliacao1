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

import com.example.demo.entities.Autor;
import com.example.demo.services.AutorService;




@RestController
@RequestMapping("/autor")
public class AutorController {
	@Autowired
	private final AutorService autorService;

	public AutorController(AutorService autorService) {
		this.autorService = autorService;
	}

	@PostMapping
	public Autor createautor(@RequestBody Autor autor) {
		return autorService.saveAutor(autor);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Autor> getautor(@PathVariable Long id) {
		Autor autor = autorService.getCAutorById(id);
		if (autor != null) {
			return ResponseEntity.ok(autor);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("/{id}")
	public void deleteAutor(@PathVariable Long id) {
		autorService.deleteAutor(id);
	}

	@GetMapping("/nome/{nome}")
	public List<Autor> buscarPorNome(@PathVariable String nome){
		return autorService.buscarPorNome(nome);
	}


}
