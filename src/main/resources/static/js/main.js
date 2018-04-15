var windowWidth = $(window).width();

if (windowWidth > 767) {
    $('li.dropdown').mouseover(function () {

        $(this).addClass('open');
    }).mouseout(function () {
        $(this).removeClass('open');
    });

    $(".navbar-wrapper").stick();
} else {
    $('li.dropdown-submenu > .dropdown-menu').show();
    $('li.dropdown-submenu').removeClass('dropdown-submenu');
}

// Back to top button
$(window).scroll(function () {
    if ($(this).scrollTop() > 100) {
        $('.back-to-top').fadeIn('slow');
    } else {
        $('.back-to-top').fadeOut('slow');
    }
});
$('.back-to-top').click(function () {
    $('html, body').animate({scrollTop: 0}, 1500, 'easeInOutExpo');
    return false;
});
// Initiate the wowjs animation library
new WOW().init();