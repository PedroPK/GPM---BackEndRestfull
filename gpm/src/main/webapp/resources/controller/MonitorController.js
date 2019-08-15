/**
 * Controlador de Monitor AgularJS.
 */

var MonitorControllerApp = angular.module("MonitorControllerApp", []);

MonitorControllerApp
		.controller(
				"MonitorController",
				function($scope, $window, $http) {

					$scope.id = null;
					$scope.modelo = null;
					$scope.montomb = null;
					$scope.descricao = null;

					$scope.init = function() {

						$scope.monitores = new Array();

						var response = $http.get("lista");

						response
								.success(function(data, status, headers, config) {

									$scope.monitores = data;

								});

						response
								.error(function(data, status, headers, config) {

									$window
											.alert("Erro ao Tentar Listar. Verifique Sua Conexão com o Banco "
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

					$scope.submitForm = function(isValid) {

						if (isValid) {

							$scope.cadastrarMonitor();

						}

					}

					$scope.buscar = function(nome) {

						$scope.monitores = new Array();

						var response = $http.post("buscar/" + nome);

						response
								.success(function(data, status, headers, config) {

									$scope.monitores = data;

								});

					}

					$scope.cadastrarMonitor = function() {

						var monitor = new Object();
						monitor.modelo = $scope.modelo;
						monitor.montomb = $scope.montomb;
						monitor.descricao = $scope.descricao;
						monitor.setor =  $scope.setor;

						var response = $http.post("cadastrar", monitor);

						response
								.success(function(data, status, headers, config) {

									if (data.montomb != null) {

										$window
												.alert("Cadastro de Monitor com Tombamento "
														+ monitor.montomb
														+ " realizado com Sucesso !!! ");

										$scope.modelo = null;
										$scope.montomb = null;
										$scope.descricao = null;
										$scope.setor = null;

										window.location.href = "listar";

									} else {

										$window
												.alert("Erro ao Tentar Cadastrar");
									}
								});

						response.error(function(data, status, headers, config) {

							$window.alert("Erro ao Tentar Alterar ");

						});
					}

					$scope.alterarMonitor = function(montomb) {

						var mensagem = confirm("Deseja Realmente Alterar Cadastro de Monitor ??? ");

						if (mensagem == true) {

							var monitor = new Object();
							monitor.id = $scope.id;
							monitor.modelo = $scope.modelo;
							monitor.montomb = $scope.montomb;
							monitor.descricao = $scope.descricao;

							var response = $http.post("../alterar", monitor);

							response
									.success(function(data, status, headers,
											config) {

										$window
												.alert("Cadastro de Monitor Alterado com Sucesso !!!");

										$scope.id = null;
										$scope.modelo = null;
										$scope.montomb = null;
										$scope.descricao = null;

										window.location.href = "../listar";

									});

							response.error(function(data, status, headers,
									config) {

								$window.alert("Erro ao Tentar Alterar ");

							});

						}

					}

					$scope.excluir = function(id, montomb) {

						console.log("Teste");

						var mensagem = confirm("Deseja Realmente Excluir o Cadastro de Monitor  ??? ");

						if (mensagem == true) {

							var response = $http.post("excluir/" + id);

							response
									.success(function(data, status, headers,
											config) {

										$scope.init();

										$window
												.alert("Cadastro de Monitor excluido com Sucesso !!!");

									});

							response.error(function(data, status, headers,
									config) {

								$window.alert("Erro ao Tentar Excluir ");

							});
						}

					}

				});
