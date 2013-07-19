package br.com.bluesoft.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bluesoft.jdbc.modelo.VoteNoFilme;

public class GeraEAdicionaVoteNoFilme {

	public static void main(String[] args) {
		String[] filmes = new String[5];
		
		filmes[0]="Harry Potter";
		filmes[1]="Colecionador de Ossos";
		filmes[2]="Homem de Ferro 3";
		filmes[3]="Somos Tao Jovens";
		filmes[4]="Reino Escondido";

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("vote_no_filme");
		EntityManager manager = factory.createEntityManager();
		for (int i = 0; i < 5; i++) {
			VoteNoFilme filme = new VoteNoFilme();
			filme.setNome_Filme(filmes[i]);
			filme.setQtVoto(0);
			manager.getTransaction().begin();
			manager.persist(filme);
			manager.getTransaction().commit();
		}
		manager.close(); 
	}
}
