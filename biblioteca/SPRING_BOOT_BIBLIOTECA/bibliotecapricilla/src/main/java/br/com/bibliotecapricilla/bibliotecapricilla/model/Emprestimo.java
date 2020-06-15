package br.com.bibliotecapricilla.bibliotecapricilla.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEmprestimo;
	
	@NotNull
	@Size(min = 1, max = 5)
	private BigInteger qtdEmprestada;
	
	@NotNull
	@Size(min = 1, max = 5)
	private BigInteger qtdDevolvida;
	
	private Date dataEmprestimo = new java.sql.Date(System.currentTimeMillis());
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDevolucao;
	
	@ManyToOne
	@JoinColumn(name = "idCliente", referencedColumnName="idCliente" )
	private Cliente idCliente;
	
	@ManyToOne
	@JoinColumn(name = "isbn", referencedColumnName="isbn" )
	private Livro isbn;

	public long getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(long idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public BigInteger getQtdEmprestada() {
		return qtdEmprestada;
	}

	public void setQtdEmprestada(BigInteger qtdEmprestada) {
		this.qtdEmprestada = qtdEmprestada;
	}

	public BigInteger getQtdDevolvida() {
		return qtdDevolvida;
	}

	public void setQtdDevolvida(BigInteger qtdDevolvida) {
		this.qtdDevolvida = qtdDevolvida;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public Livro getIsbn() {
		return isbn;
	}

	public void setIsbn(Livro isbn) {
		this.isbn = isbn;
	}

	
	
}
