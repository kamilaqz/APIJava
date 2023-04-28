package com.unifacisa.ouvidoriaFASE3.entities;

import jakarta.persistence.Entity;

@Entity
public class Adm extends Pessoa {
	private static final long serialVersionUID = 1L;
	
	public Adm() {
	}
	
	public Adm(Integer id, String email, String nome, String senha) {
		super(id, email, nome, senha);
	}
	

	
	
}
