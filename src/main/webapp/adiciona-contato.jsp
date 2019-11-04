<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>	<title>Adiciona contato</title>
</head>
<body>
	<div class="text-center">
		<h1 class="display-4">Formulário de cadastro</h1>
    </div>
	
	<form action="cadastra-usuario" id="form-produto">
	
		<input type="hidden" id="id" name="id" value="${param.id}">
		<input type="hidden" id="id_endereco" name="id_endereco" value="${param.id_endereco}">
		<input type="hidden" id="id_contato" name="id_contato" value="${param.id_contato}">
		
		<div class="card">
			<div class="card-body">
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="nome">Nome</label> 
						<input type="text" value="${param.nome}" class="form-control" id="name" name="nome" placeholder="Nome" >
					</div>
					<div class="form-group col-md-6">
						<label for="nome">Nascimento</label> 
						<input type="date" value="${param.dataNascimento}" class="form-control" id="dataNascimento" name="dataNascimento" placeholder="Nascimento" >
					</div>
				</div>
			</div>
		</div>
		<br>
		<div class="card">
			<div class="card-body">
				<div class="form-group col-md-3">
					<label for="tel">Telefone</label> 
					<input type="text" value="${param.telefone}" class="form-control" id="tel" name="telefone" placeholder="Telefone" data-mask="(99) 9999-9999">
				</div>

				<div class="form-group col-md-3">
					<label for="email">E-mail</label> 
					<input type="email" value="${param.email}" class="form-control" id="email" name="email" placeholder="E-mail">
				</div>
			</div>
		</div>
		<br>
		<div class="card">
			<div class="card-body">
				<div class="form-group col-md-6">
					<label for="end">Logradouro</label> 
					<input type="text" value="${param.logradouro}" class="form-control" id="logradouro" name="logradouro" placeholder="Logradouro">
				</div>
				<div class="form-group col-md-6">
					<label for="end">CEP</label> 
					<input type="text" value="${param.cep}" class="form-control" id="cep" name="cep" placeholder="CEP" data-mask="99999-999">
				</div>
			</div>
		</div>
		<br>
		<div>
			<button class="btn btn-success" id="btnSalvar" type="submit">Salvar</button>
		</div>
	</form>
</body>
</html>