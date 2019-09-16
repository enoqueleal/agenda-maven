package com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agenda.model.Endereco;
import com.agenda.util.ConnectionFactory;

public class EnderecoDAO {
	
	private Connection connection;

	public Endereco cadastrar(Endereco endereco) {

		String SQL = "insert into enderecos (logradouro, cep) values (?,?)";
		
		try {

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setString(1, endereco.getLogradouro());
			stmt.setString(2, endereco.getCep());

			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
            while (rs.next()) {
            	endereco.setId(rs.getInt(1));
            }
            
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return endereco;

	}
	
	public Endereco buscarPorId(long id) {

		String SQL = "select * from enderecos where id = ?";

		try {

			Endereco endereco = new Endereco();

			this.connection = new ConnectionFactory().getConnection();
			PreparedStatement stmt = this.connection.prepareStatement(SQL);

			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				endereco.setId(id);
				endereco.setLogradouro(rs.getString("logradouro"));
				endereco.setCep(rs.getString("cep"));
			}

			stmt.close();
			this.connection.close();
			
			return endereco;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void remover(long id) {

		String SQL = "delete from enderecos where id=?";

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


}
