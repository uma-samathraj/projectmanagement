angular.module('pmApp').controller('StaffController', function($scope) {
	
	
	
	$scope.gridOptions = {

			paginationPageSizes: [3, 5, 10],

			paginationPageSize: 3,
			
			enableSorting: true,

			columnDefs: [

			{ field: 'Name' },

			{ field: 'age' },

			{ field: 'status'}

			]

	};
	 
	$scope.users = [

		{ Name: "Madhav Sai", age: 10, status: 'Nagpur' },

		{ Name: "Suresh Dasari", age: 30, status: 'Chennai' },

		{ Name: "Rohini Alavala", age: 29, status: 'Chennai' },

		{ Name: "Praveen Kumar", age: 25, status: 'Bangalore' },

		{ Name: "Sateesh Chandra", age: 27, status: 'Vizag' }

		];

		$scope.gridOptions.data = $scope.users;


		  this.statusChange = function (address) {
		    var param = address.street + ",+" + address.city + ",+" + address.state;
		  };
	
});