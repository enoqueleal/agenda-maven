package com.agenda.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.google.gson.annotations.JsonAdapter;

public class Pessoa {

	private long id;
	private String nome;
	private String foto;
	
	@JsonAdapter(CalendarDeserializer.class)
	private Calendar dataNascimento;
	
	private Contato contato;
	private Endereco endereco;

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataNascimento() {
		return dataNascimento.getTime();
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {

		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento);
			Calendar dt = Calendar.getInstance();
			dt.setTime(date);
			this.dataNascimento = dt;
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
