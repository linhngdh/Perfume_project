$(document).on('click', '.dis_copy', function(e) {
	e.preventDefault();
	var copyText = $(this).attr('data-copy');
	var copyTextarea = document.createElement("textarea");
	copyTextarea.textContent = copyText;
	document.body.appendChild(copyTextarea);
	copyTextarea.select();
	document.execCommand("Sao chép");
	document.body.removeChild(copyTextarea);
	var cur_text = $(this).text();
	var $cur_btn = $(this);
	$(this).addClass("disabled");
	$(this).text("Đã lưu");
	$(this).parent().addClass('active');
	setTimeout(function() {
		$cur_btn.removeClass("disabled");
		$cur_btn.parent().removeClass('active');
		$cur_btn.text(cur_text);
	}, 2500)
})