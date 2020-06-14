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
import br.com.bibliotecapricilla.bibliotecapricilla.repository.EmprestimoRepository;

@RestController
@RequestMapping("/emprestimo")
@CrossOrigin("*")
public class EmprestimoController {
	
	@Autowired
	private EmprestimoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Emprestimo>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idEmprestimo}")
	public ResponseEntity<Emprestimo> GetById (@PathVariable long idEmprestimo){
		return repository.findById(idEmprestimo)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/emprestimo/{idEmprestimo}")
	public ResponseEntity<List<Emprestimo>> GetByNome
	(@PathVariable String idEmprestimo){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(idEmprestimo));
	}
	
	@PostMapping
	public ResponseEntity<Emprestimo> Post (@RequestBody Emprestimo Emprestimo){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(Emprestimo));
	}
	
	@PutMapping
	public ResponseEntity<Emprestimo> Put (@RequestBody Emprestimo Emprestimo){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(Emprestimo));
	}
	
	@DeleteMapping("/{idEmprestimo}")
	public void Delete (@PathVariable long idEmprestimo) {
		repository.deleteById(idEmprestimo);
	}

}
