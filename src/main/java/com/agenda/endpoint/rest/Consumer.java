package com.agenda.endpoint.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import javax.ws.rs.core.Response.Status;

import com.agenda.model.CalendarDeserializer;
import com.agenda.model.Pessoa;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Consumer {

	public static void main(String[] args) {
		
		try {

			URL url = new URL("http://localhost:8080/agenda-maven/api/pessoas/1");

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			
			if (connection.getResponseCode() != Status.OK.getStatusCode()) {
				throw new RuntimeException("Failed : HTTP Error code : " + connection.getResponseCode());
			}

			InputStreamReader in = new InputStreamReader(connection.getInputStream());

			BufferedReader br = new BufferedReader(in);

			String output;

			while ((output = br.readLine()) != null) {
				
				GsonBuilder gsonBuilder = new GsonBuilder();
				gsonBuilder.registerTypeAdapter(Calendar.class, new CalendarDeserializer());
				Gson gson = gsonBuilder.create();
				
				Pessoa pessoa = gson.fromJson(output, Pessoa.class);
				System.out.println(pessoa);
			}
			
			connection.disconnect();

		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
		
	}

}
