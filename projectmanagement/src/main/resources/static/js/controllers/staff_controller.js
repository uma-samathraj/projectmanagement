angular
		.module('pmApp')
		.controller(
				'StaffController',
				function($scope,$uibModal) {

					$scope.gridOptions = {

						paginationPageSizes : [ 10, 20, 30 ],

						paginationPageSize : 10,

						enableSorting : true,

						columnDefs : [

								{
									field : 'StudentName'
								},

								{
									field : 'ProjectName'
								},

								{
									field : 'Status'
								},

								{
									name : 'Details',
									cellTemplate : '<button class="btn primary" ng-click="grid.appScope.$parent.myFunction()">Details</button>'
								}

						]

					};
					

					$scope.users = [

					{
						StudentName : "Madhav Sai",
						ProjectName : "asd",
						status : 'Nagpur'
					},

					{
						Name : "Suresh Dasari",
						ProjectName : "asd",
						status : 'Chennai'
					},

					];
					
					
					
					
					$scope.gridOptions.data = $scope.users;


				});