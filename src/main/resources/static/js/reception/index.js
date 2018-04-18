$(document).ready(function () {
    var ajax_url = {
        templates: '/data/home/template',
        articles: '/user/menu',
        images: '/user/images',
        article: '/user/article'
    };

    init();

    function init() {
        $.get(web_path + ajax_url.templates, function (data) {
            if (data.state) {
                for (var i = 0; i < data.listResult.length; i++) {
                    $('#templateName' + i).text(init_page_param.language === 'zh_cn' ? data.listResult[i].menuName : data.listResult[i].menuNameEn);
                    $('#templateUrl' + i).attr('href', data.listResult[i].menuLink);
                    article(i, data.listResult[i]);
                }
            }
        });
    }

    /**
     * 文章
     * @param i
     * @param menu
     */
    function article(i, menu) {
        template0Ajax(i, menu);
        template1Ajax(i, menu);
    }

    function template0Ajax(i, menu) {
        // 不用考虑栏目是否显示，因为查询全部栏目时，就只查询显示的
        if (i === 0) {
            $.get(web_path + ajax_url.articles + '/' + menu.menuId, {
                pageNumber: 1,
                pageSize: 9,
                sortName: 'articleDateStr',
                sortOrder: 'desc',
                extraSearch: JSON.stringify({menuId: menu.menuId})
            }, function (data) {
                template0(data);
            });
        }
    }

    function template1Ajax(i, menu) {
        if (i === 1) {
            $.get(web_path + ajax_url.articles + '/' + menu.menuId, {
                pageNumber: 1,
                pageSize: 5,
                sortName: 'articleDateStr',
                sortOrder: 'desc',
                extraSearch: JSON.stringify({menuId: menu.menuId})
            }, function (data) {
                template1(data);
            });
        }
    }

    function template0(data) {
        if (data.total > 0) {
            var article = data.rows[0];
            $('#templateImage0').html(imageTemplate(article.articleTitle, web_path + ajax_url.images + '/' + article.articleCover, 160,
                article.articleTitle, web_path + ajax_url.article + '/' + article.articleId, article.articleBrief));
            var num = 0;
            if (data.total > 5) {
                num = 5;
            } else {
                num = data.total;
            }
            for (var j1 = 1; j1 < num; j1++) {
                $('#templateData00').prepend(listTemplate(web_path + ajax_url.article + '/' + data.rows[j1].articleId, data.rows[j1].articleTitle));
            }

            for (var j2 = num; j2 < data.total; j2++) {
                $('#templateData01').prepend(listTemplate(web_path + ajax_url.article + '/' + data.rows[j1].articleId, data.rows[j1].articleTitle));
            }
        }
    }

    function template1(data) {
        if (data.total > 0) {
            var article = data.rows[0];
            $('#templateImage1').html(imageTemplate(article.articleTitle, web_path + ajax_url.images + '/' + article.articleCover, 160,
                article.articleTitle, web_path + ajax_url.article + '/' + article.articleId, article.articleBrief));
            for (var j3 = 1; j3 < data.total; j3++) {
                $('#templateData10').prepend(listDateTemplate(web_path + ajax_url.article + '/' + data.rows[j3].articleId, data.rows[j3].articleTitle, data.rows[j3].articleDateStr));
            }
        }
    }

    /**
     * 图片显示模板
     * @param alt
     * @param src
     * @param height
     * @param title
     * @param url
     * @param brief
     * @returns {string}
     */
    function imageTemplate(alt, src, height, title, url, brief) {
        return "<img alt=\"" + altWordLimit(alt) + "\" src=\"" + src + "\" data-holder-rendered=\"true\" style=\"height: " + height + "px; width: 100%; display: block;\">" +
            "<a href=\"" + url + "\"><h4 style=\"color:black;word-wrap:break-word;word-break:break-all;\">" + titleImageWordLimit(title) + "</h4></a>" +
            "<p style=\"word-wrap:break-word;word-break:break-all;\">" + briefWordLimit(brief) + "</p>";
    }

    /**
     * 列表数据模板
     * @param url
     * @param title
     */
    function listTemplate(url, title) {
        return "<div class=\"col-md-12\" style=\"padding-top: 10px;\">" +
            "<a style=\"font-size: 14px;color: #333;\" href=\"" + url + "\">" + titleListWordLimit(title) + "</a>" +
            "<hr/>" +
            "</div>";
    }

    /**
     * 列表日期数据模板
     * @param url
     * @param title
     * @param articleDate
     */
    function listDateTemplate(url, title, articleDate) {
        return "<div class=\"col-md-12\" style=\"padding-top: 10px;\">" +
            "<a style=\"font-size: 14px;color: #333;\" href=\"" + url + "\">" + titleListWordLimit(title) + "</a>" +
            "<span class=\"pull-right\">" + articleDate + "</span>" +
            "<hr/>" +
            "</div>";
    }

    /**
     * 图片标题字数限制
     * @param title
     * @returns {*}
     */
    function titleImageWordLimit(title) {
        var words;
        if (init_page_param.language === 'zh_cn') {
            words = 37;
        } else {
            words = 100;
        }

        if (title.length > words) {
            title = title.substring(0, words) + "..."
        }
        return title;
    }

    /**
     * 列表标题字数限制
     * @param title
     * @returns {*}
     */
    function titleListWordLimit(title) {
        var words;
        if (init_page_param.language === 'zh_cn') {
            words = 24;
        } else {
            words = 45;
        }
        if (title.length > words) {
            title = title.substring(0, words) + "..."
        }
        return title;
    }

    /**
     * 简介字数限制
     * @param brief
     * @returns {string|*}
     */
    function briefWordLimit(brief) {
        var words;
        if (init_page_param.language === 'zh_cn') {
            words = 50;
        } else {
            words = 150;
        }
        if (brief.length > words) {
            brief = brief.substring(0, words) + "..."
        }
        return brief;
    }

    /**
     * alt字数限制
     * @param alt
     * @returns {string|*}
     */
    function altWordLimit(alt) {
        var words;
        if (init_page_param.language === 'zh_cn') {
            words = 10;
        } else {
            words = 20;
        }
        if (alt.length > words) {
            alt = alt.substring(0, words) + "..."
        }
        return alt;
    }
});