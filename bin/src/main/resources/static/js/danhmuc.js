
var swiperwish = new Swiper('.danhmuc-swiper', {
    slidesPerView: 5,
    loop: false,
    grabCursor: true,
    spaceBetween: 20,
    roundLengths: true,
    slideToClickedSlide: false,
    slidesPerColumn: 2,
    navigation: {
        nextEl: '.danhmuc-swiper .swiper-button-next',
        prevEl: '.danhmuc-swiper .swiper-button-prev',
    },
    autoplay: false,
    breakpoints: {
        300: {
            slidesPerView: 2,
            spaceBetween: 30
        },
        500: {
            slidesPerView: 2,
            spaceBetween: 30
        },
        640: {
            slidesPerView: 2,
            spaceBetween: 30
        },
        768: {
            slidesPerView: 4,
            spaceBetween: 30
        },
        991: {
            slidesPerView: 5,
            spaceBetween: 30
        },
        1200: {
            slidesPerView: 7,
            spaceBetween: 30
        }
    }
});