/**
 * Controlador de Impressora AgularJS.
 */

var ImpressoraControllerApp = angular.module("ImpressoraControllerApp", []);

ImpressoraControllerApp
		.controller(
				"ImpressoraController",
				function($scope, $window, $http) {

					$scope.id = null;
					$scope.descricao = null;
					$scope.ramal = null;
					$scope.setor = null;
					$scope.num_serie = null;
					$scope.modelo = null;
					$scope.ip = null;

					$scope.init = function() {
						
					
							$scope.listar();
					

					}

					$scope.listar = function() {
						$scope.impressoras = new Array();

						var response = $http.get("lista");

						response
								.success(function(data, status, headers, config) {

									$scope.impressoras = data;

								});

						response
								.error(function(data, status, headers, config) {

									$window
											.alert("Erro ao Tentar Listar Verifique Sua Conexão com o Banco "
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

							$scope.cadastrarImpressora();

						}

					}

					$scope.buscar = function(nome) {

						$scope.impressoras = new Array();

						var response = $http.post("buscar/" + nome);

						response
								.success(function(data, status, headers, config) {

									$scope.impressoras = data;

								});

					}

					$scope.cadastrarImpressora = function() {

						var impressora = new Object();
						impressora.descricao = $scope.descricao;
						impressora.ramal = $scope.ramal;
						impressora.ip = $scope.ip;
						impressora.setor = $scope.setor;
						impressora.num_serie = $scope.num_serie;
						impressora.modelo = $scope.modelo;

						var response = $http.post("cadastrar", impressora);

						response
								.success(function(data, status, headers, config) {

									if (data.num_serie != null) {

										$window
												.alert("Cadastro de impressora realizado com Sucesso !!!");

										impressora.descricao = $scope.descricao;
										impressora.ip = $scope.ip;
										impressora.ramal = $scope.ramal;
										impressora.setor = $scope.setor;
										impressora.num_serie = $scope.num_serie;
										impressora.modelo = $scope.modelo;

										window.location.href = "listar";

									} else {

										$window
												.alert("Erro ao Tentar Cadastrar");
									}
								});

						response.error(function(data, status, headers, config) {

							$window.alert("Erro ao Tentar Cadastrar ");

						});
					}

					$scope.alterarImpressora = function() {

						var mensagem = confirm("Deseja Realmente Alterar o Cadastro ??? ");

						if (mensagem == true) {

							var impressora = new Object();
							impressora.id = $scope.id;
							impressora.descricao = $scope.descricao;
							impressora.ip = $scope.ip;
							impressora.ramal = $scope.ramal;
							impressora.setor = $scope.setor;
							impressora.num_serie = $scope.num_serie;
							impressora.modelo = $scope.modelo;

							var response = $http.post("../alterar", impressora);

							response
									.success(function(data, status, headers,
											config) {

										$window
												.alert("Cadastro de Alterado com Sucesso !!!");

										$scope.id = null;
										impressora.descricao = null;
										impressora.ip = null;
										impressora.ramal = null;
										impressora.setor = null;
										impressora.num_serie = null;
										impressora.modelo = null;

										window.location.href = "../listar";

									});

							response.error(function(data, status, headers,
									config) {

								$window.alert("Erro ao Tentar Alterar ");

							});

						}

					}

					$scope.excluir = function(id, modelo) {

						var mensagem = confirm("Deseja Realmente Excluir o Cadastro??? ");

						if (mensagem == true) {

							var response = $http.post("excluir/" + id);

							response
									.success(function(data, status, headers,
											config) {

										$scope.init();

										$window
												.alert("Cadastro de excluido com Sucesso !!!");

									});

							response.error(function(data, status, headers,
									config) {

								$window.alert("Erro ao Tentar Excluir ");

							});
						}

					}

				});
