app.controller("account-ctrl", function($scope, $http) {
    $scope.items = [];
    $scope.form = {};
    $scope.usernameEdit = "";

    $scope.initialize = function() {
        //Load accounts
        $http.get("/rest/accounts/create").then(resp => {
            $scope.items = resp.data;
        }).catch(error => {
            $location.path("/unauthorized");
            console.log(error)
        });
        $scope.form = {
            photo: 'cloud-upload.jpg'
        }

    }
    $scope.initialize();
    //Void làm mới các field trên page
    $scope.reset = function() {
            $scope.form = {
                photo: 'cloud-upload.jpg'
            }
            $scope.usernameEdit = "";
        }
        //Void edit sản phẩm
    $scope.edit = function(item) {
            $scope.form = angular.copy(item);
            $scope.usernameEdit = $scope.form.username;
        }
        //Void tạo mới sản phẩm
    $scope.create = function() {
            var item = angular.copy($scope.form);
            $http.post(`/rest/accounts`, item).then(resp => {
                $scope.items.push(resp.data);
                $scope.reset();
                alert("Add new account successfully!")
            }).catch(error => {
                alert("Have an error when you add new account!");
                console.log(error);
            });
        }
        //Void cập nhật lại sản phẩm
    $scope.update = function() {
            var item = angular.copy($scope.form);
            item.username = $scope.usernameEdit;
            $http.put(`/rest/accounts/${item.username}`, item).then(resp => {
                var index = $scope.items.findIndex(p => p.username == item.username);
                $scope.items[index] = item;
                alert("Update account successfully!");
            }).cath(error => {
                alert("Have an error when you update account!");
                console.log(error);
            })
            alert(item.username + item.password)
        }
        //Void xóa sản phẩm trên page 
    $scope.delete = function(item) {
            item.username = $scope.usernameEdit;
            $http.delete(`/rest/accounts/${item.username}`).then(resp => {
                var index = $scope.items.findIndex(p => p.username == item.username);
                $scope.items.splice(index, 1);
                $scope.reset();
                alert("You was remove account successfully!");
            }).catch(error => {
                alert("Have an error when you remove account!");
                console.log("Error", error);
            })
        }
        //Upload image
    $scope.imageChanged = function(files) {
            var data = new FormData();
            data.append('file', files[0]);
            $http.post('/rest/upload/account', data, {
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
    $scope.searchAccount = function(info) {
        //Load products
        $http.get(`/rest/accounts/search/${info}`).then(resp => {
            $scope.items = resp.data;
        }).catch(error => {
            $scope.initialize();
        });
    }
});