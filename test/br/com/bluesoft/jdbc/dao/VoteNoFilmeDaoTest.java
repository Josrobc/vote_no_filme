package br.com.bluesoft.jdbc.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.bluesoft.jdbc.modelo.VoteNoFilme;

public class VoteNoFilmeDaoTest {

	@Test
	public void testFilmesPrincipais() {
		List<VoteNoFilme> filmes = new BlueSoftDao().getSelect("select * from vote_no_filme where id <= 2");
		System.out.println(filmes.get(0).getNome_Filme());
		Assert.assertEquals("Harry Potter", filmes.get(0).getNome_Filme());
		System.out.println(filmes.get(1).getNome_Filme());
		Assert.assertEquals("Colecionador de Ossos", filmes.get(1).getNome_Filme());
	}

	@Test
	public void testFilmesSecundarios() {
		List<VoteNoFilme> filmes = new BlueSoftDao().getSelect("select * from vote_no_filme where id > 2");
		System.out.println(filmes.get(0).getNome_Filme());
		Assert.assertEquals("Terra 2", filmes.get(0).getNome_Filme());
		System.out.println(filmes.get(1).getNome_Filme());
		Assert.assertEquals("Velozes e Furiosos 6", filmes.get(1).getNome_Filme());
		System.out.println(filmes.get(2).getNome_Filme());
		Assert.assertEquals("Homem de Ferro 3", filmes.get(2).getNome_Filme());
		System.out.println(filmes.get(3).getNome_Filme());
		Assert.assertEquals("Somos Tao Jovens", filmes.get(3).getNome_Filme());
		System.out.println(filmes.get(4).getNome_Filme());
		Assert.assertEquals("Reino Escondido", filmes.get(4).getNome_Filme());
	}

}
