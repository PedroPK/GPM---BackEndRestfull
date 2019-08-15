<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html ng-app="ImpressoraControllerApp" >
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>GPM | EDITAR CADASTRO DE IMPRESSORA</title>
		
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
			<div class="panel panel-computador panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title panel-title-computador">Visualizar Cadastro de
						Impressora</h3>
				</div>
				
				<!-- Formulário -->
				<form name="userForm" class="form-horizontal" ng-controller="ImpressoraController" >
					<div class="panel panel-default">
						<div class="panel-body">
						
						<div class="form-group">
								<label for="codigo" class="col-sm-2 control-label">Codigo
								*</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="id" name="id"
										placeholder="Código da Impressora" required="required"
										autofocus="autofocus" ng-model="id" readonly="readonly"  ng-init="id='${impressora.id}'"/>
								</div>
							</div>
						
							<div class="form-group" >
								<label for="modelo" class="col-sm-2 control-label">Modelo*</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="modelo" name="modelo"
										placeholder="Modelo da impressora"
										autofocus="autofocus" ng-model="modelo" required readonly="readonly" ng-init="modelo='${impressora.modelo}'" />
										<p  class="help-block"></p>
										
										</div>
										</div>
										
								<div class="form-group" >		
								<label for="descricao" class="col-sm-2 control-label">Descrição*</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="descricao" name="descricao"
										placeholder="Descrição da impressora" required="required"
										autofocus="autofocus" ng-model="descricao" required readonly="readonly" ng-init="descricao='${impressora.descricao}'"/>
										<p  class="help-block"></p>
								</div>
							</div>

							<div class="form-group" >
								<label for="ramal" class="col-sm-2 control-label">Ramal*</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="ramal"
										name="ramal" placeholder="Ramal" required
										autofocus="autofocus" ng-model="ramal" readonly="readonly" ng-init="ramal='${impressora.ramal}'"/>
										<p  class="help-block"></p>
								</div>
								</div>
								
								<div class="form-group" >
								<label for="impressora_setor" class="col-sm-2 control-label">Setor*</label>
								<div class="col-sm-3" >
									<input type="text" class="form-control" id="impressora_setor"
										name="impressora_setor"
										required autofocus="autofocus" ng-model="impressora_setor" readonly="readonly" ng-init="impressora_setor='${impressora.impressora_setor.nome}'"/>
										<p  class="help-block">
									</div>
							</div>

                                <div class="form-group" >
								<label for="ramal" class="col-sm-2 control-label">IP*</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="ip"
										name="ip"  required
										autofocus="autofocus" ng-model="ip" readonly="readonly" ng-init="ip='${impressora.ip}'"/>
										<p ng-show="userForm.ip.$invalid && !userForm.ip.$pristine" class="help-block"></p>
								</div>
								</div>
								
								<div class="form-group" >
								<label for="setor" class="col-sm-2 control-label">Número de Série*</label>
								<div class="col-sm-3" >
									<input type="text" class="form-control" id="num_serie"
										name="num_serie" 
										required autofocus="autofocus" ng-model="num_serie" readonly="readonly" ng-init="num_serie='${impressora.num_serie}'" />
										<p class="help-block"></p>
									</div>
							</div>
							
						</div>
					</div>
				</form>
			</div>
		</section>
			
		<!-- AngularJS e JS -->
		<script src="<c:url value='/resources/js/angular.min.js' />"></script>
		<script src="<c:url value='/resources/controller/ImpressoraController.js' />"></script>
		<script src="<c:url value='/resources/js/jquery-3.2.1.min.js' />"></script>
		<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
					 
	</body>

</html>
