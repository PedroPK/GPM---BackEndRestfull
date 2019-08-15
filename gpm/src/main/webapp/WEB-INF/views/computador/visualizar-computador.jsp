<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html ng-app="ComputadorControllerApp" >
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<title>GPM | VISUALIZAR COMPUTADOR</title>
		
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
						Computador</h3>
				</div>
				
				<!-- Formulário -->
				<form name="userForm" ng-submit="submitForm(userForm.$valid)" class="form-horizontal" ng-controller="ComputadorController" >
					<div class="panel panel-default">
						<div class="panel-body">
						
						
						
						
						<div class="form-group">
								<label for="codigo" class="col-sm-2 control-label">Codigo
								*</label>
								<div class="col-sm-1">
									<input type="text" class="form-control" id="id" name="id"
										placeholder="Código do Computador" required="required"
										autofocus="autofocus" ng-model="id" readonly="readonly"  ng-init="id='${computador.id}'"/>
								</div>
							</div>				
						
						
								<div  class="form-group" >		
								<label for="modelo" class="col-sm-2 control-label">Modelo*</label>
								<div class="col-sm-2">
										<input type="text" class="form-control" id="nome" name="nome"
										placeholder="Modelo do computador" required="required"
										autofocus="autofocus" ng-model="modelo" required  readonly="readonly" ng-init="modelo='${computador.modelo}'"/>
										<p ng-show="userForm.modelo.$invalid && !userForm.modelo.$pristine" class="help-block"></p>
								</div>	</div>
						
						
								
								<div  class="form-group"  >		
								<label for="nome" class="col-sm-2 control-label">Nome*</label>
								<div class="col-sm-3">
										<input type="text" class="form-control" id="nome" name="nome"
										placeholder="Nome do computador" required="required"
										autofocus="autofocus" ng-model="nome" required  readonly="readonly" ng-init="nome='${computador.nome}'"/>
										<p ng-show="userForm.nome.$invalid && !userForm.nome.$pristine" class="help-block"></p>
								</div>	</div>
							
							<div  class="form-group" >		
								<label for="descricao" class="col-sm-2 control-label">Descrição*</label>
								<div class="col-sm-3">
										<input type="text" class="form-control" id="descricao" name="descricao"
										placeholder="Descrição do computador" required="required"
										autofocus="autofocus" ng-model="descricao" required  readonly="readonly" ng-init="descricao='${computador.descricao}'"/>
										<p ng-show="userForm.descricao.$invalid && !userForm.descricao.$pristine" class="help-block"></p>
								</div>	</div>
							

							<div class="form-group"  >
								<label for="gap_tomb" class="col-sm-2 control-label">Tombamento*</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="gap_tomb"
										name="gap_tomb" placeholder="(Patrimônio)" required
										autofocus="autofocus" ng-model="gap_tomb"  readonly="readonly" ng-init="gap_tomb='${computador.gap_tomb}'"/>
										<p ng-show="userForm.gap_tomb.$invalid && !userForm.gap_tomb.$pristine" class="help-block"></p>
								</div>
								</div>
								
								<div class="form-group" >
								<label for="computador_setor" class="col-sm-2 control-label">Setor*</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="computador_setor"
										name="computador_setor" placeholder="computador_setor" required
										autofocus="autofocus" ng-model="computador_setor.nome"  readonly="readonly" ng-init="computador_setor='${setorcomputador.nome}'"/>
										
								</div>
								</div>
								
						    
                                <div class="form-group" >
								<label for="ip" class="col-sm-2 control-label">IP*</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="ip"
										name="ip" placeholder="Ex: 192.168.102.14" required
										autofocus="autofocus" ng-model="ip"  readonly="readonly" ng-init="ip='${computador.ip}'"/>
										<p ng-show="userForm.ip.$invalid && !userForm.ip.$pristine" class="help-block"></p>
								</div>
								</div>
								
								 <div class="form-group"  >
								<label for="tipo" class="col-sm-2 control-label">Tipo*</label>
								<div class="col-sm-1">
									<input type="text" class="form-control" id="tipo"
										name="tipo" placeholder="1 ou 2" required
										autofocus="autofocus" ng-model="tipo"  readonly="readonly" ng-init="tipo='${computador.tipo}'"/>
										<p ng-show="userForm.tipo.$invalid && !userForm.tipo.$pristine" class="help-block"></p>
								</div>
								</div>
								
							
								
									<div class="form-group"  >
								<label for="ramal" class="col-sm-2 control-label">Ramal*</label>
								<div class="col-sm-2">
									<input type="text" class="form-control" id="ramal"
										name="ramal" placeholder="Ramal" required
										autofocus="autofocus" ng-model="ramal"  readonly="readonly" ng-init="ramal='${computador.ramal}'"/>
										<p ng-show="userForm.ramal.$invalid && !userForm.ramal.$pristine" class="help-block"></p>
								</div>
								</div>
														
														
						</div>
					</div>
				</form>
			</div>
		</section>
			
		<!-- AngularJS e JS -->
		<script src="<c:url value='/resources/js/angular.min.js' />"></script>
		<script src="<c:url value='/resources/controller/ComputadorController.js' />"></script>
		<script src="<c:url value='/resources/js/jquery-3.2.1.min.js' />"></script>
		<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
					 
	</body>

</html>
