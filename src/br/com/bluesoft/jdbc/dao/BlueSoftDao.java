package br.com.bluesoft.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.bluesoft.jdbc.ConnectionFactory;
import br.com.bluesoft.jdbc.modelo.Contatos;
import br.com.bluesoft.jdbc.modelo.VoteNoFilme;

public class BlueSoftDao {

	private Connection connection;
	
	public BlueSoftDao() {
		// TODO Auto-generated constructor stub
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public List<VoteNoFilme> getSelect(String sql){
		List<VoteNoFilme> filmes = new ArrayList<VoteNoFilme>();
	
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		
			while (rs.next()){
				VoteNoFilme filme = new VoteNoFilme();
				filme.setId(rs.getLong("id"));
				filme.setNome_Filme(rs.getString("nome_filme"));
				filme.setQtVoto(rs.getInt("qtvotos"));
				filmes.add(filme);
			}
			stmt.close();
			return filmes;
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

	public void adicionaVoto(Long parametro){
		String sql = "select * from vote_no_filme where id = " + parametro;
		List<VoteNoFilme> filmevotado = this.getSelect(sql);
		filmevotado.get(0).getSomaVoto();
		sql = "update vote_no_filme set qtvotos = " + filmevotado.get(0).getQtvoto() + " where id = " + filmevotado.get(0).getId();
		this.update(sql);
	}
	
	public void update(String sql){
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();
		} catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

//	public void getInsertContato(String nome, String email) {
//		String sql = "insert into contatos ( nome, email) values (?,?)";
	public void getInsertContato(Contatos contato) {
		String sql = "insert into contatos ( nome, email) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.geteMail());
			stmt.execute();
			stmt.close();
		} catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	

}
