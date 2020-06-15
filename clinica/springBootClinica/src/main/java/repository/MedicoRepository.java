package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.MedicoModel;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoModel, String> {
	public List<MedicoModel>findAllBynomeContainingIgnoreCase(String nome);
}
