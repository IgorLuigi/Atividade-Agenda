package Entidades;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class Contato {

	private String nome;
	private String numerotelefone;
	private String email;
	
	@Deprecated
	public Contato() {
		
	}
	
	public Contato(String nome) {
		this.nome = nome;
	}
	
	public Contato(String nome, String numerotelefone, String email) {
		this.nome = nome;
		this.numerotelefone = numerotelefone;
		this.email = email;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumerotelefone() {
		return numerotelefone;
	}

	public void setNumerotelefone(String numerotelefone) {
		this.numerotelefone = numerotelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", numerotelefone=" + numerotelefone + ", email=" + email + "]";
	}

	


	
	
}
