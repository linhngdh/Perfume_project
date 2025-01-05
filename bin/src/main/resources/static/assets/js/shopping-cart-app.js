const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function($scope, $http) {
    //Quan ly gio hang
    $scope.cart = {
        items: [],
        //Them san pham vao gio hang
        add(product_id) {
            var item = this.items.find(item => item.product_id == product_id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${product_id}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
            console.log(item.image);
        },
        //Xoa san pam khoi gio hang
        remove(product_id) {
            var index = this.items.findIndex(item => item.product_id == product_id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },
        //Xoa sach cac sản phẩm trong giỏ
        clear() {
            this.items = [];
            this.saveToLocalStorage();
        },
        //Tinh thanh tien cua mot san pham
        amt_of(item) {},
        //Tinh tong so luong cac mat hang trong gio
        get count() {
            return this.items.map(item => item.qty).reduce((total, qty) => total += qty, 0);
        },
        //Tong thanh tien cac mat hang trong gio
        get amount() {
            return this.items.map(item => item.qty * item.price).reduce((total, qty) => total += qty, 0)
        },
        //Luu gio hang vao local storage
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        },
        //Doc gio hang tu LocalStorage
        loadFromLocalStorage() {
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        }
    }
    $scope.cart.loadFromLocalStorage();
 
});