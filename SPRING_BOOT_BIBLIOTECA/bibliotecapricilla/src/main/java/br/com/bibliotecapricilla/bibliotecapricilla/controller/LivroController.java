package br.com.bibliotecapricilla.bibliotecapricilla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bibliotecapricilla.bibliotecapricilla.model.Emprestimo;
import br.com.bibliotecapricilla.bibliotecapricilla.model.Livro;
import br.com.bibliotecapricilla.bibliotecapricilla.repository.EmprestimoRepository;
import br.com.bibliotecapricilla.bibliotecapricilla.repository.LivroRepository;

@RestController
@RequestMapping("/livro")
@CrossOrigin("*")
public class LivroController {
	
	@Autowired
	private LivroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Livro>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{isbn}")
	public ResponseEntity<Livro> GetById (@PathVariable long isbn){
		return repository.findById(isbn)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nomeLivro/{nomeLivro}")
	public ResponseEntity<List<Livro>> GetByNome
	(@PathVariable String nomeLivro){
		return ResponseEntity.ok(repository.findAllByNomeLivroContainingIgnoreCase(nomeLivro));
	}
	
	@PostMapping
	public ResponseEntity<Livro> Post (@RequestBody Livro isbn){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(isbn));
	}
	
	@PutMapping
	public ResponseEntity<Livro> Put (@RequestBody Livro isbn){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(isbn));
	}
	
	@DeleteMapping("/{isbn}")
	public void Delete (@PathVariable long isbn) {
		repository.deleteById(isbn);
	}

}
