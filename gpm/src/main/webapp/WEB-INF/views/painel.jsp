<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8" />
	<title>GPM | INÍCIO</title>
	
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
				    	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						     <span class="sr-only">Toggle navigation</span>
						     <span class="icon-bar"></span>
						     <span class="icon-bar"></span>
						     <span class="icon-bar"></span>
				    	</button>
				    	<a class="navbar-brand" href="#">Gerenciador Parque Máquinas</a>
				   	</div>
				   	<div id="navbar" class="navbar-collapse collapse">
					    <ul class="nav navbar-nav navbar-right">
						     <li><a href="painel">Início</a></li>
						     <li><a href="usuario/listar">Usuário</a></li>
						     <li><a href="computador/listar">Computador</a></li>
						     <li><a href="monitor/listar">Monitor</a></li>
						     <li><a href="impressora/listar">Impressora</a></li>
						     <li><a href="setor/listar">Setor</a></li>
			    		</ul>
				   	</div>
		  		</div>
	 		</nav>
			
		</header>	

		<section>
		
		</section>		
		
		<!-- AngularJS e JS -->
		<script src="<c:url value='/resources/js/angular.min.js' />"></script>
		<script src="<c:url value='/resources/controller/UsuarioController.js' />"></script>
		<script src="<c:url value='/resources/js/jquery-3.2.1.min.js' />"></script>
		<script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
			 
	</body>
</html>
