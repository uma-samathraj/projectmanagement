angular
		.module('pmApp')
		.controller(
				'StaffController',
				function($scope, $uibModal, $http, uiGridConstants, toastr,$timeout,$location,$route) {

					var REST_SERVICE_URI = 'http://localhost:8080/pm/project/staff';

					
					if(sessionStorage.user!=undefined){
						$scope.user = JSON.parse(sessionStorage.user);
					}
					
					if (sessionStorage.loggedIn && $scope.user != undefined
							&& $scope.user != null) {

						if ($scope.user!=undefined &&($scope.user.userType != "Staff"|| $route.current.$$route.originalPath != '/staff')) {
							$location.path("/student");
						} 
					}
					
					
					
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
							$scope.gridApi = gridApi;
							gridApi.pagination.on
									.paginationChanged(
											$scope,
											function(pageNumber, pageSize) {
												paginationOptions.pageNumber = pageNumber;
												paginationOptions.pageSize = pageSize;
												$scope
														.getProjectByStatus($scope.currentStatus);
											});
						}

					};

					$scope.openModal = function(e, row) {
						// in here, you can access the event object and row
						// object
						var myEvent = e;
						var myRow = row;

						var data = {
							id : row.id,
						};

						var config = {
							params : data,
							headers : {
								'Accept' : 'application/json'
							}
						};

						$http
								.get(REST_SERVICE_URI + "/getproject", config)
								.then(
										function(response) {

											if (response.data.responseCode === 200) {
												var project = response.data.project;
												if (project != null) {
													$scope.project = project;
													$scope.project.staffIdNum=$scope.user.idNum;
													$scope.project.currentStatus = $scope.currentStatus;
													// this is how you open a
													// modal
													var modalInstance = $uibModal
															.open({
																templateUrl : '../../html/project_review.html',
																controller : 'MyModalCtrl',
																size : 'lg',
																backdrop : 'static',
																scope : $scope,
																windowClass : 'my-modal-popup',
																// disable the
																// keyboard
																// keyboard:
																// false,
																resolve : {
																	// pass
																	// variables
																	// to the
																	// MyModalCtrl
																	// here
																	event : function() {
																		return myEvent;
																	},
																	row : function() {
																		return $scope.project;
																	}
																}
															});
													// call the modal to open,
													// then
													// decide what to do with
													// the promise
													modalInstance.result
															.then(
																	function(
																			data) {

																		$scope
																				.saveProject(data);

																	},
																	function() {
																		console
																				.log("cancel");
																	});
												}
											}
										}, function(response) {
											console.log("failure");
										});

					}

					$scope.saveProject = function(data) {

						$http.post(REST_SERVICE_URI + "/save", data).then(
								function successCallback(response) {
									if (response.data.responseCode === 200) {
										toastr.success(
												response.data.responseDesc,
												'Happy :)');
										   $timeout(() => {
									          $scope.gridApi.core.handleWindowResize();
									          $scope.gridApi.grid.refresh();
									       },10);
										$scope.project={};
									} else {
										toastr.error(
												response.data.responseDesc,
												'Sorry');
									}
								},
								function errorCallback(response) {
									toastr.error(response.data.responseDesc,
											'Sorry');
									console.log("project saved successfully");
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
													$scope.gridApi.core.refresh();
													$scope.gridOptions.data = [];
													$scope.gridOptions.data = $scope.projects
															.concat(allProjects);
													 $timeout(() => {
												          $scope.gridApi.core.handleWindowResize();
												          $scope.gridApi.grid.refresh();
												     }, 10);
												}
											}
										}, function(response) {
											console.log("failure");
										});
					}

					$scope.logout=function(){
						sessionStorage.clear();
						$location
						.path("/login");
					}
					
					$scope.getProjectByStatus('Submitted');

				});