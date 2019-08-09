package com.agenda.service;

import java.util.List;

import com.agenda.dao.PessoaDAO;
import com.agenda.model.Pessoa;

public class CadastraUsuarioService {

	private PessoaDAO dao;

	public CadastraUsuarioService() {
		this.dao = new PessoaDAO();
	}

	public void salvarOuAtualizar(Pessoa pessoa) {

		if (pessoa.getId() == 0) {
			this.dao.cadastrar(pessoa);
		} else {
			this.dao.alterar(pessoa);
		}
	}

	public List<Pessoa> buscaPessoas() {
		return this.dao.buscarPessoas();
	}

	public void remover(Pessoa pessoa) {
		this.dao.remover(pessoa);
	}

}
