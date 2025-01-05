// ========= NAV ==========
$(document).ready(function () {
    var margin_left = 0;
    $('#prev').on('click', function (e) {
        e.preventDefault();
        animateMargin(190);
    });
    $('#next').on('click', function (e) {
        e.preventDefault();
        animateMargin(-190);
    });
    const animateMargin = (amount) => {
        margin_left = Math.min(0, Math.max(getMaxMargin(), margin_left + amount));
        $('ul.item_big').animate({
            'margin-left': margin_left
        }, 300);
    };
    const getMaxMargin = () =>
        $('ul.item_big').parent().width() - $('ul.item_big')[0].scrollWidth;
})
// =========== VỀ CHÚNG TÔI ===========

