app.controller("brand-ctrl", function($scope, $http) {
    $scope.brand_items = [];
    $scope.form = {};
    $scope.check = "";
    //Sự kiện khi bắt đầu chương trình
    $scope.initialize = function() {
        //Load brands
        $http.get("/rest/brands").then(resp => {
            $scope.brand_items = resp.data;
            //$scope.form = {
              //  image: 'cloud-upload.jpg',
          //  }
        }); 
    } 
    $scope.initialize();
    //Void làm mới các field trên page
    $scope.reset = function() {
            $scope.form = {
                Photo: 'cloud-upload.jpg',
                
            }
            $scope.check = "";
        }
        //Void edit thương hiệu
    $scope.edit = function(itemb) {
            $scope.form = angular.copy(itemb);
            $scope.check = itemb.trademark;
        }
        //Void tạo mới thương hiệu
    $scope.create = function() {
            var itemb = angular.copy($scope.form);
            $http.post(`/rest/brands`, itemb).then(resp => {
                $scope.brand_items.push(resp.data);
                alert("Thêm thương hiệu thành công");
                $scope.initialize();
            }).catch(error => {
                alert("Gặp lỗi khi thêm thương hiệu mới!");
                console.log(error);
            });
        }
        //Void cập nhật lại thương hiệu
    $scope.update = function() {
            var itemb = angular.copy($scope.form);
            $http.put(`/rest/brands/${itemb.id}`, itemb).then(resp => {
                var index = $scope.brand_items.findIndex(p => p.id == itemb.id);
                $scope.brand_items[index] = itemb;
                alert("Cập nhật thương hiệu thành công");
                $http.get("/rest/brands").then(resp => {
                    $scope.brand_items = resp.data;
                });
            }).cath(error => {
                alert("Gặp lỗi khi cập nhật thương hiệu");
                console.log(error);
            })
        }
        //Void xóa thương hiệu trên page 
    $scope.delete = function(itemb) {
            $http.delete(`/rest/brands/${itemb.id}`).then(resp => {
                var index = $scope.brand_items.findIndex(p => p.id == itemb.id);
                $scope.brand_items.splice(index, 1);
                $scope.reset();
               alert("Bạn đã xóa thương hiệu thành công");
            }).catch(error => {
              alert("Gặp lỗi khi xóa thương hiệu");
                console.log("Error", error);
            })
        }
        //Upload Photo
   $scope.imageChanged = function(files) {
            var data = new FormData();
            data.append('file', files[0]);
            $http.post('/rest/upload/img', data, {
                transformRequest: angular.identity,
                headers: { 'Content-Type': undefined }
            }).then(resp => {
                $scope.form.photo = resp.data.name;
                alert("Image name will be encrypted: " + $scope.form.photo)
            }).catch(error => {
                alert("Error when you upload image!");
                console.log(error)
            })
        }
        //Các void phân trang
    $scope.pager = {
        page: 0,
        size: 10,
        get brand_items() {
            var start = this.page * this.size;
            return $scope.brand_items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.brand_items.length / this.size)
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
    
    $scope.searchBrand = function(info) {
        //Load products
        $http.get(`/rest/brands/search/${info}`).then(resp => {
            $scope.items = resp.data;
        }).catch(error => {
            $scope.initialize();
        });
    }
    
});