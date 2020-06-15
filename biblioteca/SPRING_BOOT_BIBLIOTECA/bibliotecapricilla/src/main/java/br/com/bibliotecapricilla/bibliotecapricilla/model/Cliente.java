package br.com.bibliotecapricilla.bibliotecapricilla.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	
	@NotNull
	@Size(min = 11, max = 11)
	private String cpf;
	
	@NotNull
	@Size(min = 10, max = 200)
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 60)
	private String email;
	
	@NotNull
	@Size(min = 8, max = 300)
	private String senha;

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
