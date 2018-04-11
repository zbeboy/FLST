/**
 * Created by zbeboy 2018-04-11 .
 **/
!function ($) {
    $(document).on("click","ul.nav li.parent > a", function(){
        $(this).find('em:first').toggleClass("glyphicon-minus");
    });
    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");

    var url = window.location;
    var element = $('ul.nav a').filter(function() {
        return this.href == url;
    }).parent().addClass('active').parent();
    if (element.hasClass('children')) {
        element.addClass('in');
    }

}(window.jQuery);

$(window).on('resize', function () {
    if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
});
$(window).on('resize', function () {
    if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
});