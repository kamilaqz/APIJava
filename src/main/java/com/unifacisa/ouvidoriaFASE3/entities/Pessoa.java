package com.unifacisa.ouvidoriaFASE3.entities;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	
	@OneToMany(mappedBy = "autor")
	private static List<Manifestacoes> manifestacoesPorPessoa = new ArrayList<>();

	public Pessoa(Integer id, String email, String nome, String senha) {
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}
	
	public Pessoa() {
		
	}
	
	public List<Manifestacoes> getManifestacao() {
		return manifestacoesPorPessoa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return email + "\n";
	}



}
