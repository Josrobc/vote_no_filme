package br.com.bluesoft.jdbc.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="contatos")
public class Contatos {

	@Id
	@GeneratedValue
	private Long id;
	@NotNull @Size(max=80)
	private String nome;
	@NotNull @Size(max=80)
	private String eMail;
	
	public Contatos(HttpServletRequest request) {
		// TODO Auto-generated constructor stub
		this.nome  = request.getParameter("campoNome");
		this.eMail = request.getParameter("campoeMail");
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
}
