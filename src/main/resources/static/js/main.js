// src/main/resources/static/js/main.js
$(document).ready(function () {
    $(".nav-link").click(function (e) {
        e.preventDefault();
        var categoryId = $(this).data("category-id");

        $.get("/home/loadProducts", { cid: categoryId }, function (data) {
            $("#productContainer").html(data);
        });
    });

    var firstCategoryId = $(".nav-link:first").data("category-id");
    $.get("/home/loadProducts", { cid: firstCategoryId }, function (data) {
        $("#productContainer").html(data);
    });
});
