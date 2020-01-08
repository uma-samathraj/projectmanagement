angular.module('pmApp').config([ '$routeProvider',

function($routeProvider) {
	$routeProvider.when('/project', {
		templateUrl : './html/project.html',
		controller : 'ProjectController'
	}).when('/user', {
		templateUrl : './html/user.html',
		controller : 'UserController'
	}).otherwise({
		redirectTo: '/project'
	})
} ]);