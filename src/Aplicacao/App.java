package Aplicacao;

import java.util.Scanner;

import Construtor.Agenda;
import Contato.Cadastro.ContatoCadastro;
import Entidades.Contato;
import Infra.EntityManagerFactoryProducer;
import Validacao.ValidarEmail;



public class App {
private final Scanner scan;
	
	public App() {
		scan = new Scanner(System.in);
	}
	
	public void executar() {
		String opcaoSelecionada = "";
		do {
			opcaoSelecionada = menu();
			executarOpcao(opcaoSelecionada);
		} while (!opcaoSelecionada.equals("0"));
		EntityManagerFactoryProducer.closeDBConnection();
		System.out.println("Sistema encerrado.");
	}
	
	private String menu() {
		System.out.println("----- MENU -----");
		System.out.println("1 - Cadastro de Contatos");
		System.out.println("0 - Sair do Sistema");
		
		System.out.println("Selecione uma opção:");

		return scan.nextLine();
	}
	
	private void executarOpcao(final String opcao) {
		if(opcao.equals("0")) {
			return;
		}
		
		switch(opcao) {
		case "1":
			cadastroContato();
			break;
		
		default:
			System.out.println("Opcao Invalida!");
			break;
		
		}
		
		System.out.println("Pressione ENTER para continuar...");
		scan.nextLine();
	
	}
	
	private void cadastroContato() {
		try (ContatoCadastro contatoCadastro = new ContatoCadastro()) {
			contatoCadastro.executar();
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao executar o cadastro de contatos");
			System.out.println(e.getMessage());
		
		}
	}
	
	public static void main(String[] args) {
		new App().executar();
	}


//	public static void main(String[] args) {
//		try (Scanner scan = new Scanner(System.in)) {
//			Agenda dadosAgenda = new Agenda();
//			
//			while(true) {
//				
//				menuPrincipal();
//				int opcao = scan.nextInt();
//				
//				
//				if (opcao == 0) {
//					break;
//				}
//
//				if (opcao == 1) {
//					while(true) {
//						// Cadastrar nome e verificar se não é nulo
//						System.out.print("Digite o nome do contato: ");
//						scan.nextLine();
//						String nome = scan.nextLine();
//						
//						if (nome.isEmpty()) {
//							System.out.println("O campo de nome não pode ser nulo!!!");
//							break;
//						}
//						
//						// Cadastrar número de telefone e verificar se não é nulo
//						System.out.println("Digite o número de telefone: ");
//						String numerotelefone = scan.nextLine();
//						
//						if (numerotelefone.isEmpty()){
//							System.out.println("O campo de telefone não pode ser nulo!!!");
//							break;
//						}
//						
//						// Cadastrar email, verificar se não é nulo e se esta formatado de forma correta
//						System.out.println("Digite o email do contato: ");
//						String email = scan.nextLine();
//						
//						if(email.isEmpty() || ValidarEmail.validarEmail(email) == false) {
//							System.out.println("O campo de email não deve ser nulo e deve estar em formato correto!!!");
//							break;
//						}
//						else {
//							dadosAgenda.inserirContato(nome, numerotelefone, email);
//							System.out.println("Contato cadastrado com sucesso!");
//							break;
//						}
//						
//						
//					}
//					
//				}
//
//				if (opcao == 2) {
//					while(true) {
//						System.out.println("____________MENU BUSCA____________");
//						System.out.println("1 - Busca por NOME");
//						System.out.println("2 - Busca por TELEFONE");
//						System.out.println("3 - Busca por EMAIL");
//						System.out.println("0 - Sair do Sistema");
//
//						System.out.print("Selecione uma opção: ");
//						int opcaobusca = scan.nextInt();
//						
//						//Realiza um busca dentro do ArrayList pelo atributo nome
//						if(opcaobusca == 1) {
//							System.out.println("Digite o nome do contato para ser buscado: ");
//							scan.nextLine();
//							String nomeBusca = scan.nextLine();
//							
//							dadosAgenda.buscaPorNome(nomeBusca);
//							break;
//						}
//						
//						//Realiza um busca dentro do ArrayList pelo atributo numerotelefone
//						if(opcaobusca == 2) {
//							System.out.println("Digite o telefone do contato para ser buscado: ");
//							scan.nextLine();
//							String telefoneBusca = scan.nextLine();
//
//							dadosAgenda.buscaPorTelefone(telefoneBusca);
//							break;
//						}
//						
//						//Realiza um busca dentro do ArrayList pelo atributo numerotelefone
//						if(opcaobusca == 3) {
//							System.out.println("Digite o email do contato para ser buscado: ");
//							scan.nextLine();
//							String emailBusca = scan.nextLine();
//
//							dadosAgenda.buscaPorEmail(emailBusca);
//							break;
//						}
//						
//						if(opcaobusca == 0){
//							break;
//						}
//					}
//						
//				}
//				
//				if (opcao == 3) {
//					
//					System.out.println("Digite o nome do contato para excluir: ");
//					scan.nextLine();
//					String nomeExcluir = scan.nextLine();
//					Contato contato = new Contato(nomeExcluir);
//					
//					dadosAgenda.removerContato(contato);
//					
//				}
//			}
//		}
//
//	}
//
//	private static void menuPrincipal() {
//		System.out.println("____________MENU PRINCIPAL____________");
//		System.out.println("1 - Cadastro de Contato");
//		System.out.println("2 - Busca de Contato");
//		System.out.println("3 - Exclusão de Contato");
//		System.out.println("0 - Sair do Sistema");
//
//		System.out.print("Selecione uma opção: ");
//	}
}
