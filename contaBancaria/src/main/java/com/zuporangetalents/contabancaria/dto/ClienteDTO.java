package com.zuporangetalents.contabancaria.dto;

import java.io.Serializable;
import java.time.Instant;

import com.zuporangetalents.contabancaria.entities.Cliente;

public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String cpf;

	private Instant dataDeNascimento;
	
	public ClienteDTO() { }

	public ClienteDTO(Long id, String nome, String email, String cpf, Instant dataDeNascimento) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
	}
	
 	public ClienteDTO(Cliente entity) {
 		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
		this.dataDeNascimento = entity.getDataDeNascimento();
 	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Instant getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Instant dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
}
