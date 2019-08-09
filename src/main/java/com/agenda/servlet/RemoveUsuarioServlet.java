package com.agenda.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.agenda.model.Pessoa;
import com.agenda.service.CadastraUsuarioService;

@WebServlet("/remove-usuario")
public class RemoveUsuarioServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private CadastraUsuarioService service;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			long id = Long.parseLong(request.getParameter("id"));
			Pessoa pessoa = new Pessoa();
			pessoa.setId(id);
            this.service = new CadastraUsuarioService();
        	this.service.remover(pessoa);
			response.sendRedirect("busca-contatos");
		} catch (Exception e) {
			throw new ServletException("A lógica de negócios causou uma exceção", e);
		}
	}
	
}
