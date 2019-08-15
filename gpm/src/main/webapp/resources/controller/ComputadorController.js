/**
 * Controlador de Computador AgularJS.
 */

var ComputadorControllerApp = angular.module("ComputadorControllerApp", []);

ComputadorControllerApp
		.controller(
				"ComputadorController",
				function($scope, $window, $http) {

					$scope.id = null;
					$scope.nome = null;
					$scope.descricao = null;
					$scope.modelo = null;
					$scope.gap_tomb = null;
					$scope.ramal = null;
					$scope.setor = null;
					$scope.tipo = null;
					$scope.ip = null;

					$scope.init = function() {

					

  					    	$scope.listar();
						

						
					  

					}

					$scope.listar = function() {

										 
						$scope.computadores =  new Array();

						var response = $http.get("lista");

						response
								.success(function(data, status, headers, config) {

									$scope.computadores = data;

								});

						response
								.error(function(data, status, headers, config) {

									$window
											.alert("Erro ao Tentar Listar os computadores Verifique Sua Conexão com o Banco "
													+ data);

								});
					}
					
					
					$scope.listaSetor = function() {
						
						

						$scope.setores = new Array();

						var response = $http.get("listasetor");

						response
								.success(function(data, status, headers, config) {

									$scope.setores = data;

								});

						response
								.error(function(data, status, headers, config) {

									$window
											.alert("Erro ao Tentar Listar os Setores Verifique Sua Conexão com o Banco "
													+ data);

								});
					}
					
                        $scope.pesquisaSetor = function() {
						
						

						$scope.setorcomputador = new Array();

						var response = $http.get("pesquisasetor");

						response
								.success(function(data, status, headers, config) {

									$scope.setorcomputador = data;

								});

						response
								.error(function(data, status, headers, config) {

									$window
											.alert("Erro ao Tentar Recuperar o Setor Verifique Sua Conexão com o Banco "
													+ data);

								});
					}
					

					$scope.submitForm = function(isValid) {

						if (isValid) {

							$scope.cadastrarComputador();

						}

					}

					$scope.buscar = function(setor) {

						$scope.computadores = new Array();

						var response = $http.post("buscar/" + setor);

						response
								.success(function(data, status, headers, config) {

									$scope.computadores = data;

								});

					}

					$scope.cadastrarComputador = function() {

						var computador = new Object();
						computador.nome = $scope.nome;
						computador.descricao = $scope.descricao;
						computador.modelo = $scope.modelo;
						computador.gap_tomb = $scope.gap_tomb;
						computador.ramal = $scope.ramal;
						computador.setor = $scope.setor;
						computador.tipo = $scope.tipo;
						computador.ip = $scope.ip;

						var response = $http.post("cadastrar", computador);

						response
								.success(function(data, status, headers, config) {

									if (data.gap_tomb != null) {

										$window
												.alert("Cadastro de Computador Realizado com Sucesso !!!");

										computador.nome = $scope.nome;
										computador.descricao = $scope.descricao;
										computador.modelo = $scope.modelo;
										computador.gap_tomb = $scope.gap_tomb;
										computador.ramal = $scope.ramal;
										computador.setor = $scope.setor;
										computador.tipo = $scope.tipo;
										computador.ip = $scope.ip;

										window.location.href = "listar";

									} else {

										$window
												.alert("Erro ao Cadastrar Computador "
														+ data);
									}
								});

						response
								.error(function(data, status, headers, config) {

									$window
											.alert("Erro ao Tentar Cadastrar Computador "
													+ data);

								});
					}

					$scope.alterarComputador = function() {

						var mensagem = confirm("Deseja Realmente Alterar o Cadastro Computador ??? ");

						if (mensagem == true) {

							var computador = new Object();
							computador.id = $scope.id;
							computador.nome = $scope.nome;
							computador.descricao = $scope.descricao;
							computador.modelo = $scope.modelo;
							computador.gap_tomb = $scope.gap_tomb;
							computador.ramal = $scope.ramal;
							computador.setor = $scope.setor;
							computador.tipo = $scope.tipo;
							computador.ip = $scope.ip;

							var response = $http.post("../alterar", computador);

							response
									.success(function(data, status, headers,
											config) {

										$window
												.alert("Cadastro de Computador Alterado com Sucesso !!!");

										$scope.id = null;
										computador.nome = null;
										computador.descricao = null;
										computador.modelo = null;
										computador.gap_tomb = null;
										computador.ramal = null;
										computador.setor = null;
										computador.tipo = null;
										computador.ip = null;

										window.location.href = "../listar";

									});

							response
									.error(function(data, status, headers,
											config) {

										$window
												.alert("Erro ao Tentar Alterar Cadastro de Computador "
														+ data);

									});

						}

					}

					$scope.excluir = function(id, modelo) {

						var mensagem = confirm("Deseja Realmente Excluir o Cadastro de Computador ??? ");

						if (mensagem == true) {

							var response = $http.post("excluir/" + id);

							response
									.success(function(data, status, headers,
											config) {

										$scope.init();

										$window
												.alert("Cadastro de Computador Excluido com Sucesso !!!");

									});

							response
									.error(function(data, status, headers,
											config) {

										$window
												.alert("Erro ao Tentar Excluir Cadastro de Computador "
														+ data);

									});
						}

					}

				});
