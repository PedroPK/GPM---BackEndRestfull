<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html ng-app="ComputadorControllerApp">
	<head>
		 <meta charset="utf-8">
		 <meta http-equiv="X-UA-Compatible" content="IE=edge">
		 <meta name="viewport" content="width=device-width, initial-scale=1">
		 <title>GPM | LISTA DE COMPUTADORES</title>

		 <!-- CSS -->
		<link href="<c:url value='../resources/css/bootstrap.min.css' />" rel="stylesheet"></link>
		<link href="<c:url value='../resources/css/style.css' />" rel="stylesheet"></link> 

	</head>
	<body>
	
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
	
	 <div id="main" class="container-fluid" style="margin-top: 50px" ng-controller="ComputadorController" data-ng-init="init(setor)">
	 
	 	<div id="top" class="row">
			<div class="col-sm-3">
				<h2>Lista Computador</h2>
			</div>
			<div class="col-sm-5">
				
				<div class="input-group h2">
					<input name="setor" class="form-control" id="setor" type="text" placeholder="Pesquisar Computador por setor" ng-model="setor">
					<span class="input-group-btn">
						<button class="btn btn-primary" type="submit" ng-click="buscar(setor)">
							<span3 class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
				
			</div>
			<div class="col-sm-3">
				<a href="cadastrar" class="btn btn-primary pull-right h2">Cadastrar Novo Computador</a>
				
			</div>
		</div> <!-- /#top -->
	 
	 
	 	<hr />
	 	<div id="list" class="row">
		
		<div class="table-responsive col-md-12">
			<table class="table table-striped" cellspacing="0" cellpadding="0" >
				<thead>
					<tr>
						<th>ID</th>
						<th>Modelo</th>
						<th>Nome</th>
						<th>Ramal</th>
						<th>IP</th>
						<th class="actions">Ações</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="computador in computadores">
						<td>{{computador.id}}</td>
						<td>{{computador.modelo}}</td>
						<td>{{computador.nome}}</td>
						<td>{{computador.ramal}}</td>
						<td>{{computador.ip}}</td>
						<td class="actions">
							<a class="btn btn-success btn-xs" href="visualizar" ng-href="visualizar/{{computador.id}}">Visualizar</a>
							<a class="btn btn-warning btn-xs" href="alterar" ng-href="alterar/{{computador.id}}" >Editar</a>
							<a class="btn btn-danger btn-xs"  href="excluir" data-toggle="modal" data-target="#delete-modal" ng-click="excluir(computador.id, computador.modelo)">Excluir</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		</div> <!-- /#list -->
		
		<div id="bottom" class="row">
			<div class="col-md-12">
				<ul class="pagination">
					<li class="disabled"><a>&lt; Anterior</a></li>
					<li class="disabled"><a>1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li class="next"><a href="#" rel="next">Próximo &gt;</a></li>
				</ul><!-- /.pagination -->
			</div>
		</div> <!-- /#bottom -->
	 </div> <!-- /#main --> 
	
	 	<!-- AngularJS e JS -->
		<script src="<c:url value='../resources/js/angular.min.js' />"></script>
		<script src="<c:url value='../resources/controller/ComputadorController.js' />"></script>
		<script src="<c:url value='../resources/js/jquery-3.2.1.min.js' />"></script>
		<script src="<c:url value='../resources/js/bootstrap.min.js' />"></script>
	
	</body>
	
</html>