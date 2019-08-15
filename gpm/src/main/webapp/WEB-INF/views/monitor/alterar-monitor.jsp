<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html ng-app="MonitorControllerApp">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>GPM | EDITAR CADASTRO DE MONITOR.</title>

<!-- CSS -->
<link href="<c:url value='/resources/css/bootstrap.min.css' />"
	rel="stylesheet"></link>
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
				<h3 class="panel-title panel-title-computador">Editar Cadastro
					de Monitor</h3>
			</div>

			<!-- Formulário -->
			<form name="userForm" class="form-horizontal"
				ng-submit="submitForm(userForm.$valid)"
				ng-controller="MonitorController">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="form-group">
							<label for="codigo" class="col-sm-2 control-label">Codigo
								*</label>
							<div class="col-sm-2">
								<input type="text" class="form-control" id="id" name="id"
									placeholder="Código do Monitor" required="required"
									autofocus="autofocus" ng-model="id" readonly="readonly"
									ng-init="id='${monitor.id}'" />
							</div>
						</div>


						<div class="form-group">
							<label for="modelo" class="col-sm-2 control-label">Modelo*</label>
							<div class="col-sm-3">
								<select class="form-control" name="modelo" id="modelo"
									ng-model="modelo" ng-init="modelo='${monitor.modelo}'">
									<option valeu="HP" ng-selected="true">HP</option>
									<option valeu="LG">LG</option>
									<option valeu="Lenovo">Lenovo</option>
									<option valeu="AOC">AOC</option>
									<option valeu="Sansung">Sansung</option>
								</select>
							</div>
						</div>


						<div class="form-group"
							ng-class="{ 'has-error' : userForm.montomb.$invalid && !userForm.montomb.$pristine }">
							<label for="montomb" class="col-sm-2 control-label">Tombamento*</label>
							<div class="col-sm-3">
								<input type="text" class="form-control" id="montomb"
									name="montomb" placeholder="Tombamento(Patrimônio)" required
									autofocus="autofocus" ng-model="montomb"
									ng-init="montomb='${monitor.montomb}'" />
							</div>

						</div>
						
                                 <div class="form-group">
								<label for="setor" class="col-sm-2 control-label">Setor*</label>
								<div class="col-sm-2">
										<select ng-model="setor" class="form-control" name="setor" id="setor" 
										ng-options="setor.nome for setor in setores"></select>
									
									
							</div>
							</div>
							
							
						<div class="form-group">
							<label for="descricao" class="col-sm-2 control-label">Descrição*</label>
							<div class="col-sm-3"
								ng-class="{ 'has-error' : userForm.descricao.$invalid && !userForm.descricao.$pristine }">
								<input type="text" class="form-control" id="descricao"
									name="descricao" placeholder="Escreva uma descrição" required
									autofocus="autofocus" ng-model="descricao"
									ng-init="descricao='${monitor.descricao}'" />

								<div class="form-group" align="center">
									<div class="col-sm-5">
										<button type="button" class="btn btn-primary"
											ng-disabled="userForm.$invalid"
											ng-click="alterarMonitor(userForm.$valid)">Alterar
											Cadastro</button>
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
	<script
		src="<c:url value='/resources/controller/MonitorController.js' />"></script>
	<script src="<c:url value='/resources/js/jquery-3.2.1.min.js' />"></script>
	<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>

</body>

</html>
