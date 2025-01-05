app.controller("order-detail-ctrl", function($scope, $http, $document, $routeParams) {
    $scope.orderDetail = {};

    // Đọc orderDetailId từ route params nếu có
    var orderDetailId = $routeParams.orderDetailId;

    $scope.initialize = function(orderDetailId) {
        $http.get(`/rest/order-details/${orderDetailId}`)
            .then(response => {
                $scope.orderDetail = response.data;
            })
            .catch(error => {
                console.log("Error loading order detail", error);
            });
    };

    // Chờ đến khi DOM hoàn tất tải
    $document.ready(function() {
        // Gọi hàm initialize khi controller được khởi tạo
        $scope.initialize(orderDetailId);
    });
});
