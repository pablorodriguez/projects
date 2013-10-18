app = angular.module("product",["ngResource"]);

function ProductCtrl($scope,$resource){
	Entry = $resource("/portlet-angular-1.0/products.do");
	
	$scope.products = Entry.query();
	$scope.orderProp = 'name';
	
	
	$scope.addProduct = function(){
		entry = Entry.save($scope.newProduct)
		$scope.products.push(entry);
		$scope.newProduct = {};
	};
	
	
}

