angular.module('pmApp').controller(
		'LoginController',
		[
				'$scope',
				
				'$http',
				function($scope, $http) {

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
					$scope.signInRequest={};
					$scope.userTypes = [ 'Staff', 'Student' ];
					$scope.user.userType = 'Student';
					$scope.colleges = [ 'NECG', 'JNUA' ];

					$scope.signUp = function() {

						$http.post(REST_SERVICE_URI + "/signup", $scope.user)
								.then(
								function successCallback(response) {
									console.log("Successfully POST-ed data");
								}, function errorCallback(response) {
									console.log("POST-ing of data failed");
								});

					}
					
					$scope.signIn = function() {

						$http.post(REST_SERVICE_URI + "/signin", $scope.signInRequest)
								.then(
								function successCallback(response) {
									console.log("Successfully POST-ed data");
								}, function errorCallback(response) {
									console.log("POST-ing of data failed");
								});

					}

				} ]);
