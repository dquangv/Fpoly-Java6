var app = angular.module("myApp", []);

var api = "http://localhost:8080/students";

app.controller("myCtrl", function ($scope, $http) {
  $scope.majors = [
    "Cong nghe thong tin",
    "Khoa hoc may tinh",
    "Toan hoc",
    "Vat ly",
    "Hoa hoc",
    "Sinh hoc",
  ];
  $scope.students = [];
  $scope.isEditing = false;
  $scope.selectedStudent = {};
  $scope.searchStudents = [];
  $scope.getAllData = function () {
    $http.get(api).then(function (response) {
      try {
        $scope.students = response.data.data;
        console.log("Products fetched successfully");
      } catch (error) {
        console.log(error);
      }
    });
  };
  $scope.getDataById = function (id) {
    console.log("id: " + id);
    $http
      .get(api + "/" + id)
      .then(function (response) {
        $scope.selectedStudent = response.data.data;
        console.log($scope.selectedStudent);
        $scope.isEditing = true;
        console.log("Product fetched successfully");
      })
      .catch(function (error) {
        console.log(error);
        console.log(error.response.status);
      });
  };
  $scope.saveStudent = function () {
    if ($scope.isEditing) {
      $scope.updateProduct();
    } else {
      $scope.addProduct();
    }
  };

  // Hàm xử lý cập nhật sản phẩm
  $scope.updateProduct = function () {
    $http.put(api, $scope.selectedStudent).then(function (response) {
      try {
        $scope.students = response.data.data;
        $scope.isEditing = false;
        $scope.selectedStudent = {};
        $scope.getAllData();
        console.log("Product updated successfully");
      } catch (error) {
        console.log(error);
      }
    });
  };

  // Hàm xử lý thêm sản phẩm mới
  $scope.addProduct = function () {
    $http.post(api, $scope.selectedStudent).then(function (response) {
      try {
        $scope.students.push(response.data.data);
        $scope.selectedStudent = {};
        console.log("Product added successfully");
      } catch (error) {
        console.log(error);
      }
    });
  };

  $scope.deleteStudent = function (id) {
    $http.delete(api + "/" + id).then(function (response) {
      try {
        $scope.getAllData();
        console.log("Product deleted successfully", response.data.data);
      } catch (error) {
        console.log(error);
      }
    });
  };

  $scope.resetForm = function () {
    $scope.isEditing = false;
    $scope.selectedStudent = {};
  };
  $scope.filterProducts = function (searchText) {
    $scope.filteredProducts = $filter("filter")($scope.students, searchText);
  };

  // Mỗi khi searchText thay đổi, gọi filterProducts
  $scope.$watch("searchText", function (newVal) {
    $scope.filterProducts(newVal);
  });

  $scope.getAllData();
});
