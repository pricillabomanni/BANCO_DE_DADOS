package br.com.bibliotecapricilla.bibliotecapricilla.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "tb_livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long isbn;
	
	@NotNull
	@Size(min = 3, max = 200)
	private String nomeLivro;
	
	@NotNull
	@Size(min = 3, max = 100)
	private String generoLivro;
	
	@NotNull
	@Range(min = 1, max = 500)
	private BigInteger qtdEstoque;

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getGeneroLivro() {
		return generoLivro;
	}

	public void setGeneroLivro(String generoLivro) {
		this.generoLivro = generoLivro;
	}

	public BigInteger getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(BigInteger qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
	
	
	

}
