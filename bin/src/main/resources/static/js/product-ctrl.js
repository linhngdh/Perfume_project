app.controller("product-ctrl", function($scope, $http) {
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};
    $scope.check = "";
    //Sự kiện khi bắt đầu chương trình
   
   // $scope.initialize();
  
  
 
   
    
    
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
        $http.get(`/home/search/${info}`).then(resp => {
            $scope.items = resp.data;
        }).catch(error => {
            $scope.initialize();
        });
    }
});