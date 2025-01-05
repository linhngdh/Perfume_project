$(document).ready(() => {
    if (!$('#coupon-modal').length) {
        $('body').append($('[data-template="couponPopup"]').html())
    }

    if (window.matchMedia('(max-width: 1199px)').matches) {
        $(document).on('click', '.coupon-icon-info', function (e) {
            e.preventDefault();
            const code = $(this).data('coupon')
            const info = $(this).find('.coupon_info').html() || ''
            const title = $(this).parents('.coupon_body').find('.coupon_title').text() || ''
            const couponHtml = `
					<div class="coupon-title">${title}</div>
					<div class="coupon-row">
						<div class="coupon-label">MÃ£ khuyáº¿n mÃ£i:</div><span class="code">${code}</span>

					</div>
					<div class="coupon-row">
						<div class="coupon-label">Äiá»u kiá»‡n:</div><div class="coupon-info">${info}</div>
					</div>
					<div class="coupon-action">
					<button type="button" class="btn btn-main" data-dismiss="modal" data-backdrop="false"
        				aria-label="Close" style="z-index: 9;">ÄÃ³ng</button>
					<button class="btn btn-main coupon_copy" data-ega-coupon="${code}">
						<span>LÆ°u mÃ£</span></button>
					</div>
					`
            $('.coupon-modal .coupon-content').html(couponHtml)
            $("#coupon-modal").modal();
        })
    }

    $(document).on('click', '.coupon_copy', function () {
        let copyText = "Sao chép";
        let copiedText = "Đã sao chép";

        
        copyText = "Lưu mã";
        
        
        copiedText = "Đã sao chép";
        
        const coupon = $(this).data().egaCoupon;
        const _this = $(this);
        let iconType = true;
        if (!_this.hasClass("type--icon")) {
            iconType = false;
            _this.html(`<span>${copiedText}</span>`);
        }
        _this.addClass('disabled');
        setTimeout(function () {
            if (!iconType) {
                _this.html(`<span>${copyText}</span>`);
            }
            _this.removeClass('disabled');
        }, 3000)
        navigator.clipboard.writeText(coupon);
    });


    const popoverActive = function (wrapPopover, child) {
		//console.log('popoverActive init...')
        //let wrapPopover = '.section_coupons';
        //let popover = wrapPopover + ' .coupon-icon-info:not(.text)';
        let popover = wrapPopover + ' ' + child;
        let coupon = null;
        let timeout;

        $(popover).popover({
            html: true,
            animation: true,
            container: wrapPopover,
            trigger: 'manual',
            placement: function (popover, trigger) {
                var placement = jQuery(trigger).attr('data-placement');
                var dataClass = jQuery(trigger).attr('data-class');
                jQuery(trigger).addClass('is-active');
                jQuery(popover).addClass(dataClass);
                return placement;
            },
			title : function (){
				return '<div class="text-center">'+$(this).data('title')+'</div>'
			},
            content: function () {
                return '<div class="coupon--line code"><span class="title">MÃ£</span><span class="content">' + $(this).data('coupon') + '</span>' +
                '<span class="popover-trigger"><i class="far fa-copy"></i></span></div> ' +
                '<div class="coupon--line hsd"><span class="title">HSD</span><span class="content">' + $(this).data('hsd') + '</span></div> ' +
                '<div class="coupon--line info"><div class="content">' + $(this).find('.coupon-desc--row.coupon-about').html() + '</div></div>'
            },
        });
        $(popover).on('mouseenter', function () {
            clearTimeout(timeout);
            let __this = $(this);
            coupon = __this.attr('data-coupon');
            __this.popover('show');
        });

        $(popover).on('mouseleave', function () {
            var _this = this;
            timeout = setTimeout(function () {
                $(_this).popover('hide');
            }, 100);
        });
        $('body').on('mouseenter', wrapPopover + ' .popover', function () {
            clearTimeout(timeout);
        });

        $('body').on('mouseleave', wrapPopover + ' .popover', function () {
            var _this = this;
            timeout = setTimeout(function () {
                $(_this).popover('hide');
            }, 100);
        });


        $(document).on('click', wrapPopover + ' .popover-trigger', function (e) {
            e.preventDefault();
            const _this = $(this);
            const copyText = '<i class="far fa-copy"></i>'
            const copiedText = '<i class="fas fa-copy"></i>'

            _this.html(`${copiedText}`);
            _this.addClass('disabled');

            setTimeout(function () {
                _this.html(`${copyText}`);
                _this.removeClass('disabled');
            }, 3000)
            navigator.clipboard.writeText(coupon);
        });
    }
	if (window.matchMedia('(min-width: 991px)').matches) {
		popoverActive('.section_coupons', '.coupon-icon-info:not(.text)');
	}   
})
