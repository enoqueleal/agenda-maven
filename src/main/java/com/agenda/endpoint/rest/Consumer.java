package com.agenda.endpoint.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.agenda.model.Pessoa;
import com.google.gson.Gson;

public class Consumer {

	public static void main(String[] args) {
		
		try {

			URL url = new URL("http://localhost:8080/agenda-maven/api/pessoas/1");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}

			InputStreamReader in = new InputStreamReader(conn.getInputStream());

			BufferedReader br = new BufferedReader(in);

			String output;

			while ((output = br.readLine()) != null) {
				Gson g = new Gson();
				Pessoa pessoa = g.fromJson(output, Pessoa.class);
				System.out.println(pessoa);
			}
			conn.disconnect();

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
		
	}

}
