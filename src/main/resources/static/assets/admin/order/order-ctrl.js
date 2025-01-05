app.controller("order-ctrl", function($scope, $http, $location) {
    $scope.items = [];
    $scope.orderDetails = [];
    $scope.o = [];
    $scope.user = [];
    $scope.brand_items = [];
    $scope.form = {};
    $scope.check = "";
    //Sự kiện khi bắt đầu chương trình
    $scope.initialize = function() {
        //Load products
        $http.get("/rest/orders").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            });
            $scope.form = {
                createDate: new Date(),
                image: 'cloud-upload.jpg',
                available: true,
            }
        });
        //Load category
        $http.get("/rest/accounts").then(resp => {
            $scope.user = resp.data;
        });
       
    }
    $scope.initialize();
    //Void làm mới các field trên page
    $scope.reset = function() {
            $scope.form = {
                createDate: new Date(),
                image: 'cloud-upload.jpg',
                available: true,
            }
            $scope.check = "";
        }
        //Void edit sản phẩm
    $scope.edit = function(item) {
            $scope.form = angular.copy(item);
            $scope.check = item.username;
           
            
            // Gọi REST API để lấy thông tin chi tiết hóa đơn
        $http.get(`/rest/order-details/${item.id}`)
            .then(resp => {
                // Truyền thông tin chi tiết hóa đơn từ REST API vào $scope để sử dụng trong HTML
                $scope.orderDetails = resp.data.orderDetails;
            })
            .catch(error => {
                console.log("Error loading order detail", error);
            });
            
        }
        //Void tạo mới sản phẩm
    $scope.create = function() {
            var item = angular.copy($scope.form);
            $http.post(`/rest/products`, item).then(resp => {
                resp.data.createDate = new Date(resp.data.createDate);
                $scope.items.push(resp.data);
                alert("Thêm sản phẩm thành công");
                $scope.initialize();
            }).catch(error => {
                alert("Gặp lỗi khi thêm sản phẩm mới!");
                console.log(error);
            });
        }
        //Void cập nhật lại sản phẩm
    $scope.update = function(item) {
            
            $http.put(`/rest/orders/${item.id}`, item).then(resp => {
                var index = $scope.items.findIndex(p => p.id == item.id);
                $scope.items[index] = item;
                $scope.reset();
                alert("Cập nhật sản phẩm thành công");
                $http.get("/rest/orders").then(resp => {
                    $scope.items = resp.data;
                });
            }).cath(error => {
                alert("Gặp lỗi khi cập nhật sản phẩm");
                console.log(error);
            })
        }
        //Void xóa sản phẩm trên page 
    $scope.delete = function(item) {
            $http.delete(`/rest/products/${item.product_id}`).then(resp => {
                var index = $scope.items.findIndex(p => p.product_id == item.product_id);
                $scope.items.splice(index, 1);
                $scope.reset();
                alert("Bạn đã xóa sản phẩm thành công");
            }).catch(error => {
                alert("Gặp lỗi khi xóa sản phẩm");
                console.log("Error", error);
            })
        }
        //Upload image
    $scope.imageChanged = function(files) {
            var data = new FormData();
            data.append('file', files[0]);
            $http.post('/rest/upload/images', data, {
                transformRequest: angular.identity,
                headers: { 'Content-Type': undefined }
            }).then(resp => {
                $scope.form.image = resp.data.name;
                alert("Image name will be encrypted: " + $scope.form.image)
            }).catch(error => {
                alert("Error when you upload image!");
                console.log(error)
            })
        }
        //Các void phân trang
    $scope.pager = {
        page: 0,
        size: 10,
        get items() {
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size)
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
    $scope.searchProduct = function(info) {
        //Load products
        $http.get(`/rest/products/search/${info}`).then(resp => {
            $scope.items = resp.data;
        }).catch(error => {
            $scope.initialize();
        });
    }
 
});
