<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${empty contatos}">
	<div class="text-center">
		<hr>
		<h2>Nenhum contato cadastrado!</h2>
	</div>
</c:if>

<c:if test="${not empty contatos}">
	<table class="table">
		<tr>
			<th>Nome</th>
			<th>Data de Nascimento</th>
			<th></th>
		</tr>

		<c:forEach var="pessoa" items="${contatos}">
			<tr>
				<td>${pessoa.nome}</td>
				<td><fmt:formatDate value="${pessoa.dataNascimento.time}" pattern="dd-MM-yyyy" /></td>
				<td>
					<a href="#" onclick="saveContactId(${pessoa.id})" data-toggle="modal" data-target="#modalExemplo">Remover</a> 
					<span> | </span> 
					<a href="adiciona-contato.jsp?id=${pessoa.id}&nome=${pessoa.nome}&id_contato=${pessoa.contato.id}&email=${pessoa.contato.email}&telefone=${pessoa.contato.telefone}&id_endereco=${pessoa.endereco.id}&cep=${pessoa.endereco.cep}&logradouro=${pessoa.endereco.logradouro}&dataNascimento=<fmt:formatDate value="${pessoa.dataNascimento.time}" pattern="yyy-MM-dd"/>">Editar</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>