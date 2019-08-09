package com.agenda.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class TestaConexao {

	public static void main(String[] args) {
		
		try {
			Connection connection = new ConnectionFactory().getConnection();
			connection.close();
			System.out.println("Conexão aberta!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
