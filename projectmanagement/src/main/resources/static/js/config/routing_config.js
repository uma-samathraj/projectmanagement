angular.module('pmApp').config([ '$routeProvider',

function($routeProvider) {
	$routeProvider.when('/project', {
		templateUrl : './html/project.html',
		controller : 'ProjectController'
	}).when('/user', {
		templateUrl : './html/user.html',
		controller : 'UserController'
	}).when('/login', {
		templateUrl : './html/login.html',
		controller : 'LoginController'
	}).otherwise({
		redirectTo: '/login'
	})
} ]);