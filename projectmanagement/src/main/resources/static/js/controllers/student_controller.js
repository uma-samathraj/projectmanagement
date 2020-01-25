angular.module('pmApp').controller(
		'StudentController',
		function($scope, $http) {

			var REST_SERVICE_URI = 'http://localhost:8080/pm/student/project';
			$scope.project = {};
			$scope.user = JSON.parse(sessionStorage.user);

			$scope.init = function() {

				var data = {
					id : $scope.user.idNum
				};

				var config = {
					params : data,
					headers : {
						'Accept' : 'application/json'
					}
				};

				$scope.getProjectInfo(config);
			}

			$scope.submitProject = function(status) {

				$scope.project.status = status;
				$scope.project.studentIdNum = $scope.user.idNum;
				$scope.project.studentName = $scope.user.name;
				$scope.project.collegeName = $scope.user.collegeName;
				
				$http.post(REST_SERVICE_URI + "/save", $scope.project).then(
						function successCallback(response) {
							console.log("Successfully POST-ed data");
						}, function errorCallback(response) {
							console.log("POST-ing of data failed");
						});
			}

			$scope.init();

			$scope.getProjectInfo=function(config){
				
				$http.get(REST_SERVICE_URI + "/getproject", config).then(
						function(response) {

							if (response.data.responseCode === 200) {
								var project = response.data.project;
								if (project != null) {
									$scope.project = project;
									console.log("success");
								}
							}
						}, function(response) {

							console.log("failure");
						});

			}
			
			
			$scope.viewProjectMarks=function(){
				
				var data = {
						id : $scope.user.idNum
					};

					var config = {
						params : data,
						headers : {
							'Accept' : 'application/json'
						}
					};
				
				$scope.getProjectInfo();
				
			}
			
			
		});