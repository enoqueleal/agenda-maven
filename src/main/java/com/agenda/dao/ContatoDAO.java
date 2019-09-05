package com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agenda.model.Contato;
import com.agenda.util.ConnectionFactory;

public class ContatoDAO {

	private Connection connection;

	public Contato cadastrar(Contato contato) {

		String SQL = "insert into contatos (email, telefone) values (?,?)";
		
		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, contato.getEmail());
			stmt.setString(2, contato.getTelefone());

			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
            while (rs.next()) {
            	contato.setId(rs.getInt(1));
            }
            
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return contato;
	}

}
