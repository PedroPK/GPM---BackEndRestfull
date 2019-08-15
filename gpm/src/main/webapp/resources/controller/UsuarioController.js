/**
 * Controlador de Usuário AgularJS.
 */

var UsuarioControllerApp = angular.module("UsuarioControllerApp", []);

UsuarioControllerApp
		.controller(
				"UsuarioController",
				function($scope, $window, $http) {

					$scope.id = null;
					$scope.nome = null;
					$scope.login = null;
					$scope.senha = null;
					$scope.rsenha = null;
					$scope.telefone = null;

					$scope.init = function(nome) {

						if (nome == null) {

							$scope.listar();

						} else {

							$scope.buscar();

						}

					}

					/* Listar Usuário */
					$scope.listar = function() {

						$scope.usuarios = new Array();

						var response = $http.get("lista");

						response
								.success(function(data, status, headers, config) {

									$scope.usuarios = data;

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

					/* Buscar Usuário */
					$scope.buscar = function(nome) {

						$scope.usuarios = new Array();

						var response = $http.post("buscar/" + nome);

						response
								.success(function(data, status, headers, config) {

									$scope.usuarios = data;

								});

					}

					/* Válidar formulário antes de cadastrar */
					$scope.submitForm = function(isValid) {

						if (isValid) {

							$scope.cadastrarUsuario();

						} else {

							$window.alert("Preencha Campos Obrigatórios !!! ");
						}

					}

					/* Cadastro de Usuário */
					$scope.cadastrarUsuario = function() {

						if ($scope.senha == $scope.rsenha) {

							var usuario = new Object();
							usuario.nome = $scope.nome;
							usuario.email = $scope.email;
							usuario.senha = $scope.senha;
							usuario.telefone = $scope.telefone;
							usuario.perfil = $scope.perfil;

							var response = $http.post("cadastrar", usuario);

						} else {

							$window.alert("Senhas não Conferem !!! ");
							$scope.senha = null;
							$scope.rsenha = null;
						}

						response
								.success(function(data, status, headers, config) {

									if (data.nome != null) {

										$window.alert("Cadastro de "
												+ data.nome
												+ " Realizado com Sucesso !!!");

										$scope.nome = null;
										$scope.email = null;
										$scope.senha = null;
										$scope.rsenha = null;
										$scope.telefone = null;

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
					$scope.alterarUsuario = function() {

						var mensagem = confirm("Deseja Realmente Alterar o Cadastro de "
								+ $scope.nome + " ??? ");

						if (mensagem == true) {

							if ($scope.senha == $scope.rsenha) {

								var usuario = new Object();
								usuario.id = $scope.id;
								usuario.nome = $scope.nome;
								usuario.email = $scope.email;
								usuario.senha = $scope.senha;
								usuario.telefone = $scope.telefone;
								usuario.perfil = $scope.perfil;

								var response = $http
										.post("../alterar", usuario);

							} else {

								$window.alert("Senhas não Conferem !!! ");
								$scope.senha = null;
								$scope.rsenha = null;

							}

							response.success(function(data, status, headers,
									config) {

								$window.alert("Cadastro de " + data.nome
										+ " Alterado com Sucesso !!!");

								$scope.id = null;
								$scope.nome = null;
								$scope.login = null;
								$scope.senha = null;
								$scope.telefone = null;

								window.location.href = "../listar";

							});

							response.error(function(data, status, headers,
									config) {

								$window.alert("Erro ao Tentar Alterar "
										+ data.nome + data);

							});

						}

					}

					/* Excluir Cadastro de Usuário */
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
