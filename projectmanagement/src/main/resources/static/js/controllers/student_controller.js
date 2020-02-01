angular
		.module('pmApp')
		.controller(
				'StudentController',
				function($scope, $http, toastr,$location,$route) {

					var REST_SERVICE_URI = 'http://localhost:8080/pm/student/project';
					$scope.project = {};
					
					if(sessionStorage.user!=undefined){
						$scope.user = JSON.parse(sessionStorage.user);
					}
					
					if (sessionStorage.loggedIn && $scope.user != undefined
							&& $scope.user != null) {

						if ($scope.user!=undefined && ($scope.user.userType != "Student"|| $route.current.$$route.originalPath != '/student')) {
							$location.path("/staff");
						} 
					}
					
					$scope.getProject=function(){
						
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

						if (status === 'FinalSubmission') {

							if (($scope.project.status ===undefined || $scope.project.status === null) || $scope.project.status === 'Submitted') {

								toastr
										.error(
												"Kindly Contact Your staff for Approving your project",
												'Required :)');

								return;
							}else if($scope.project.projectUrl === undefined || $scope.project.projectUrl === null || $scope.project.projectUrl === ""){
								
								toastr
								.error(
										"Project Url is required",
										'Required :)');

						return;
								
							}else if($scope.project.domainUrl ===undefined || $scope.project.domainUrl === null || $scope.project.domainUrl === ""){
								
								toastr
								.error(
										"Code Url is required",
										'Required :)');

						return;
								
								
							}

						} else if (status === 'Submitted') {

							if ($scope.project.projectName === undefined
									|| $scope.project.projectName === null
									|| $scope.project.projectName === "") {

								toastr.error("Please enter Your project name ",
										'Required :)');
								return;
							} else if ($scope.project.description === undefined
									|| $scope.project.description === null
									|| $scope.project.description === "") {

								toastr
										.error(
												"Please enter Your project description ",
												'Required :)');
								return;
							}

						}
						$scope.project.status = status;
						$scope.project.studentIdNum = $scope.user.idNum;
						$scope.project.studentName = $scope.user.name;
						$scope.project.collegeName = $scope.user.collegeName;

						$http.post(REST_SERVICE_URI + "/save", $scope.project)
								.then(
										function successCallback(response) {
											toastr.success(
													response.data.responseDesc,
													'Happy :)');
											$scope.project={};
										},
										function errorCallback(response) {
											toastr.error(
													response.data.responseDesc,
													'Sorry');
										});
					}

					$scope.getProjectInfo = function(config) {

						$http.get(REST_SERVICE_URI + "/getproject", config)
								.then(function(response) {

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

					$scope.viewProjectMarks = function() {

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
					
					$scope.logout=function(){
						sessionStorage.clear();
						$location
						.path("/login");
					}

					$scope.init();

				});