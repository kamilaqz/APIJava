package com.unifacisa.ouvidoriaFASE3.entities;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Manifestacoes implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String texto, tipo;
	@ManyToOne
	@JoinColumn(name = "autor_id", nullable = false)
	private Pessoa autor;

	public Manifestacoes(String texto, String tipo, Pessoa autor) {
		this.texto = texto;
		this.tipo = tipo;
		this.autor = autor;
	}
	
	public Manifestacoes() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Pessoa getAutor() {
		return autor;
	}

	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}
	
	@Override
	public String toString() {
		return "Manifestação: \nOcorrencia= " + texto + "\nTipo= " + tipo + "\n" + "Autor: " + autor + "\n";
	}
		
}
