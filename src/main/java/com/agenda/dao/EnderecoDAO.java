package com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.agenda.model.Endereco;
import com.agenda.util.ConnectionFactory;

public class EnderecoDAO {
	
	private Connection connection;

	public void cadastrar(Endereco endereco) {

		String SQL = "insert into enderecos (logradouro, cep) values (?,?)";

		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getCep());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


}
