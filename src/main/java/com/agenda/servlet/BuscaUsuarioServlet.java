package com.agenda.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agenda.model.Pessoa;
import com.agenda.service.CadastraUsuarioService;

@WebServlet("/busca-usuario")
public class BuscaUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nomeSearch");

		CadastraUsuarioService service = new CadastraUsuarioService();
		
		List<Pessoa> contatos = service.buscaPessoaPorNome(nome);
		
		request.setAttribute("contatos", contatos);
		
		request.getRequestDispatcher("lista-contatos-ajax.jsp").forward(request, response);

	}

}