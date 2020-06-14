package br.com.bibliotecapricilla.bibliotecapricilla.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecapricilla.bibliotecapricilla.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	public List<Livro> findAllByNomeLivroContainingIgnoreCase(String nomeLivro);

}
