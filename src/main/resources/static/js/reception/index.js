$(document).ready(function () {
    var ajax_url = {
        templates: '/data/home/template'
    };

    init();

    function init() {
        $.get(web_path + ajax_url.templates, function (data) {
            if (data.state) {
                for (var i = 0; i < data.listResult.length; i++) {
                    $('#templateName' + i).text(init_page_param.language === 'zh_cn' ? data.listResult[i].menuName : data.listResult[i].menuNameEn);
                    $('#templateUrl' + i).attr('href', data.listResult[i].menuLink);
                    if(init_page_param.language === 'zh_cn'){
                        article(data.listResult[i]);
                    } else {
                        articleEn(data.listResult[i]);
                    }
                }
            }
        });
    }

    /**
     * 中文文章
     * @param menu
     */
    function article(menu){

    }

    /**
     * 英文文章
     * @param menu
     */
    function articleEn(menu){

    }
});