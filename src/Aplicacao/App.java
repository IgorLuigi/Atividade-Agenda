package Aplicacao;

import java.util.Scanner;

import Construtor.Agenda;
import Entidades.Contato;

public class App {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			Agenda dadosAgenda = new Agenda();
			
			while(true) {
				
				menuPrincipal();
				int opcao = scan.nextInt();
				
				
				if (opcao == 0) {
					break;
				}

				if (opcao == 1) {
					System.out.print("Digite o nome do contato: ");
					scan.nextLine();
					String nome = scan.nextLine();
					
					System.out.println("Digite o número de telefone: ");
					String numerotelefone = scan.nextLine();
					
					System.out.println("Digite o email do contato: ");
					String email = scan.nextLine();

					dadosAgenda.inserirContato(nome, numerotelefone, email);
					
				}

				if (opcao == 2) {

					System.out.println("Digite nome do contato para ser buscado: ");
					scan.nextLine();
					String nomeBusca = scan.nextLine();

					dadosAgenda.buscaPorNome(nomeBusca);
					
				}
				
				if (opcao == 3) {
					
					System.out.println("Digite o nome do contato para excluir: ");
					scan.nextLine();
					String nomeExcluir = scan.nextLine();
					Contato contato = new Contato(nomeExcluir);
					
					dadosAgenda.removerContato(contato);
					
				}
			}
		}

	}

	private static void menuPrincipal() {
		System.out.println("____________MENU PRINCIPAL____________");
		System.out.println("1 - Cadastro de Contato");
		System.out.println("2 - Busca de Contato");
		System.out.println("3 - Exclusão de Contato");
		System.out.println("0 - Sair do Sistema");

		System.out.print("Selecione uma opção: ");
	}
}
