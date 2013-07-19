package br.com.bluesoft.jdbc;

import java.sql.SQLException;
import java.sql.Connection;

import org.junit.Test;

public class ConnectionFactoryTest {

	@Test
	public void connectionFactoryTest() throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexao estabelecida.");
		connection.close();
	}

}
