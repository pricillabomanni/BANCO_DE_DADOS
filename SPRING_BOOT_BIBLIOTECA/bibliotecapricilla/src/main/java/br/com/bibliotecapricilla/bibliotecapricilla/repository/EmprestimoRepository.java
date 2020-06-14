package br.com.bibliotecapricilla.bibliotecapricilla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecapricilla.bibliotecapricilla.model.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
	public List<Emprestimo> findAllByNomeContainingIgnoreCase(String idEmprestimo);

}
