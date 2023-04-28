package com.unifacisa.ouvidoriaFASE3;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.unifacisa.ouvidoriaFASE3.entities.Aluno;
import com.unifacisa.ouvidoriaFASE3.entities.Elogio;
import com.unifacisa.ouvidoriaFASE3.entities.Reclamacao;
import com.unifacisa.ouvidoriaFASE3.services.ManifestacoesService;
import com.unifacisa.ouvidoriaFASE3.services.PessoaService;
import com.unifacisa.ouvidoriaFASE3.util.Teclado;

@SpringBootApplication
public class OuvidoriaFase3Application implements CommandLineRunner {

	@Autowired
	PessoaService pessoaService;
	@Autowired
	ManifestacoesService manifestacoesService;

	public static void main(String[] args) {
		SpringApplication.run(OuvidoriaFase3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Adm admin = new Adm(null, "kamilaqz@hotmail.com", "Kamila Queiroz", "1234");
		// pessoaService.addAdm(admin);
		int l = 1;
		while (l > 0) {
			System.out.println("\n----------------------------------------------------");
			System.out.println("Bem-vindo(a) a ouvidoria!");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Logar");
			System.out.println("3 - Sair");
			int opt = Teclado.leInt();

			if (opt == 1) {
				System.out.print("Qual seu nome? ");
				String nome = Teclado.leString();
				System.out.print("Digite seu e-mail: ");
				String email = Teclado.leString();
				boolean emailExistente = pessoaService.verifyEmail(email);

				/*
				 * checagem de existencia do email através do meu método verifyEmail
				 * 
				 */
				if (emailExistente == true) {
					System.out.println("O e-mail informado já está em uso. Por favor, tente novamente.");
				} else {
					System.out.print("Digite sua senha: ");
					String senha = Teclado.leString();
					Aluno alunos = new Aluno(null, email, nome, senha);
					System.out.println(pessoaService.addAluno(alunos));
				}
			} else if (opt == 2) {
				System.out.println("\n----------------------------------------------------");
				System.out.println("Logar como: ");
				System.out.println("1 - Administrador");
				System.out.println("2 - Aluno");
				int cargo = Teclado.leInt();

				if (cargo == 1) {
					System.out.print("Digite seu e-mail: ");
					String emaillog = Teclado.leString();
					System.out.print("Digite sua senha: ");
					String senhalog = Teclado.leString();
					boolean login = pessoaService.verify(emaillog, senhalog);
					if (login == true) {
						System.out.println("Acesso liberado!");

						int j = 1;
						while (j > 0) {
							System.out.println("\n----------------------------------------------------");
							System.out.printf("\nOlá, %s. Bem-vindo(a) a ouvidoria!", emaillog);
							System.out.println("\nO que deseja fazer hoje?\n");
							System.out.println("1 - Listar manifestações");
							System.out.println("2 - Apagar manifestação específica");
							System.out.println("3 - Apagar todas as manifestações");
							System.out.println("4 - Sair do menu\n");
							int numero = Teclado.leInt();

							switch (numero) {

							case 1:
								System.out.print("\n1 - Reclamacao");
								System.out.println("\n2 - Elogio");
								System.out.println("3 - Aluno(a) especifico(a)");
								System.out.print("Qual tipo deseja listar? ");
								int p = Teclado.leInt();

								if (p == 1) {
									System.out.println(manifestacoesService.listType("reclamacao"));
								} else if (p == 2) {
									System.out.println(manifestacoesService.listType("elogio"));
								} else if (p == 3) {
									System.out.println(
											"Digite o e-mail do(a) aluno(a) ao qual deseja listar as manifestacoes: ");
									String emailAluno = Teclado.leString();
									System.out.println(manifestacoesService.listAluno(emailAluno));
								} else {
									System.out.println("Digite uma opção válida.");
								}
								break;
							case 2:
								manifestacoesService.removeOne();
								break;
							case 3:
								System.out.print("\n1 - Reclamacao");
								System.out.println("\n2 - Elogio");
								System.out.println("3 - Aluno(a) especifico(a)");
								System.out.print("Qual tipo deseja apagar tudo? ");
								int o = Teclado.leInt();

								if (o == 1) {
									System.out.println(manifestacoesService.removeAllType("reclamacao"));
								} else if (o == 2) {
									System.out.println(manifestacoesService.removeAllType("elogio"));
								} else if (o == 3) {
									System.out.println(
											"Digite o e-mail do aluno ao qual deseja apagar as manifestacoes: ");
									String emailAluno = Teclado.leString();
									System.out.println(manifestacoesService.removeAllAluno(emailAluno));
								} else {
									System.out.println("Digite uma opção válida.");
								}
								break;
							case 4:
								j = 0;
								System.out.println("Saindo...");
								break;
							default:
								System.out.println("Você digitou uma opção inválida.");
								break;
							}
						}
					} else if (login == false) {
						System.out.println("Acesso negado. Cadastre-se para fazer login.");
					}

				} else if (cargo == 2) {
					System.out.print("Digite seu e-mail: ");
					String emaillog = Teclado.leString();
					System.out.print("Digite sua senha: ");
					String senhalog = Teclado.leString();
					boolean login = pessoaService.verify(emaillog, senhalog);
					if (login == true) {
						System.out.println("Acesso liberado!");

						int k = 1;
						while (k > 0) {
							System.out.println("\n----------------------------------------------------");
							System.out.printf("\nOlá, %s. Bem-vindo(a) a ouvidoria!", emaillog);
							System.out.println("\nO que deseja fazer hoje?\n");
							System.out.println("1 - Registrar manifestação");
							System.out.println("2 - Listar manifestações");
							System.out.println("3 - Sair do menu\n");
							int numero = Teclado.leInt();

							switch (numero) {
							case 1:
								System.out.print("\n1 - Reclamação");
								System.out.println("\n2 - Elogio");
								System.out.print("Qual será o tipo da manifestaçãoo? ");
								int t = Teclado.leInt();

								if (t == 1) {
									System.out.print("Manifestação: ");
									String texto = Teclado.leString();

									/*
									 * adição de manifestações na tabela é através da criação do objeto da
									 * manifestação, para o autor, eu passo o método returnPessoa, que me retorna o
									 * objeto autor através do email e senha que foram pedidos no login
									 */
									Reclamacao rec = new Reclamacao(texto, null,
											pessoaService.returnPessoa(emaillog, senhalog));
									System.out.println(manifestacoesService.addManifestacao(rec));
								} else if (t == 2) {
									System.out.print("Manifestação: ");
									String texto = Teclado.leString();
									Elogio elo = new Elogio(texto, null,
											pessoaService.returnPessoa(emaillog, senhalog));
									System.out.println(manifestacoesService.addManifestacao(elo));
								} else {
									System.out.println("Digite uma opção válida.");
								}
								break;
							case 2:
								System.out.println(manifestacoesService.listAluno(emaillog));
								break;
							case 3:
								k = 0;
								System.out.println("Saindo...");
								break;
							default:
								System.out.println("Você digitou uma opção inválida.");
								break;
							}
						}
					} else if (login == false) {
						System.out.println("Acesso negado. Cadastre-se para fazer login.");
						continue;
					}
				} else {
					System.out.println("Você digitou uma opção inválida.");
				}

			} else if (opt == 3) {
				l = 0;
				System.out.println("Saindo... \nAgradecemos por utilizar a ouvidoria!");
			} else {
				System.out.println("Você digitou uma opção inválida.");
			}

		}
		Teclado.close();
	}
}
