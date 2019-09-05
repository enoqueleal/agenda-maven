package com.agenda.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.agenda.model.Contato;
import com.agenda.util.ConnectionFactory;
import com.mysql.jdbc.Connection;

public class ContatoDAO {

	private Connection connection;

	public void cadastrar(Contato contato) {

		String SQL = "insert into contatos (email, telefone) values (?,?)";

		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			stmt.setString(1, contato.getEmail());
			stmt.setString(2, contato.getTelefone());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
