var app = angular.module('contractCalculator', []);

app.controller('contractCalculatorController', function ($scope, $http) {

    initialize($scope);

    $scope.calculate = function () {
        $scope.showRequestError = false;
        $scope.showError = false;
        if (!validateInput($scope.selectedCountry, $scope.salary)) {
            $scope.showError = true;
            return;
        }

        $http.get(createURL($scope.selectedCountry, $scope.salary))
            .then(function (response) {
                $scope.monthlyNetSalary = response.data.salary;
                $scope.showResult = true;
            }, function onError(response) {
                $scope.errorMessage = response.statusText;
                console.log(response);
                $scope.showRequestError = true;
            })
    }

});

function initialize($scope) {
    $scope.countries = [{currency: "PLN", country: "Poland"},
        {currency: "EUR", country: "Germany"},
        {currency: "GBP", country: "Great Britain"}];
    $scope.showError = false;
    $scope.showResult = false;
    $scope.showRequestError = false;
}

function createURL(selectedCountry, salary) {
    return "http://localhost:8080/CalculateContract?country=" +
        selectedCountry.country.replace(/ /g, "_") + "&salary=" + salary;
}

function validateInput(selectedCountry, salary) {
    if (typeof selectedCountry === "undefined" || typeof salary === "undefined" || salary === 0) {
        return false;
    }
    return true;
}