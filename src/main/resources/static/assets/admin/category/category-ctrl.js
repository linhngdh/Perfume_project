app.controller("category-ctrl", function($scope, $http) {
    $scope.categories_items = [];
    $scope.form = {};
    $scope.check = "";
    //Sự kiện khi bắt đầu chương trình
    $scope.initialize = function() {
        //Load brands
        $http.get("/rest/categories").then(resp => {
            $scope.categories_items = resp.data;
        }); 
    } 
    $scope.initialize();
    //Void làm mới các field trên page
    $scope.reset = function() {
		$scope.form = {
            }
            $scope.check = "";
        }
        //Void edit danh mục
    $scope.edit = function(itemb) {
            $scope.form = angular.copy(itemb);
            $scope.check = itemb.trademark;
        }
        //Void tạo mới danh mục
    $scope.create = function() {
            var itemb = angular.copy($scope.form);
            $http.post(`/rest/categories`, itemb).then(resp => {
                $scope.categories_items.push(resp.data);
                alert("Thêm danh mục thành công");
                $scope.initialize();
            }).catch(error => {
                alert("Gặp lỗi khi thêm danh mục mới!");
                console.log(error);
            });
        }
        //Void cập nhật lại danh mục
    $scope.update = function() {
            var itemb = angular.copy($scope.form);
            $http.put(`/rest/categories/${itemb.id}`, itemb).then(resp => {
                var index = $scope.categories_items.findIndex(p => p.id == itemb.id);
                $scope.categories_items[index] = itemb;
                alert("Cập nhật danh mục thành công");
                $http.get("/rest/categories").then(resp => {
                    $scope.categories_items = resp.data;
                });
            }).cath(error => {
                alert("Gặp lỗi khi cập nhật danh mục");
                console.log(error);
            })
        }
        //Void xóa danh mục trên page 
    $scope.delete = function(itemb) {
            $http.delete(`/rest/categories/${itemb.id}`).then(resp => {
                var index = $scope.categories_items.findIndex(p => p.id == itemb.id);
                $scope.categories_items.splice(index, 1);
                $scope.reset();
               alert("Bạn đã xóa danh mục thành công");
            }).catch(error => {
              alert("Gặp lỗi khi xóa danh mục");
                console.log("Error", error);
            })
        }
        
        //Các void phân trang
    $scope.pager = {
        page: 0,
        size: 10,
        get categories_items() {
            var start = this.page * this.size;
            return $scope.categories_items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.categories_items.length / this.size)
        },
        first() {
            this.page = 0;
        },
        prev() {
            this.page--;
            if (this.page < 0) {
                this.last();
            }
        },
        next() {
            this.page++;
            if (this.page >= this.count) {
                this.first();
            }
        },
        last() {
            this.page = this.count - 1;
        }
    }
    
});