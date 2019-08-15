<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html ng-app="SetorControllerApp">
<head>
<meta charset="utf-8" />
<title>GPM | CADASTRO DE SETOR</title>

<!-- CSS -->
<link href="<c:url value='../resources/css/bootstrap.min.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='../resources/css/style.css' />"
	rel="stylesheet"></link>

</head>
<body>
	<header>
		<!-- Topo da Página e MENU -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Gerenciador Parque Máquinas</a>
			</div>

			<div id="navbar" class="navbar-collapse collapse">
				
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/gpm/painel">Início</a></li>
					<li><a href="/gpm/usuario/listar">Usuário</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">Equipamentos </a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="/gpm/computador/listar">Computador</a> 
							<a class="dropdown-item" href="/gpm/monitor/listar">Monitor</a> 
							<a class="dropdown-item" href="/gpm/impressora/listar">Impressora</a>
							</div>
					<li><a href="/gpm/setor/listar">Setor</a></li>
				</ul>
			</div>
		</div>
	</nav>
	</header>

	<section>
		<!-- Painel -->
		<div class="panel panel-setor panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title panel-title-setor">Cadastro de
					Setor</h3>
			</div>

			<!-- Formulário -->
			<form name="userForm" ng-submit="submitForm(userForm.$valid)"
				class="form-horizontal" ng-controller="SetorController">
				<div class="panel panel-default">
					<div class="panel-body">



						<div class="form-group"
							ng-class="{ 'has-error' : userForm.nome.$invalid && !userForm.nome.$pristine }">
							<label for="nome" class="col-sm-2 control-label">Nome*</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="nome" name="nome"
									placeholder="Nome do setor" required="required"
									autofocus="autofocus" ng-model="nome" ng-minlength="3"
									ng-maxlength="30" required />
								<p ng-show="userForm.nome.$invalid && !userForm.nome.$pristine"
									class="help-block">Nome é Obrigatório.</p>
								<p ng-show="userForm.nome.$error.minlength" class="help-block">Nome
									mínimo de 3 caracteres.</p>
								<p ng-show="userForm.nome.$error.maxlength" class="help-block">Nome
									máximo de 30 caracteres.</p>
							</div>
						</div>


						<div class="form-group"
							ng-class="{ 'has-error' : userForm.descricao.$invalid && !userForm.descricao.$pristine }">
							<label for="descricao" class="col-sm-2 control-label">Descrição*</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="descricao"
									name="descricao" placeholder="Descrição do setor"
									required="required" autofocus="autofocus" ng-model="descricao"
									ng-minlength="3" ng-maxlength="30" required />
								<p
									ng-show="userForm.descricao.$invalid && !userForm.descricao.$pristine"
									class="help-block">Descrição é Obrigatório.</p>
								<p ng-show="userForm.descricao.$error.minlength"
									class="help-block">Campo mínimo de 3 caracteres.</p>
								<p ng-show="userForm.descricao.$error.maxlength"
									class="help-block">Campo máximo de 30 caracteres.</p>
							</div>
						</div>



						<div class="form-group" align="center">
							<div class="col-sm-5">
								<button type="button" class="btn btn-primary"
									ng-disabled="userForm.$invalid"
									ng-click="submitForm(userForm.$valid)">Cadastrar</button>
							</div>
						</div>
					</div>
				</div>
		</div>
		</div>
		</form>
		</div>
	</section>

	<!-- AngularJS e JS -->
		<script src="<c:url value='/resources/js/angular.min.js' />"></script>
	    <script src="<c:url value='/resources/controller/SetorController.js' />"></script>
		<script src="<c:url value='/resources/js/jquery-3.2.1.min.js' />"></script>
		<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>

</body>
</html>
