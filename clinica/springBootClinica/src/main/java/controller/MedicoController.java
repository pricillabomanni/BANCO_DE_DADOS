package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import model.MedicoModel;
import repository.MedicoRepository;

@Repository
@RequestMapping("/medico")
@CrossOrigin("*")
public class MedicoController {

	
	@Autowired
	private MedicoRepository repository;
	
	
	//GET
	@GetMapping
	public ResponseEntity<List<MedicoModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{crm}")
	public ResponseEntity<MedicoModel> GetById(@PathVariable String crm){
		return repository.findById(crm)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/medico/{nome}")
	public ResponseEntity<List<MedicoModel>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllBynomeContainingIgnoreCase(nome));
	}
	
	
	//POST
	@PostMapping
	public ResponseEntity<MedicoModel> Post (@RequestBody MedicoModel medico){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(medico));
	}
	
	//PUT
	@PutMapping
	public ResponseEntity<MedicoModel> Put (@RequestBody MedicoModel medico){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(medico));
	}
	
	//DELETE
	@DeleteMapping("/{crm}")
	public void delete(@PathVariable String crm) {
		repository.deleteById(crm);
	}
}
