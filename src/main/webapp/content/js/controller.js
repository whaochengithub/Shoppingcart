'use strict';

// the storeController contains two objects:
// - store: contains the product list
// - cart: the shopping cart object

function storeController($scope, $http, $routeParams, DataService) {

	$http.get("http://localhost:8080/ShoppingCart/products").success(
			function(response) {
				$scope.ReturnProducts = response;
				$scope.store.products = [];

				for ( var num in $scope.ReturnProducts) {
					var item = $scope.ReturnProducts[num];
					var sku = item.sku;

					var name = item.name;

					var description = item.description;

					var price = item.price;

					var cal = item.cal;

					var product = new Product(sku, name, description, price,
							cal, RandomNum(), RandomNum(), RandomNum(),
							RandomNum(), RandomNum());
					DataService.store.products.push(product);
				}

			});
	//$scope.store = DataService.store;
	$scope.store = DataService.store;
	$scope.cart = DataService.cart;

	// use routing to pick the selected product
	if ($routeParams.productSku != null) {
		$scope.product = $scope.store.getProduct($routeParams.productSku);
	}
}

function productController($scope, $routeParams, $http, DataService) {

	$scope.cart = DataService.cart;
	if ($routeParams.productSku != null) {
		var sku = $routeParams.productSku;
		$http.get("http://localhost:8080/ShoppingCart/productBySku", {
			params : {
				sku : sku
			}
		}).success(
				function(response) {
					$scope.ReturnProduct = response;
					var sku = $scope.ReturnProduct.sku;

					var name = $scope.ReturnProduct.name;

					var description = $scope.ReturnProduct.description;

					var price = $scope.ReturnProduct.price;

					var cal = $scope.ReturnProduct.cal;

					var GetProduct = new Product(sku, name, description, price,
							cal, RandomNum(), RandomNum(), RandomNum(),
							RandomNum(), RandomNum());

					$scope.product = GetProduct;
				});

	}
}


function LoginController($http, $scope, page) {
	var vm = this;
	vm.login = login;
	var username = vm.username;
	var password = vm.password;
	
	$scope.user = {};
	$scope.user.username = username;
	$scope.user.password = password;
	function login(){
		console.log($location.path());
		if(username=="admin" && password == "admin123"){
			page.setUser($scope.user);
			$location.path("/");
		}else{
			$scope.message="Error";
		}
	}
	
}


function HomeController($http, page, $scope){
	
}

function RegisterController(UserService, $location, $rootScope, FlashService) {
	var vm = this;

	vm.register = register;

	function register() {
		vm.dataLoading = true;
		UserService.Create(vm.user).then(function(response) {
			if (response.success) {
				FlashService.Success('Registration successful', true);
				$location.path('/login');
			} else {
				FlashService.Error(response.message);
				vm.dataLoading = false;
			}
		});
	}
}

LoginController.$inject = [ '$location', 'AuthenticationService',
		'FlashService' ]
function LoginController($location, AuthenticationService, FlashService) {
	var vm = this;

	vm.login = login;

	(function initController() {
		// reset login status
		AuthenticationService.ClearCredentials();
	})();

	function login() {
		vm.dataLoading = true;
		AuthenticationService.Login(vm.username, vm.password,
				function(response) {
					if (response.success) {
						AuthenticationService.SetCredentials(vm.username,
								vm.password);
						$location.path('/');
					} else {
						FlashService.Error(response.message);
						vm.dataLoading = false;
					}
				});
	}
	;
}

function RandomNum() {
	var Range = 4 - 0;
	var Rand = Math.random();
	var num = 0 + Math.round(Rand * Range);
	return num;
}
