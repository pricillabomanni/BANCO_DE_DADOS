package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.FichaModel;

@Repository
public interface FichaRepository extends JpaRepository<FichaModel, Long> {

	
	
}
