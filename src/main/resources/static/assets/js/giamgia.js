
var swiperwish = new Swiper('.blog-swiper', {
    slidesPerView: 3,
    loop: false,
    grabCursor: true,
    spaceBetween: 30,
    roundLengths: true,
    slideToClickedSlide: false,
    pagination: {
        el: '.blog-swiper .swiper-pagination',
        clickable: true,
    },
    autoplay: false,
    breakpoints: {
        300: {
            slidesPerView: 1,
            spaceBetween: 30
        },
        500: {
            slidesPerView: 1,
            spaceBetween: 30
        },
        640: {
            slidesPerView: 1,
            spaceBetween: 30
        },
        768: {
            slidesPerView: 2,
            spaceBetween: 30
        },
        991: {
            slidesPerView: 3,
            spaceBetween: 30
        },
        1200: {
            slidesPerView: 3,
            spaceBetween: 30
        }
    }
});