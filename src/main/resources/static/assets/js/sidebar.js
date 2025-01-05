// Lấy tất cả các phần tử "li" trong danh sách
var elements = document.querySelectorAll('.sidebar-elements li');

// Duyệt qua từng phần tử "li"
elements.forEach(function (element) {
  // Gán sự kiện click cho mỗi phần tử "li"
  element.addEventListener('click', function () {
    // Loại bỏ lớp "active" khỏi tất cả các phần tử "li"
    elements.forEach(function (el) {
      el.classList.remove('active');
    });

    // Thêm lớp "active" vào phần tử "li" được nhấp
    this.classList.add('active');
  });
});