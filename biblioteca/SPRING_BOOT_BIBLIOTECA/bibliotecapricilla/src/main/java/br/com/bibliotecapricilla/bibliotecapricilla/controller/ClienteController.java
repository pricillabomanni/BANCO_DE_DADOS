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

import br.com.bibliotecapricilla.bibliotecapricilla.model.Cliente;
import br.com.bibliotecapricilla.bibliotecapricilla.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{idCliente}")
	public ResponseEntity<Cliente> GetById (@PathVariable long idCliente){
		return repository.findById(idCliente)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Cliente>> GetByNome
	(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> Post (@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(cliente));
	}
	
	@PutMapping
	public ResponseEntity<Cliente> Put (@RequestBody Cliente cliente){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(cliente));
	}
	
	@DeleteMapping("/{idCliente}")
	public void Delete (@PathVariable long idCliente) {
		repository.deleteById(idCliente);
	}

}
