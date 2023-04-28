package com.unifacisa.ouvidoriaFASE3.entities;

import jakarta.persistence.Entity;

@Entity
public class Aluno extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	public Aluno() {
	}
	
	public Aluno(Integer id, String email, String nome, String senha) {
		super(id, email, nome, senha);
	}
}
