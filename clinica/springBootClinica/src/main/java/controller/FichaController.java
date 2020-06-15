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

import model.FichaModel;
import repository.FichaRepository;

@Repository
@RequestMapping("/ficha")
@CrossOrigin("*")
public class FichaController {

	@Autowired
	private FichaRepository repository;
	
	
	//GET
	@GetMapping
	public ResponseEntity<List<FichaModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{codigoFicha}")
	public ResponseEntity<FichaModel> GetById(@PathVariable long codigoFicha){
		return repository.findById(codigoFicha)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
		
	//POST
	@PostMapping
	public ResponseEntity<FichaModel> Post (@RequestBody FichaModel especialidade){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(especialidade));
	}
	
	//PUT
	@PutMapping
	public ResponseEntity<FichaModel> Put (@RequestBody FichaModel especialidade){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(especialidade));
	}
	
	//DELETE
	@DeleteMapping("/{codigoFicha}")
	public void delete(@PathVariable long codigoEspecialidade) {
		repository.deleteById(codigoEspecialidade);
	}
	
}
