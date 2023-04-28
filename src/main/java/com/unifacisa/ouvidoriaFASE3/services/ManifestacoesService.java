package com.unifacisa.ouvidoriaFASE3.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unifacisa.ouvidoriaFASE3.entities.Manifestacoes;
import com.unifacisa.ouvidoriaFASE3.repositories.ManifestacoesRepository;
import com.unifacisa.ouvidoriaFASE3.util.Teclado;

@Service
public class ManifestacoesService {

	@Autowired
	ManifestacoesRepository manifestacoesRepository;

	/*
	 * m�todo que adiciona manifesta��es na tabela
	 * 
	 */
	public String addManifestacao(Manifestacoes manifestacao) {
		manifestacoesRepository.save(manifestacao);
		return "Manifesta��o salva com sucesso!";
	}

	/*
	 * m�todo de listagem geral atrav�s do arraylist gerado com os dados da tabela
	 * 
	 */
	public String listAll() {
		ArrayList<Manifestacoes> listaManifestacoes = (ArrayList<Manifestacoes>) manifestacoesRepository.findAll();
		if (!listaManifestacoes.isEmpty()) {
			String retorno = "";
			for (int i = 0; i < listaManifestacoes.size(); i++) {
				retorno += String.format("%d) %s", (i + 1), listaManifestacoes.get(i));
			}
			return retorno;
		} else {
			return "Nenhuma manifestacao cadastrada.";
		}
	}

	/*
	 * metodo que lista e enumera as manifestacoes por tipo � criada uma lista com
	 * os componentes da pesquisa na pesquisa, eu transformo o arraylist em stream
	 * para realizar o filtro das manifestacoes por tipo. no final, tranformo para
	 * lista o resultado e a enumero
	 * 
	 */
	public String listType(String tipo) {
		ArrayList<Manifestacoes> listaManifestacoes = (ArrayList<Manifestacoes>) manifestacoesRepository.findAll();
		if (!listaManifestacoes.isEmpty()) {
			List<Manifestacoes> manifestacoesPorTipo = listaManifestacoes.stream().filter(x -> x.getTipo().equals(tipo))
					.toList();
			if (!manifestacoesPorTipo.isEmpty()) {
				String retorno = "";
				for (int i = 0; i < manifestacoesPorTipo.size(); i++) {
					retorno += String.format("%d) %s", (i + 1), manifestacoesPorTipo.get(i).toString());
				}
				return retorno;
			} else {
				return "Ainda n�o h� manifesta��es para sua busca.";
			}
		} else {
			return "Nenhuma manifesta��o cadastrada.";
		}
	}

	/*
	 * metodo que lista e enumera as menifestacoes por aluno especifico, da mesma
	 * forma que o metodo anterior
	 * 
	 */
	public String listAluno(String email) {
		ArrayList<Manifestacoes> listaManifestacoes = (ArrayList<Manifestacoes>) manifestacoesRepository.findAll();
		if (!listaManifestacoes.isEmpty()) {
			List<Manifestacoes> manifestacoesEspecificas = listaManifestacoes.stream()
					.filter(x -> x.getAutor().getEmail().equals(email)).toList();
			if (!manifestacoesEspecificas.isEmpty()) {
				String retorno = "";
				for (int i = 0; i < manifestacoesEspecificas.size(); i++) {
					retorno += String.format("%d) %s", (i + 1), manifestacoesEspecificas.get(i).toString());
				}
				return retorno;
			} else {
				return "Ainda n�o h� manifesta��es para sua busca.";
			}
		} else {
			return "Nenhuma manifesta��o cadastrada.";
		}
	}

	/*
	 * este m�todo remove uma manifestacao especifica do banco de dados. para apenas
	 * este m�todo, eu pego o mesmo id que est� na tabela. depois fa�o a checagem se
	 * o id digitado est� realmente na tabela
	 * 
	 */
	public void removeOne() {
		ArrayList<Manifestacoes> listaManifestacoes = (ArrayList<Manifestacoes>) manifestacoesRepository.findAll();
		if (!listaManifestacoes.isEmpty()) {
			for (Manifestacoes ocorrencia : listaManifestacoes) {
				System.out.println(String.format("%d) %s", ocorrencia.getId(), ocorrencia.toString()));
			}
			System.out.println("Selecione a manifesta��o que deseja apagar: ");
			int i = Teclado.leInt();
			for (Manifestacoes ocorrencia : listaManifestacoes) {
				if (ocorrencia.getId().equals(i)) {
					manifestacoesRepository.deleteById(i);
					System.out.println("Manifesta��o apagada com sucesso!");
				} else {
					System.out.println("Digite uma das op��es acima.");
				}
			}
		} else {
			System.out.println("Nenhuma manifesta��o cadastrada.");
		}
	}

	/*
	 * meotodo que remove todas as maninfestacoes por tipo (reclamacao ou elogio)
	 * atraves do predicado onde eu busco as manifestacoes com o tipo que passei
	 * como parametro
	 */
	public String removeAllType(String tipo) {
		ArrayList<Manifestacoes> listaManifestacoes = (ArrayList<Manifestacoes>) manifestacoesRepository.findAll();
		if (!listaManifestacoes.isEmpty()) {
			List<Manifestacoes> manifestacoesTipo = listaManifestacoes.stream().filter(x -> x.getTipo().equals(tipo))
					.toList();
			if (!manifestacoesTipo.isEmpty()) {
				for (Manifestacoes ocorrencias : manifestacoesTipo) {
					manifestacoesRepository.delete(ocorrencias);
				}
				return "Manifesta��es apagadas com sucesso!";
			} else {
				return "N�o h� manifesta��es para este tipo.";
			}
		} else {
			return "Nenhuma manifesta��o cadastrada.";
		}
	}

	/*
	 * metodo que remove todas as manifestacoes por aluno especifico atraves do
	 * predicado onde eu busco o email que foi passado como parametro para isso,
	 * criei uma lista apenas para checar a presen�a do aluno no arraylist
	 */

	public String removeAllAluno(String email) {
		ArrayList<Manifestacoes> listaManifestacoes = (ArrayList<Manifestacoes>) manifestacoesRepository.findAll();
		if (!listaManifestacoes.isEmpty()) {
			List<Manifestacoes> manifestacoesAluno = listaManifestacoes.stream()
					.filter(x -> x.getAutor().getEmail().equals(email)).toList();
			if (!manifestacoesAluno.isEmpty()) {
				for (Manifestacoes ocorrencias : manifestacoesAluno) {
					manifestacoesRepository.delete(ocorrencias);
				}
				return "Manifesta��es do(a) aluno(a) apagadas com sucesso!";
			} else {
				return "N�o h� manifesta��es para este(a) aluno(a).";
			}
		} else {
			return "Nenhuma manifesta��o cadastrada.";
		}

	}
}
