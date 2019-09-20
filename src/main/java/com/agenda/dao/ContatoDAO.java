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
	
	public void remover(long id) {

		String SQL = "delete from contatos where id=?";

		try {
			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(SQL);
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Contato buscarPorId(long id) {

		String SQL = "select * from contatos where id = ?";

		try {

			Contato contato = new Contato();

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				contato.setId(id);
				contato.setEmail(rs.getString("email"));
				contato.setTelefone(rs.getString("telefone"));
			}

			stmt.close();
			this.connection.close();
			
			return contato;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void alterar(Contato contato) {

		String SQL = "update contatos set email=?, telefone=? where id=?";
		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			stmt.setString(1, contato.getEmail());
			stmt.setString(2, contato.getTelefone());
			stmt.setLong(3, contato.getId());
			
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
