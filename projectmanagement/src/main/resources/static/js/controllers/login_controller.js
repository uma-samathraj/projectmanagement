angular
		.module('pmApp')
		.controller(
				'LoginController',
				[
						'$scope',
						'$http',
						'$location',
						function($scope, $http, $location) {

							var REST_SERVICE_URI = 'http://localhost:8080/pm/user';

							$scope.toggleResetPswd = function() {
								$('#logreg-forms .form-signin').toggle() // display:block
								// or
								$('#logreg-forms .form-reset').toggle() // display:block
								// or none
							}
							$scope.toggleSignUp = function() {
								$('#logreg-forms .form-signin').toggle(); // display:block
								// or
								$('#logreg-forms .form-signup').toggle(); // display:block
								// or
							}
							$scope.back = function() {
								$('#logreg-forms .form-signin').toggle(); // display:block
								// or
								$('#logreg-forms .form-signup').toggle(); // display:block
								// or
							}
							$scope.user = {}
							$scope.signInRequest = {};
							$scope.userTypes = [ 'Staff', 'Student' ];
							$scope.user.userType = 'Student';
							$scope.colleges = [ 'NECG', 'JNUA' ];

							try {
								if (sessionStorage.loggedIn) {

									if (JSON.parse(sessionStorage.user).userType === "Staff") {
										$location.path("/Staff");
									} else {
										$location.path("/student");
									}
								}
							} catch (e) {
								console.log(e);
							}

							$scope.signUp = function() {

								$http
										.post(REST_SERVICE_URI + "/signup",
												$scope.user)
										.then(
												function successCallback(
														response) {
													if (response.data.responseCode===200) {
														console.log(response.data.responseDesc);
													}
												},
												function errorCallback(response) {
													console
															.log("POST-ing of data failed");
												});

							}

							$scope.signIn = function() {

								$http
										.post(REST_SERVICE_URI + "/signin",
												$scope.signInRequest)
										.then(
												function successCallback(
														response) {
													if (response.data.responseCode===200) {
														sessionStorage.user = JSON
																.stringify(response.data.user);
														sessionStorage.loggedIn = true;
														if (response.data.user.userType === "Staff") {
															$location
																	.path("/staff");
														} else {
															$location
																	.path("/student");
														}
														console
																.log("Successfully POST-ed data");
													} else {
														console
																.log(response.data.responseDesc);
													}
												},
												function errorCallback(response) {
													console
															.log("POST-ing of data failed");
												});

							}

						} ]);
