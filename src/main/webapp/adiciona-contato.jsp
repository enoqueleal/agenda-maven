<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Adiciona contato</title>
</head>
<body>
	
	<div class="text-center">
		<h1 class="display-4">Formulário de cadastro</h1>
    </div>
   
	<div class="card">
		<div class="card-body">
			<form action="cadastra-usuario" id="form-produto">
			
				<input type="hidden" id="id" name="id" value="${param.id}">
			
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="nome">Nome</label> 
						<input type="text" value="${param.nome}" class="form-control" id="name" name="nome" placeholder="Nome" >
					</div>
				</div>

				<div class="form-row">
					<div class="form-group col-md-3">
						<label for="tel">Telefone</label> 
						<input type="text" value="${param.telefone}" class="form-control" id="tel" name="telefone" placeholder="Telefone" data-mask="(99)9999-9999">
					</div>

					<div class="form-group col-md-3">
						<label for="email">E-mail</label> 
						<input type="email" value="${param.email}" class="form-control" id="email" name="email" placeholder="E-mail">
					</div>

					<div class="form-group col-md-6">
						<label for="end">Endereço</label> 
						<input type="text" value="${param.endereco}" class="form-control" id="end" name="endereco" placeholder="Endereço">
					</div>

					<div class="form-group col-md-6">
						<button class="btn btn-success" id="btnSalvar" type="submit">Salvar</button>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>