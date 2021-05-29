package Contato.Cadastro;

import java.util.Scanner;


import Construtor.Agenda;
import Contato.Servico.ContatoServico;
import Entidades.Contato;
import Validacao.ValidarEmail;

public class ContatoCadastro implements AutoCloseable{
	
	private final ContatoServico contatoServico;
	private final Scanner scan;
	
	public ContatoCadastro() {
		contatoServico = new ContatoServico();
		scan = new Scanner(System.in);
		
	}
	
	public void executar() {
		String opcao = "";
		do {
			opcao = menuPrincipal();
			executarOpcao(opcao);
		} while (!opcao.equals("0"));
	}
	
	private String menuPrincipal() {
		System.out.println("____________MENU PRINCIPAL____________");
		System.out.println("1 - Cadastro de Contato");
		System.out.println("2 - Busca de Contato");
		System.out.println("3 - Exclusão de Contato");
		System.out.println("0 - Sair do Sistema");

		System.out.print("Selecione uma opção: ");
		return scan.nextLine();
	}
	
	private void executarOpcao(final String opcao) {
		if (opcao.equals("0")) {
			return;
		}
		
		switch (opcao) {
		case "1":
			cadastrarContato();
			break;
			
		case "2":
			buscarContato();
			break;
			
		case "3":
			removerContato();
			break;
			
		default:
			System.out.println("Opção Invalida!");
			break;
		}
		System.out.println("Pressione ENTER para continuar...");
		
		scan.nextLine();
	}
	
	private void cadastrarContato() {
		try (Scanner scan = new Scanner(System.in)) {
			Agenda dadosAgenda = new Agenda();
		while(true) {
			// Cadastrar nome e verificar se não é nulo
			System.out.print("Digite o nome do contato: ");
			scan.nextLine();
			String nome = scan.nextLine();
			
			if (nome.isEmpty()) {
				System.out.println("O campo de nome não pode ser nulo!!!");
				break;
			}
			
			// Cadastrar número de telefone e verificar se não é nulo
			System.out.println("Digite o número de telefone: ");
			String numerotelefone = scan.nextLine();
			
			if (numerotelefone.isEmpty()){
				System.out.println("O campo de telefone não pode ser nulo!!!");
				break;
			}
			
			// Cadastrar email, verificar se não é nulo e se esta formatado de forma correta
			System.out.println("Digite o email do contato: ");
			String email = scan.nextLine();
			
			if(email.isEmpty() || ValidarEmail.validarEmail(email) == false) {
				System.out.println("O campo de email não deve ser nulo e deve estar em formato correto!!!");
				break;
			}
			else {
				dadosAgenda.inserirContato(nome, numerotelefone, email);
				System.out.println("Contato cadastrado com sucesso!");
				break;
			}
			
			
			}	
		}
	}
	
	
	private void buscarContato() {
		try (Scanner scan = new Scanner(System.in)) {
			Agenda dadosAgenda = new Agenda();
		while(true) {
			System.out.println("____________MENU BUSCA____________");
			System.out.println("1 - Busca por NOME");
			System.out.println("2 - Busca por TELEFONE");
			System.out.println("3 - Busca por EMAIL");
			System.out.println("0 - Sair do Sistema");

			System.out.print("Selecione uma opção: ");
			int opcaobusca = scan.nextInt();
			
			//Realiza um busca dentro do ArrayList pelo atributo nome
			if(opcaobusca == 1) {
				System.out.println("Digite o nome do contato para ser buscado: ");
				scan.nextLine();
				String nomeBusca = scan.nextLine();
				
				dadosAgenda.buscaPorNome(nomeBusca);
				break;
			}
			
			//Realiza um busca dentro do ArrayList pelo atributo numerotelefone
			if(opcaobusca == 2) {
				System.out.println("Digite o telefone do contato para ser buscado: ");
				scan.nextLine();
				String telefoneBusca = scan.nextLine();

				dadosAgenda.buscaPorTelefone(telefoneBusca);
				break;
			}
			
			//Realiza um busca dentro do ArrayList pelo atributo numerotelefone
			if(opcaobusca == 3) {
				System.out.println("Digite o email do contato para ser buscado: ");
				scan.nextLine();
				String emailBusca = scan.nextLine();

				dadosAgenda.buscaPorEmail(emailBusca);
				break;
			}
			
			if(opcaobusca == 0){
				break;
			}
		}
			
	}
	}
	
	private void removerContato() {
		try (Scanner scan = new Scanner(System.in)) {
			Agenda dadosAgenda = new Agenda(); 
			
		System.out.println("Digite o nome do contato para excluir: ");
		scan.nextLine();
		String nomeExcluir = scan.nextLine();
		Contato contato = new Contato(nomeExcluir);
		
		dadosAgenda.removerContato(contato);
		}
	}
	
	@Override
	public void close() throws Exception {
		contatoServico.finalizar();
		
		
	}
	

}
