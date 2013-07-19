package br.com.bluesoft.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraContatos {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("contatos");
		factory.close();
	}
}
