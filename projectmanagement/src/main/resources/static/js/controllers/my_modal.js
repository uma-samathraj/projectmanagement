/**
 * MyModalCtrl
 */

angular
		.module('pmApp')
		.controller(
				'MyModalCtrl',
				function($scope, $uibModalInstance, row, toastr) {

					$scope.project = row;

					$scope.updateToStudent = function() {

						if ($scope.currentStatus === 'Submitted') {

							if ($scope.project.staffComments1 === undefined
									|| $scope.project.staffComments1 === null
									|| $scope.project.staffComments1 === "") {
								toastr.error(
										"Please Enter your Review-1 comments",
										'Error');
								return;
							} else if ($scope.project.status === undefined
									|| $scope.project.status === null
									|| $scope.project.status === "" || $scope.project.status == 'Submitted') {
								toastr
										.error(
												"Is Project Approved/Rejected",
												'Error');
								return;
							}
						} else if ($scope.currentStatus === 'FinalSubmission') {

							if ($scope.project.staffComments2 === undefined
									|| $scope.project.staffComments2 === null
									|| $scope.project.staffComments2 === "") {
								toastr.error(
										"Please Enter your Review-2 Comments",
										'Error');
								return;
							} else if ($scope.project.status === undefined
									|| $scope.project.status === null
									|| $scope.project.status === "" || $scope.project.status == 'FinalSubmission') {
								toastr
										.error(
												"Is Project Completed/Rejected",
												'Error');
								return;
							}else if ((($scope.project.status === 'Completed') && ($scope.project.studentMarks === undefined
									|| $scope.project.studentMarks === null || $scope.project.studentMarks === ""))) {
								toastr.error("Please enter the student marks",
										'Error');
								return;
							} else if ((($scope.project.status === 'Completed') && ($scope.project.result === undefined
									|| $scope.project.result === null || $scope.project.result === ""))) {
								toastr.error("Is Your Student Pass/Fail",
										'Error');
								return;
							}
						}
						$uibModalInstance.close($scope.project);
					};

					$scope.cancel = function() {
						$uibModalInstance.dismiss($scope.project);
					};

				});