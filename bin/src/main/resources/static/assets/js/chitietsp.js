function activeTab(obj) {
    $('.product-tab ul li').removeClass('active');
    $(obj).addClass('active');
    var id = $(obj).attr('data-tab');
    $('.tab-content').removeClass('active');
    $(id).addClass('active');
}
$('.product-tab ul li').click(function () {
    activeTab(this);
    return false;
});
var galleryThumbs = new Swiper('.gallery-thumbs', {
    spaceBetween: 4,
    slidesPerView: 10,
    freeMode: true,
    lazy: true,
    watchSlidesVisibility: true,
    watchSlidesProgress: true,
    hashNavigation: true,
    slideToClickedSlide: true,
    breakpoints: {
        260: {
            slidesPerView: 3,
            spaceBetween: 10,
        },
        300: {
            slidesPerView: 3,
            spaceBetween: 10,
        },
        500: {
            slidesPerView: 3,
            spaceBetween: 10,
        },
        640: {
            slidesPerView: 4,
            spaceBetween: 10,
        },
        768: {
            slidesPerView: 4,
            spaceBetween: 10,
        },
        1024: {
            slidesPerView: 4,
            spaceBetween: 10,
        },
        1199: {
            slidesPerView: 4,
            spaceBetween: 10,
        },
    },
    navigation: {
        nextEl: '.gallery-thumbs .swiper-button-next',
        prevEl: '.gallery-thumbs .swiper-button-prev',
    },
});
var galleryTop = new Swiper('.gallery-top', {
    spaceBetween: 0,
    lazy: true,
    hashNavigation: true,
    thumbs: {
        swiper: galleryThumbs
    }
});
var swiperrela = new Swiper('.product-relate-swiper', {
    slidesPerView: 4,
    spaceBetween: 20,
    slidesPerGroup: 1,
    navigation: {
        nextEl: '.product-relate-swiper .swiper-button-next',
        prevEl: '.product-relate-swiper .swiper-button-prev',
    },
    breakpoints: {
        280: {
            slidesPerView: 2,
            spaceBetween: 10
        },
        640: {
            slidesPerView: 2,
            spaceBetween: 10
        },
        768: {
            slidesPerView: 3,
            spaceBetween: 15
        },
        992: {
            slidesPerView: 3,
            spaceBetween: 15
        },
        1024: {
            slidesPerView: 4,
            spaceBetween: 15
        }
    }
});
$(document).ready(function () {
    $("#lightgallery").lightGallery({
        thumbnail: false
    });
});

$(document).ready(function ($) {
    var product = { "id": 32254530, "name": "Nước Hoa Yves Saint Laurent Libre L’Absolu Platine EDP", "alias": "nuoc-hoa-yves-saint-laurent-libre-l-absolu-platine-edp", "vendor": "Yves Saint Laurent", "type": null, "content": "<p><button aria-expanded=\"true\" aria-selected=\"true\" data-analytics=\"{&quot;promoObject&quot;:{&quot;creative&quot;:&quot;Description&quot;},&quot;event&quot;:&quot;uaevent&quot;,&quot;category&quot;:&quot;product detail page&quot;,&quot;action&quot;:&quot;description&quot;,&quot;label&quot;:&quot;libre absolu platine::3614273924030&quot;,&quot;extraData&quot;:{&quot;event_name&quot;:&quot;product_info_click&quot;,&quot;product_tab&quot;:&quot;description&quot;,&quot;product_info&quot;:&quot;libre absolu platine::3614273924030&quot;}}\" role=\"tab\">DESCRIPTION&nbsp;</button></p>\n<p>Keywords</p>\n<p>Orange Blossom Diva Lavender White Lavender</p>\n<p>Type</p>\n<p>Women's Fragrance</p>\n<p>What it is</p>\n<p>This feminine perfume brings absolute intensity and a long-lasting trail of freedom with the highest concentration ever on YSL Libre. The burning sensuality of an orange blossom from Morocco &amp; the boldness of a diva lavender from France perfectly blend with a new exclusive and irresistible sensual white lavender accord to create a warm, floral fragrance. The ultimate sensual fragrance crafted with captivating tension that harmonizes fire and ice when it graces the skin.</p>", "summary": null, "template_layout": "product", "available": true, "tags": ["Yves Saint Laurent"], "price": 4490000.0000, "price_min": 4490000.0000, "price_max": 4490000.0000, "price_varies": false, "compare_at_price": 5790000.0000, "compare_at_price_min": 5790000.0000, "compare_at_price_max": 5790000.0000, "compare_at_price_varies": false, "variants": [{ "id": 95826602, "barcode": null, "sku": "SKU4555566211", "title": "90ml", "options": ["90ml"], "option1": "90ml", "option2": null, "option3": null, "available": true, "taxable": true, "price": 4490000.0000, "compare_at_price": 5790000.0000, "inventory_management": "", "inventory_policy": "deny", "inventory_quantity": 0, "weight_unit": "g", "weight": 300, "requires_shipping": true, "image": null }], "featured_image": { "src": "https://bizweb.dktcdn.net/100/431/707/products/12860706-9bac-4513-8558-2d6eaa2c59d2-jpeg.jpg?v=1692167168333" }, "images": [{ "src": "https://bizweb.dktcdn.net/100/431/707/products/12860706-9bac-4513-8558-2d6eaa2c59d2-jpeg.jpg?v=1692167168333" }, { "src": "https://bizweb.dktcdn.net/100/431/707/products/img-4692-jpeg.jpg?v=1692167171323" }, { "src": "https://bizweb.dktcdn.net/100/431/707/products/img-4689-jpeg.jpg?v=1692167171323" }, { "src": "https://bizweb.dktcdn.net/100/431/707/products/img-4690-jpeg.jpg?v=1692167171323" }, { "src": "https://bizweb.dktcdn.net/100/431/707/products/img-4691-jpeg.jpg?v=1692167171323" }, { "src": "https://bizweb.dktcdn.net/100/431/707/products/img-4688-jpeg.jpg?v=1692167171323" }], "options": ["Dung Tích"], "created_on": "2023-08-16T13:22:25", "modified_on": "2023-08-16T13:26:11", "published_on": "2022-02-18T16:15:00" };
    var alias_pro = 'nuoc-hoa-yves-saint-laurent-libre-l-absolu-platine-edp';
    var array_list = [product];
    var list_viewed_pro_old = localStorage.getItem('last_viewed_products');
    var last_viewed_pro_new = "";
    if (list_viewed_pro_old == null || list_viewed_pro_old == '')
        last_viewed_pro_new = array_list;
    else {
        var list_viewed_pro_old = JSON.parse(localStorage.last_viewed_products);
        list_viewed_pro_old.splice(20, 1);
        for (i = 0; i < list_viewed_pro_old.length; i++) {
            if (list_viewed_pro_old[i].alias == alias_pro) {
                list_viewed_pro_old.splice(i, 1);
                break;
            }
        }
        list_viewed_pro_old.unshift(array_list[0]);
        last_viewed_pro_new = list_viewed_pro_old;
    }
    localStorage.setItem('last_viewed_products', JSON.stringify(last_viewed_pro_new));
    if (localStorage.last_viewed_products != undefined) {
        jQuery('.product-viewed').removeClass('d-none');
        var last_viewd_pro_array = JSON.parse(localStorage.last_viewed_products);
        var recentview_promises = [];
        var size_pro_review = last_viewd_pro_array.length;
        if (size_pro_review >= 14) {
            size_pro_review = 14;
        } else {
            size_pro_review = last_viewd_pro_array.length;
        }
        if (size_pro_review < 1) {
            jQuery('.product-viewed').addClass('d-none');
        } else {
            jQuery('.product-viewed').removeClass('d-none');
        }
        if (size_pro_review > 0) {
            for (i = 0; i < size_pro_review; i++) {
                if (i < 6) {
                    var alias_product = last_viewd_pro_array[i];
                    if (!!alias_product.alias) {
                        var promise = new Promise(function (resolve, reject) {
                            $.ajax({
                                url: '/' + alias_product.alias + '?view=itemview',
                                success: function (product) {
                                    resolve(product);
                                },
                                error: function (err) {
                                    reject(alias_product.id);
                                }
                            })
                        });
                        recentview_promises.push(promise);
                    }
                }
            }
            Promise.all(recentview_promises).then(function (values) {
                $.each(values, function (i, v) {
                    if (v != '') {
                        $('.recent-viewed .swiper-wrapper').append(v);
                    } else {
                        last_viewd_pro_array.splice(i, 1);
                    }
                });
                setTimeout(function () {
                    var swiper = new Swiper('.recent-viewed', {
                        slidesPerView: 4,
                        spaceBetween: 20,
                        slidesPerGroup: 1,
                        navigation: {
                            nextEl: '.recent-viewed .swiper-button-next',
                            prevEl: '.recent-viewed .swiper-button-prev',
                        },
                        breakpoints: {
                            280: {
                                slidesPerView: 2,
                                spaceBetween: 10
                            },
                            640: {
                                slidesPerView: 2,
                                spaceBetween: 10
                            },
                            768: {
                                slidesPerView: 3,
                                spaceBetween: 15
                            },
                            992: {
                                slidesPerView: 3,
                                spaceBetween: 15
                            },
                            1024: {
                                slidesPerView: 4,
                                spaceBetween: 15
                            }
                        }
                    });
                    awe_lazyloadImage();
                    $('.add_to_cart').click(function (e) {
                        e.preventDefault();
                        var $this = $(this);
                        var form = $this.parents('form');
                        $.ajax({
                            type: 'POST',
                            url: '/cart/add.js',
                            async: false,
                            data: form.serialize(),
                            dataType: 'json',
                            beforeSend: function () { },
                            success: function (line_item) {
                                ajaxCart.load();
                                $('.popup-cart-mobile, .backdrop__body-backdrop___1rvky').addClass('active');
                                AddCartMobile(line_item);
                            },
                            cache: false
                        });
                    });

                    favoriBean.Wishlist.wishlistProduct();

                    awe_hidePopup('.loading');
                    $(document).ready(function () {
                        var modal = $('.quickview-product');
                        var btn = $('.quick-view');
                        var span = $('.quickview-close');
                        btn.click(function () {
                            modal.show();
                        });
                        span.click(function () {
                            modal.hide();
                        });
                        $(window).on('click', function (e) {
                            if ($(e.target).is('.modal')) {
                                modal.hide();
                            }
                        });
                    });

                }, 500);
                localStorage.setItem('last_viewed_products', JSON.stringify(last_viewd_pro_array));

            }).catch(function (productId) {
                const listLocalStorage = (JSON.parse(localStorage.getItem('last_viewed_products')));
                for (let i = 0; i < listLocalStorage.length; ++i) {
                    if (listLocalStorage[i].id == productId) {
                        listLocalStorage.splice(i, 1);
                    }
                }
                console.log('listLocalStorage', listLocalStorage);
                localStorage.setItem('last_viewed_products', JSON.stringify(listLocalStorage));
            });
        }
        if (size_pro_review < 4) {
            jQuery('.product-seemore').removeClass('d-none');
        }
    } else {
        jQuery('.product-viewed').addClass('d-none');
    }
});