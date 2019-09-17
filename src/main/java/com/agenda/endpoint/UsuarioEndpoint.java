package com.agenda.endpoint;

import java.net.URI;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.agenda.model.Pessoa;
import com.agenda.service.CadastraUsuarioService;

/**
 * 
 * @author Enoque Leal
 *
 */
@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioEndpoint {
	
	private CadastraUsuarioService service;
	
	public UsuarioEndpoint() {
		this.service = new CadastraUsuarioService();
	}
	
	@GET
	public Response buscarTodos() {
		return Response.ok(this.service.buscaPessoas()).build();
	}
	
	@GET
	@Path("{id}")
	public Response buscarPorId(@PathParam("id") long id) {
		return Response.ok(this.service.buscaPessoas()).build();
	}
	
	@POST
	public Response salvar(Pessoa pessoa, @Context UriInfo uri) {
		return Response.created(salvarOuAtualizar(pessoa, uri)).build();
	}
	
	@PUT
	public Response atualizar(Pessoa pessoa, @Context UriInfo uriInfo) {
		return Response.created(salvarOuAtualizar(pessoa, uriInfo)).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deletar(@PathParam("id") long id) {
		System.out.println(id);
		return Response.ok().build();
	}
	
	private URI salvarOuAtualizar(Pessoa pessoa, UriInfo uri) {
		String id = this.service.salvarOuAtualizar(pessoa);
		return uri.getAbsolutePathBuilder().path(id).build();
	}

}
