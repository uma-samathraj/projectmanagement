angular
		.module('pmApp')
		.controller(
				'StaffController',
				function($scope, $uibModal, $http, uiGridConstants) {

					var REST_SERVICE_URI = 'http://localhost:8080/pm/project/staff';

					$scope.user = JSON.parse(sessionStorage.user);
					$scope.currentStatus = "Submitted";

					var paginationOptions = {
						pageNumber : 1,
						pageSize : 10,
						sort : null
					};

					$scope.gridOptions = {

						paginationPageSizes : [ 10, 20, 50 ],
						paginationPageSize : 10,
						useExternalPagination : true,
						enableSorting : false,
						enableFiltering : false,
						enableHiding : true,

						columnDefs : [

								{
									name : 'studentName',
								},

								{
									name : 'projectName',

								},

								{
									name : 'status'
								},

								{
									name : 'Details',
									cellTemplate : '<button class="btn primary" ng-click="grid.appScope.openModal($event, row.entity)">Details</button>'
								}

						],

						onRegisterApi : function(gridApi) {
							gridApi.pagination.on
									.paginationChanged(
											$scope,
											function(pageNumber, pageSize) {
												paginationOptions.pageNumber = pageNumber;
												paginationOptions.pageSize = pageSize;
												$scope.getProjectByStatus($scope.currentStatus);
											});
						}

					};

					$scope.openModal = function(e, row) {
						// in here, you can access the event object and row
						// object
						var myEvent = e;
						var myRow = row;
						
						var data = {
								id:row.id,
							};

							var config = {
								params : data,
								headers : {
									'Accept' : 'application/json'
								}
							};
						
						$http.get(REST_SERVICE_URI + "/getproject", config).then(
								function(response) {

									if (response.data.responseCode === 200) {
										var project = response.data.project;
										if (project != null) {
											$scope.project = project;
											$scope.project.currentStatus = $scope.currentStatus;
											// this is how you open a modal
											var modalInstance = $uibModal.open({
												templateUrl : '../../html/project_review.html',
												controller : 'MyModalCtrl',
												size: 'lg',
												backdrop : 'static',
												scope : $scope,
												windowClass: 'my-modal-popup',
												// disable the keyboard
												// keyboard: false,
												resolve : {
													// pass variables to the MyModalCtrl here
													event : function() {
														return myEvent;
													},
													row : function() {
														return $scope.project;
													}
												}
											});
											// call the modal to open, then decide what to do with
											// the promise
											modalInstance.result.then(function(data) {
												console.log("ok" + $scope.project.result);
											}, function() {
												console.log("cancel");
											});
										}
									}
								}, function(response) {
									console.log("failure");
								});

					}

					$scope.getProjectByStatus = function(status) {
						$scope.currentStatus = status;
						var data = {
							collegeName : $scope.user.collegeName,
							status : status,
							firstResult : paginationOptions.pageNumber,
							maxResults : paginationOptions.pageSize
						};

						var config = {
							params : data,
							headers : {
								'Accept' : 'application/json'
							}
						};

						$http
								.get(REST_SERVICE_URI + "/getprojectbystatus",
										config)
								.then(
										function(response) {

											if (response.data.responseCode === 200) {
												var allProjects = response.data.allProjects;
												$scope.projects = [];
												if (allProjects != null) {
													$scope.gridOptions.data = $scope.projects
															.concat(allProjects);
												}
											}
										}, function(response) {
											console.log("failure");
										});
					}

					$scope.getProjectByStatus('Submitted');

				});