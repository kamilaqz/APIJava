package com.unifacisa.ouvidoriaFASE3.entities;

import jakarta.persistence.Entity;

@Entity
public class Reclamacao extends Manifestacoes{
	private static final long serialVersionUID = 1L;

	public Reclamacao(String texto, String tipo, Pessoa autor) {
		super(texto, tipo, autor);
		super.setTipo("reclamacao");
	}
	
	public Reclamacao() {
		
	}
}
