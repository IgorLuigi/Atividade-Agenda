package Contato.Servico;

import javax.persistence.EntityManager;

import Entidades.Contato;
import Infra.EntityManagerFactoryProducer;


public class ContatoServico {
	
	private final EntityManager entityManager;
	
	public ContatoServico() {
		this.entityManager = EntityManagerFactoryProducer.createEntityManager();
	}
	
	public ContatoServico(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Contato getContatoPorNome(String nome) {
		return getEntityManager().find(Contato.class, nome);
	}
	
	public Contato getContatoPorTelefone(String numeroTelefone) {
		return getEntityManager().find(Contato.class, numeroTelefone);
	}
	
	public Contato getContatoPorEmail(String email) {
		return getEntityManager().find(Contato.class, email);
	}
	
	public void inserirContato(Contato contato) {
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(contato);
		getEntityManager().getTransaction().commit();
	}
	
	public void excluirContato(String nome) {
		Contato contato = getContatoPorNome(nome);
		if (contato != null) {
			getEntityManager().getTransaction().begin();
			getEntityManager().remove(contato);
			getEntityManager().getTransaction().commit();
		}
	}
	
	public void finalizar() {
		if (getEntityManager().isOpen()) {
			getEntityManager().close();
		}
	}

	private EntityManager getEntityManager() {
		return entityManager;
	}
}
