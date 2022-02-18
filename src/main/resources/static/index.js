angular.module('app', []).controller('indexController', function ($scope, $http) {
    $scope.loadProducts = function () {
        $http.get('http://localhost:8189/winter/api/v1/products').then(function (response) {
            $scope.productsList = response.data;
        });
    }

    $scope.showProductInfo = function (productId) {
        $http.get('http://localhost:8189/winter/api/v1/products/' + productId).then(function (response) {
            alert(response.data.title);
        });
    }

    $scope.deleteProductById = function (productId) {
        $http.delete('http://localhost:8189/winter/api/v1/products/' + productId).then(function (response) {
            $scope.loadProducts();
        });
    }


    $scope.addToCart = function (productId){
        $http.get('http://localhost:8189/winter/api/v1/cart/additem/'+ productId).then(function(response){
            $scope.cartProducts = response.data;
        });
    }

    $scope.loadCartProducts = function (){
        $http.get('http://localhost:8189/winter/api/v1/cart').then(function (response){
            $scope.cartProducts = response.data;
        });
    }

    $scope.deleteFromCart = function (productId){
        $http.delete('http://localhost:8189/winter/api/v1/cart/deleteitem/'+ productId).then(function (response) {
            $scope.loadCartProducts();
        });
    }

    $scope.loadProducts();

    $scope.loadCartProducts();
});