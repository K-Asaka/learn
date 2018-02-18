$(function() {
	$('ul').each(function() {
		$(this).html($(this).html().replace(/>\s+</gi, '><'));
	});
	$('.title').fitText(0.5);
	$('.date').fitText(1.51);
	$('.list-cast').eq(0).fitText(1.1);
	$('.list-cast').eq(1).fitText(1.7);
	$('.list-cast').eq(2).fitText(1.96);
	$('.list-schedule').fitText(3.2, { minFontSize: '18px' });
});