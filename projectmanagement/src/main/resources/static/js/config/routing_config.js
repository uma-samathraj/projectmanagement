angular.module('pmApp').config([ '$routeProvider',

function($routeProvider) {
	$routeProvider.when('/student', {
		templateUrl : './html/student.html',
		controller : 'StudentController'
	}).when('/user', {
		templateUrl : './html/user.html',
		controller : 'UserController'
	}).when('/staff', {
		templateUrl : './html/staff.html',
		controller : 'StaffController'
	}).when('/login', {
		templateUrl : './html/login.html',
		controller : 'LoginController'
	}).otherwise({
		redirectTo : '/login'
	})
} ]);