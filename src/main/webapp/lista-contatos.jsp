<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" rel="stylesheet">
</head>
<body>

	<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
		<h5 class="my-0 mr-md-auto font-weight-normal">Agenda</h5>
		<nav class="my-2 my-md-0 mr-md-3">
			<a class="p-2 text-dark" href="index.html">Home</a>
			<a class="p-2 text-dark" href="adiciona-contato.jsp">Cadastrar</a>
			<a class="p-2 text-dark" href="busca-contatos">Listar</a>
		</nav>
	</div>
	
	<div class="container">
	
		<div class="text-center">
			<h1 class="display-4">Lista de contatos</h1>
	    </div>
	
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
							<td><fmt:formatDate value="${pessoa.dataNascimento.time}" pattern="dd-MM-yyyy"/></td>
							<td>
								<a href="#" onclick="saveContactId(${pessoa.id})" data-toggle="modal" data-target="#modalExemplo">Remover</a>
								<span> | </span>
								<a href="adiciona-contato.jsp?id=${pessoa.id}&nome=${pessoa.nome}&id_endereco=${pessoa.endereco.id}&cep=${pessoa.endereco.cep}&logradouro=${pessoa.endereco.logradouro}&dataNascimento=<fmt:formatDate value="${pessoa.dataNascimento.time}" pattern="yyy-MM-dd"/>">Editar</a>
							</td>
						</tr>
					</c:forEach>
			</table>
		</c:if>
		
	</div>
	
	<div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Alerta!</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
					 	<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<span>Você realmente deseja remover esse contato?</span>
				</div>
				<div class="modal-footer">
					 <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					 <a href="#" onclick="removeContact()" class="btn btn-primary">Continuar</a>
				</div>
			</div>
		</div>
	</div>
		
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" ></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script>
	
		var contact;
		
		function saveContactId(idContact){ 
			contact = idContact;
		}
		
		function removeContact(){
			window.location.href = "remove-usuario?id="+contact;
		}
		
	</script>

</body>
</html>