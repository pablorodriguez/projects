var myApp = angular.module("myApp",[]);
myApp.factory("Data",function(){
	return {message: "Hola TWG Services"};
});

myApp.filter("camelCase",function(Data){
	return function(text){
		var message = text.split(" ");
		$.each(message,function(index){
			message[index] = message[index].charAt(0).toUpperCase() + message[index].slice(1);
		});
		return Data.message + " => " + message.join("");
	};
});

angular.bootstrap($('#myApp'),['myApp']);

function FirstCtrl($scope,Data){
	$scope.data = Data;

	$scope.toCamelCase = function(message){		
		message = message.split(" ");
		$.each(message,function(index){
			message[index] = message[index].charAt(0).toUpperCase() + message[index].slice(1);
		});
		return message.join("");
	}
};

var myPrd = angular.module("myProducts",["ngResource"]);

myPrd.factory("Products",function(){
	
	var Products = [
			{
				name: "TV Small",
				brand: "LG",
				price: 2229.78
			},
			{
				name: "TV 32",
				brand: "Sony",
				price: 254.00
			},
			{
				name: "TV Smart 32",
				brand: "Samsung",
				price: 500.00
			},
			{
				name: "TV 42 LED",
				brand: "Samsung",
				price: 654.00
			},
			{
				name: "TV Real",
				brand: "LG",
				price: 234.00
			},
			{
				name: 'Table A500"',
				brand: "Acer",
				price: 2500.00
			},
			{
				name: "Table XOOM",
				brand: "Motorola",
				price: 2800.00
			},
			{
				name: "iPad",
				brand: "Apple",
				price: 3100.00
			},
			{
				name: "iPhone",
				brand: "Apple",
				price: 2500.00
			},
			{
				name: "Galaxy SIII",
				brand: "Samsung",
				price: 3800.00
			},
			{
				name: "Lumia 710",
				brand: "Nokia",
				price: 2000.00
			},
			{
				name: "Asha 340",
				brand: "Nokia",
				price: 2100.00
			},
			{
				name: "Asha 340",
				brand: "Nokia",
				price: 2100.00
			},
			{
				name: "AT Glance",
				brand: "LG",
				price: 2500.00
			},
			{
				name: "Optimous",
				brand: "LG",
				price: 1500.00				
			}

	];

	return Products;
});
angular.bootstrap($('#myProductsApp'),['myProducts']);

function ProductCtrl($scope,$resource,Products){	
	$scope.products = Products;
	$scope.nroRecords =100;
	$scope.orderProp="name";
};