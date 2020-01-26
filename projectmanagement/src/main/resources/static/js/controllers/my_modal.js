/**
 * MyModalCtrl
 */

angular.module('pmApp').controller('MyModalCtrl',
		function($scope, $uibModalInstance, row) {

			$scope.project = row;

			console.log($scope.project);

			$scope.ok = function() {
				// {...}
				$scope.project.result = 'Pass';
				$uibModalInstance.close($scope.project);
			};

			$scope.cancel = function() {
				$uibModalInstance.dismiss($scope.project);
			};

		});