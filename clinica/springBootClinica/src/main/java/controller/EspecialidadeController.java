package controller;

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

import model.EspecialidadeModel;
import repository.EspecialidadeRepository;

@RestController
@RequestMapping("/especialidade")
@CrossOrigin("*")
public class EspecialidadeController {
	
	@Autowired
	private EspecialidadeRepository repository;
	
	
	//GET
	@GetMapping
	public ResponseEntity<List<EspecialidadeModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{codigoEspecialidade}")
	public ResponseEntity<EspecialidadeModel> GetById(@PathVariable long codigoEspecialidade){
		return repository.findById(codigoEspecialidade)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/especialidade/{nomeEspecialidade}")
	public ResponseEntity<List<EspecialidadeModel>> GetByTitulo(@PathVariable String nomeEspecialidade){
		return ResponseEntity.ok(repository.findAllBynomeEspecialidadeContainingIgnoreCase(nomeEspecialidade));
	}
	
	
	//POST
	@PostMapping
	public ResponseEntity<EspecialidadeModel> Post (@RequestBody EspecialidadeModel especialidade){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(especialidade));
	}
	
	//PUT
	@PutMapping
	public ResponseEntity<EspecialidadeModel> Put (@RequestBody EspecialidadeModel especialidade){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(especialidade));
	}
	
	//DELETE
	@DeleteMapping("/{codigoEspecialidade}")
	public void delete(@PathVariable long codigoEspecialidade) {
		repository.deleteById(codigoEspecialidade);
	}

}
