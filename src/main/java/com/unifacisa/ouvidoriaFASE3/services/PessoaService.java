package com.unifacisa.ouvidoriaFASE3.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unifacisa.ouvidoriaFASE3.entities.Pessoa;
import com.unifacisa.ouvidoriaFASE3.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	/*
	 * m�todos que adicionam adms e alunos na tabela
	 * 
	 */
	public void addAdm(Pessoa autor) {
		pessoaRepository.save(autor);
	}

	public String addAluno(Pessoa autor) {
		pessoaRepository.save(autor);
		return "Aluno(a) salvo(a) com sucesso!";
	}

	/*
	 * este m�todo me retorna o objeto atrav�s dos atributos email e senha passados
	 * como parametros para que a manifestacao possa ser posteriormente adicionada
	 * na tabela
	 */
	public Pessoa returnPessoa(String email, String senha) {
		ArrayList<Pessoa> verificacao = (ArrayList<Pessoa>) pessoaRepository.findAll();
		for (Pessoa usuario : verificacao) {
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}

	/*
	 * m�todo que me retorna true se o usuario estiver cadastrado no sistema e false
	 * se n�o estiver, ou tiver digitado os dados errados
	 */
	public boolean verify(String email, String senha) {
		ArrayList<Pessoa> verificacao = (ArrayList<Pessoa>) pessoaRepository.findAll();
		for (Pessoa usuario : verificacao) {
			if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * m�todo que verifica se o email j� existe no banco de dados, se ja existir, �
	 * necessario que o usuario escolha outro para n�o comprometer a integridade do
	 * sistema
	 */
	public boolean verifyEmail(String email) {
		ArrayList<Pessoa> verificacao = (ArrayList<Pessoa>) pessoaRepository.findAll();
		for (Pessoa usuario : verificacao) {
			if (usuario.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * m�todo para uso pessoal meu que apaga todos os usuarios cadastrados
	 */
	public void clear() {
		pessoaRepository.deleteAll();
		System.out.println("Opera��o completa.");
	}
}
