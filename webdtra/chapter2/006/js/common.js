$(function () {

    var minWidth = 640;
    $(window).resize(function () {
        if (minWidth >= $(this).width()) {
            $('#g-nav-05').hide();
            $('#menu').removeClass("on");
        } else {
            $('#g-nav-05').show();
        }
    }).trigger('resize');


    $('#menu').click(function () {

        $('#g-nav-05').stop(true, true).slideToggle(200);

        if ($(this).hasClass("on")) {
            $(this).removeClass("on");
        } else {
            $(this).addClass("on");
        }

    });
});