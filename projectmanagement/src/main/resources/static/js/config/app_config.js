angular.module('pmApp').config(function($locationProvider) {
	 $locationProvider.hashPrefix('');
    $locationProvider.html5Mode(false);
});