/**
 * MyModalCtrl
 */

angular
		.module('pmApp')
		.controller(
				'MyModalCtrl',
				function($scope,$uibModalInstance,row) {
					
					$scope.project = row;
					
					console.log($scope.project);
					
					$scope.ok = function () {
					    //{...}
					    alert("You clicked the ok button."); 
					    $scope.project.result ='Pass';
					    $uibModalInstance.close($scope.project);
					  };

					  $scope.cancel = function () {
					    //{...}
					    alert("You clicked the cancel button."); 
					    $uibModalInstance.dismiss('cancel');
					  };
					
					
					
	});