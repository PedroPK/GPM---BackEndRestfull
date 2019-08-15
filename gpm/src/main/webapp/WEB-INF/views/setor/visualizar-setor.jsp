<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html ng-app="SetorControllerApp" >
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>GPM | VISUALIZAR SETOR</title>
		
		<!-- CSS -->
		<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
		<link href="<c:url value='/resources/css/style.css' />" rel="stylesheet"></link> 
	
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
					<h3 class="panel-title panel-title-setor">Visualizar Cadastro de
						Setor</h3>
				</div>
				
				<!-- Formulário -->
				<form name="userForm" ng-submit="submitForm(userForm.$valid)" class="form-horizontal" ng-controller="SetorController" >
					<div class="panel panel-default">
						<div class="panel-body">
						
						
						
						
						<div class="form-group">
								<label for="codigo" class="col-sm-2 control-label">Codigo
								*</label>
								<div class="col-sm-1">
									<input type="text" class="form-control" id="id" name="id"
										placeholder="Código do setor" required="required"
										autofocus="autofocus" ng-model="id" readonly="readonly"  ng-init="id='${setor.id}'"/>
								</div>
							</div>				
						
										
						
								
								<div  class="form-group" >		
								<label for="nome" class="col-sm-2 control-label">Nome*</label>
								<div class="col-sm-3">
										<input type="text" class="form-control" id="nome" name="nome"
										placeholder="Nome do setor" required="required"
										autofocus="autofocus" ng-model="nome" required  readonly="readonly" ng-init="nome='${setor.nome}'"/>
										<p ng-show="userForm.nome.$invalid && !userForm.nome.$pristine" class="help-block"></p>
								</div>	</div>
							
							<div  class="form-group" >		
								<label for="descricao" class="col-sm-2 control-label">Descrição*</label>
								<div class="col-sm-3">
										<input type="text" class="form-control" id="descricao" name="descricao"
										placeholder="Descrição do setor" required="required"
										autofocus="autofocus" ng-model="descricao" required  readonly="readonly" ng-init="descricao='${setor.descricao}'"/>
										<p ng-show="userForm.descricao.$invalid && !userForm.descricao.$pristine" class="help-block"></p>
								</div>	</div>
						
														
														
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
