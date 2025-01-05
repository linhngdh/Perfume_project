app = angular.module("admin-app", ["ngRoute"]);

app.config(function($routeProvider) {
	$routeProvider
		.when("/product", {
			templateUrl: "/assets/admin/product/index.html",
			controller: "product-ctrl"
		}).when("/authorize", {
			templateUrl: "/assets/admin/authority/index.html",
			controller: "authority-ctrl"
		}).when("/unauthorized", {
			templateUrl: "/assets/admin/authority/unauthorized.html",
			controller: "authority-ctrl"
		}).when("/account", {
			templateUrl: "/assets/admin/account/index.html",
			controller: "account-ctrl"
		}).when("/brand", {
			templateUrl: "/assets/admin/brand/index.html",
			controller: "brand-ctrl"
		}).when("/category", {
			templateUrl: "/assets/admin/category/index.html",
			controller: "category-ctrl"
		}).when("/order", {
			templateUrl: "/assets/admin/order/index.html",
			controller: "order-ctrl"
		})
		.otherwise({
			templateUrl: "/doanhthu",
		})
});