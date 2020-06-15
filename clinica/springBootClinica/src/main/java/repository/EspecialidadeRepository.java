package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.EspecialidadeModel;

@Repository
public interface EspecialidadeRepository extends JpaRepository<EspecialidadeModel, Long> {
	
	public List<EspecialidadeModel>findAllBynomeEspecialidadeContainingIgnoreCase(String nomeEspecialidade);

}
