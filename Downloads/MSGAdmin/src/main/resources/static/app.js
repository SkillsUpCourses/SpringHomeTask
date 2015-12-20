//Define an angular module for our app
var sampleApp = angular.module('sampleApp', []);
 
//Define Routing for app
//Uri /AddNewOrder -> template add_order.html and Controller AddOrderController
//Uri /ShowOrders -> template show_orders.html and Controller AddOrderController
sampleApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
       when('/', {
        templateUrl: 'main.html',
        controller: 'MainController'
    }).
      when('/newbus', {
        templateUrl: 'newbus.html',
        controller: 'AddBusController'
    }).
      when('/newerror', {
        templateUrl: 'orders.html',
        controller: 'NewErrorController'
      })
      .
      when('/newlocale', {
        templateUrl: 'orders2.html',
        controller: 'NewLocaleController'
      });
}]);
 
 
 sampleApp.controller('MainController', function($scope) {
     
    $scope.message = 'This is Add new order screen';
     
});
 
sampleApp.controller('AddBusController', function($scope) {
     
    $scope.message = 'This is Add new order screen';
     
});
 
 
sampleApp.controller('NewErrorController', function($scope) {
 
    $scope.message = 'This is Show orders screen';
 
});

sampleApp.controller('NewLocaleController', function($scope) {
 
    $scope.message = 'This is Show orders screen';
 
});