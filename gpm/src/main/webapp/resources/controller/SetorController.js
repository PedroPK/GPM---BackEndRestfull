/**
 * Controlador de Setor AgularJS.
 */

var SetorControllerApp = angular.module("SetorControllerApp", []);

SetorControllerApp
		.controller(
				"SetorController",
				function($scope, $window, $http) {

					$scope.id = null;
					$scope.nome = null;
					$scope.descricao = null;

					$scope.init = function() {
							
							$scope.listar();
					}
					
					/* Listar Setor */
					$scope.listar = function() {

						$scope.setores = new Array();

						var response = $http.get("lista");

						response
								.success(function(data, status, headers, config) {

									$scope.setores = data;

								});

						response
								.error(function(data, status, headers, config) {

									$window
											.alert("Erro ao Tentar Listar Verifique Sua Conexão com o Banco "
													+ data);

								});

					}

					/* Válidar formulário antes de cadastrar */
					$scope.submitForm = function(isValid) {

						if (isValid) {

							$scope.cadastrarSetor();

						} else {

							$window.alert("Preencha Campos Obrigatórios !!! ");
						}

					}

					/* Cadastro de Setor */
					$scope.cadastrarSetor = function() {

						var setor = new Object();
						setor.nome = $scope.nome;
						setor.descricao = $scope.descricao;

						var response = $http.post("cadastrar", setor);

						response
								.success(function(data, status, headers, config) {

									if (data.nome != null) {

										$window.alert("Cadastro de "
												+ data.nome
												+ " Realizado com Sucesso !!!");

										$scope.nome = null;
										$scope.descricao = null;

										window.location.href = "listar";

									} else {

										$window
												.alert("Erro ao Tentar Cadastrar"
														+ data.nome);
									}
								});

						response.error(function(data, status, headers, config) {

							$window.alert("Erro ao Tentar Alterar " + data.nome
									+ data);

						});
					}

					/* Alterar Cadastro de Usuário */
					$scope.alterarSetor = function() {

						var mensagem = confirm("Deseja Realmente Alterar o Cadastro de "
								+ $scope.nome + " ??? ");

						if (mensagem == true) {

							var setor = new Object();
							setor.id = $scope.id;
							setor.nome = $scope.nome;
							setor.descricao = $scope.descricao;

							var response = $http.post("../alterar", setor);

						} else {

							$window.alert("Nenhuma alteração feita !!! ");
							// $scope.nome = null;
							// $scope.descricao = null;

						}

						response
								.success(function(data, status, headers, config) {

									$window.alert("Cadastro de " + data.nome
											+ " Alterado com Sucesso !!!");

									$scope.id = null;
									$scope.nome = null;
									$scope.descricao = null;

									window.location.href = "../listar";

								});

						response.error(function(data, status, headers, config) {

							$window.alert("Erro ao Tentar Alterar " + data.nome
									+ data);

						});

					}

					/* Excluir Cadastro de Setor */
					$scope.excluir = function(id, nome) {

						var mensagem = confirm("Deseja Realmente Excluir o Cadastro de "
								+ nome + " ??? ");

						if (mensagem == true) {

							var response = $http.post("excluir/" + id);

							response.success(function(data, status, headers,
									config) {

								$scope.init();

								$window.alert("Cadastro de " + data.nome
										+ " Excluido com Sucesso !!!");

							});

							response.error(function(data, status, headers,
									config) {

								$window.alert("Erro ao Tentar Excluir "
										+ data.nome + data);

							});
						}

					}

				});
