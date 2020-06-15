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

import model.PacienteModel;
import repository.PacienteRepository;

@Repository
@RequestMapping("/paciente")
@CrossOrigin("*")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;
	
	
	//GET
	@GetMapping
	public ResponseEntity<List<PacienteModel>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{codigoPaciente}")
	public ResponseEntity<PacienteModel> GetById(@PathVariable long codigoPaciente){
		return repository.findById(codigoPaciente)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/paciente/{nome}")
	public ResponseEntity<List<PacienteModel>> GetByTitulo(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllBynomeContainingIgnoreCase(nome));
	}
	
	
	//POST
	@PostMapping
	public ResponseEntity<PacienteModel> Post (@RequestBody PacienteModel paciente){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(paciente));
	}
	
	//PUT
	@PutMapping
	public ResponseEntity<PacienteModel> Put (@RequestBody PacienteModel paciente){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(paciente));
	}
	
	//DELETE
	@DeleteMapping("/{codigoPaciente}")
	public void delete(@PathVariable long codigoEspecialidade) {
		repository.deleteById(codigoEspecialidade);
	}
	
}
