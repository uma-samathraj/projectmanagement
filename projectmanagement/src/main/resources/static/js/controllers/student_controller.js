angular.module('pmApp').controller(
		'StudentController',
		function($scope, $http) {

			var REST_SERVICE_URI = 'http://localhost:8080/pm/project';
			$scope.project = {};
            $scope.user = JSON.parse(sessionStorage.user);
			
            $scope.init=function(){
            	
            	var data = {
            			 id:$scope.user.idNum!=undefined?$scope.user.idNum:123
            			};

            			var config = {
            			 params: data,
            			 headers : {'Accept' : 'application/json'}
            			};

            			$http.get(REST_SERVICE_URI+"/getproject", config).then(function(response) {
            				
            				if(response.data.responseCode===200){
            					var project=response.data.project;
            					if(project!=null){
            						$scope.project =project; 
            						console.log("success");
            					}
            				}
            			 }, function(response) {
            				 
            				 console.log("failure");
            		    	}
            		);
            	
            }
            
			$scope.callInitialSubmission = function() {
				console.log("called callInitialSubmission");
			}

			$scope.submitProject = function() {

				$scope.project.status = "Submitted";
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

		});