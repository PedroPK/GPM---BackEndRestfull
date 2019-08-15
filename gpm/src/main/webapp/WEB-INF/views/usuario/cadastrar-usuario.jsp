<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html ng-app="UsuarioControllerApp" >
	<head>
	<meta charset="utf-8" />
	<title>GPM | CADASTRO DE USUÁRIO</title>
	
	<!-- CSS -->
	<link href="<c:url value='../resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
	<link href="<c:url value='../resources/css/style.css' />" rel="stylesheet"></link>
	
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
			<div class="panel panel-computador panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title panel-title-computador">Cadastro de
						Usuário</h3>
				</div>
				
				<!-- Formulário -->
				<form name="userForm" ng-submit="submitForm(userForm.$valid)" novalidate class="form-horizontal" ng-controller="UsuarioController" >
					<div class="panel panel-default">
						<div class="panel-body">
						
							<div class="form-group" ng-class="{ 'has-error' : userForm.nome.$invalid && !userForm.nome.$pristine }" >
								<label for="nome" class="col-sm-2 control-label">Nome
									Completo*</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="nome" name="nome"
										placeholder="Nome Completo do Usuário" 
										autofocus="autofocus" ng-model="nome" ng-minlength="3" ng-maxlength="30" required />
										<p ng-show="userForm.nome.$invalid && !userForm.nome.$pristine" class="help-block">Nome é Obrigatório.</p>
										<p ng-show="userForm.nome.$error.minlength" class="help-block">Nome mínimo de 3 caracteres.</p>
                						<p ng-show="userForm.nome.$error.maxlength" class="help-block">Nome máximo de 30 caracteres.</p>
										
										
								</div>
								</div>
								
								<div class="form-group" ng-class="{ 'has-error' : userForm.email.$invalid && !userForm.email.$pristine }">
								<label for="setor" class="col-sm-2 control-label">Email*</label>
								<div class="col-sm-3">
									<input type="email" class="form-control" id="email" name="email"
										placeholder="Email do Usuário" required="required" 
										autofocus="autofocus" ng-model="email"/>
										<p ng-show="userForm.email.$invalid && !userForm.email.$pristine" class="help-block">Informe um E-mail Válido.</p>
								</div>
							</div>

							<div class="form-group" ng-class="{ 'has-error' : userForm.senha.$invalid && !userForm.senha.$pristine }" >
								<label for="ip" class="col-sm-2 control-label">Senha*</label>
								<div class="col-sm-2">
									<input type="password" class="form-control" id="senha"
										name="senha" placeholder="Senha do Usuário" required 
										autofocus="autofocus" ng-model="senha" ng-minlength="6" ng-maxlength="30"/>
										<p ng-show="userForm.senha.$invalid && !userForm.senha.$pristine" class="help-block">Senha é Obrigatório.</p>
										<p ng-show="userForm.senha.$error.minlength" class="help-block">Senha minima de 6 caracteres.</p>
                						<p ng-show="userForm.senha.$error.maxlength" class="help-block">Senha máximo de 30 caracteres.</p>
										
								</div>
								</div>
								
								<div class="form-group" ng-class="{ 'has-error' : userForm.rsenha.$invalid && !userForm.rsenha.$pristine }">
								<label for="ip" class="col-sm-2 control-label">Repetir
									Senha*</label>
									<div class="col-sm-2">
									<input type="password" class="form-control" id="rsenha"
										name="rsenha" placeholder="Senha do Usuário" 
										required autofocus="autofocus" ng-model="rsenha" ng-minlength="6" ng-maxlength="30"/>
										<p ng-show="userForm.rsenha.$invalid && !userForm.rsenha.$pristine" class="help-block">Repetir Senha é Obrigatório.</p>
										<p ng-show="userForm.rsenha.$error.minlength" class="help-block">Repetição de Senha no mínimo 6 caracteres.</p>
                						<p ng-show="userForm.rsenha.$error.maxlength" class="help-block">Repetição de Senha no máximo 30 caracteres.</p>
										
									</div>
							</div>


							<div class="form-group" ng-class="{ 'has-error' : userForm.telefone.$invalid && !userForm.telefone.$pristine }" >
								<label for="ramal" class="col-sm-2 control-label">Telefone</label>
								<div class="col-sm-2">
									<input type="telefone" class="form-control" id="telefone"
										name="telefone" placeholder="Telefone do Usuário" 
										required autofocus="autofocus" ng-model="telefone" ng-minlength="9" ng-maxlength="20" ui-mask="(99)9?9999-9999"/>
										<p ng-show="userForm.telefone.$invalid && !userForm.telefone.$pristine" class="help-block">Telefone é Obrigatório.</p>
										<p ng-show="userForm.telefone.$error.minlength" class="help-block">Número telefônico no mínimo 9 caracteres.</p>
                						<p ng-show="userForm.telefone.$error.maxlength" class="help-block">Número telefônico no máximo 20 caracteres.</p>
										
								</div>
								</div>
								
								<div class="form-group">
								<label for="status" class="col-sm-2 control-label">Perfil*</label>
								<div class="col-sm-2">
									<select class="form-control" name="perfil" id="perfil" ng-model="perfil" ng-init="perfil='Padrão'">
										<option valeu="Padrão" ng-selected="true">Padrão</option>
										<option valeu="Admin">Admin</option>
									</select>										
				
							<div class="form-group" align="center">
								<div class="col-sm-5">
									<button type="button" class="btn btn-primary" ng-disabled="userForm.$invalid" ng-click="submitForm(userForm.$valid)" >Cadastrar</button>
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
		<script src="<c:url value='../resources/js/angular.min.js' />"></script>
		<script src="<c:url value='../resources/controller/UsuarioController.js' />"></script>
		<script src="<c:url value='../resources/js/jquery-3.2.1.min.js' />"></script>
		<script src="<c:url value='../resources/js/bootstrap.min.js' />"></script>
			 
	</body>
</html>
