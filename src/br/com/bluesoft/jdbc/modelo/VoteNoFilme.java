package br.com.bluesoft.jdbc.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="vote_no_filme")
public class VoteNoFilme {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull @Size(max=80)
	private String nome_Filme;
	private int qtVotos;

	public String getNome_Filme() {
		return this.nome_Filme;
	}

	public void setNome_Filme(String nome_Filme) {
		this.nome_Filme = nome_Filme;
	}
	
	public int getQtvoto() {
		return this.qtVotos;
	}
	
	public void setQtVoto(int qtVoto) {
		this.qtVotos = qtVoto;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void getSomaVoto(){
		this.qtVotos += 1;
	}
}
