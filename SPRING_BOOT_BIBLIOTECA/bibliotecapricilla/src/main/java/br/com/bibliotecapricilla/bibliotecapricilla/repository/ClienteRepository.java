package br.com.bibliotecapricilla.bibliotecapricilla.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.bibliotecapricilla.bibliotecapricilla.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	public List<Cliente> findAllByNomeContainingIgnoreCase(String nome);
	

}
