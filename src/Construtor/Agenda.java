package Construtor;

import java.util.ArrayList;
import java.util.List;

import Entidades.Contato;


public class Agenda {

	private List<Contato> listaContatos = new ArrayList<>();

	public void inserirContato(String nome, String numerotelefone, String email) {
		listaContatos.add(new Contato(nome, numerotelefone, email));
	}

	public List<Contato> buscaPorNome(String nome) {
		for (Contato cont : listaContatos) {
			if (cont.getNome().equalsIgnoreCase(nome)) {
				System.out.println(listaContatos.toString());
				System.out.println("O nome digitado se encontra na lista de contatos");
			}
			else {
				System.out.println("O nome digitado não se encontra na lista de contatos");
			}
		}

		return listaContatos;
	}

	

	public void removerContato(Contato contato) {
		listaContatos.remove(contato);
		System.out.println("Contato removido com sucesso");
	}

}
