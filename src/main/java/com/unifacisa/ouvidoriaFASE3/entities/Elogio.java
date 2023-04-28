package com.unifacisa.ouvidoriaFASE3.entities;

import jakarta.persistence.Entity;

@Entity
public class Elogio extends Manifestacoes{
	private static final long serialVersionUID = 1L;
	
	public Elogio(String texto, String tipo, Pessoa autor) {
		super(texto, tipo, autor);
		super.setTipo("elogio");
	}
	
	public Elogio() {
		
	}
}
