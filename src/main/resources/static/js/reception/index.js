$(document).ready(function () {
    var ajax_url = {
        templates: '/data/home/template',
        articles: '/data/articles',
        article: '/user/article'
    };

    var data_id = {
        templateName: '#templateName',
        templateUrl: '#templateUrl',
        template: 'template',
        templateImage: '#templateImage',
        templateData: '#templateData',
        lazy:'img.lazy'
    };

    init();

    function init() {
        // 加载数据
        $.get(web_path + ajax_url.templates, function (data) {
            if (data.state) {
                for (var i = 0; i < data.listResult.length; i++) {
                    $(data_id.templateName + i).text(init_page_param.language === 'zh_cn' ? data.listResult[i].menuName : data.listResult[i].menuNameEn);
                    $(data_id.templateUrl + i).attr('href', data.listResult[i].menuLink);
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
        // 不用考虑栏目是否显示，因为查询全部栏目时，就只查询显示的
        if (i === 0) {
            sendAjax(1, 9, i, menu);
        }

        if (i === 1) {
            sendAjax(1, 5, i, menu);
        }

        if (i === 2) {
            sendAjax(1, 4, i, menu);
        }

        if (i === 3) {
            sendAjax(1, 4, i, menu);
        }

        if (i === 4) {
            sendAjax(1, 9, i, menu);
        }

        if (i === 5) {
            sendAjax(1, 3, i, menu);
        }

    }

    function sendAjax(pageNumber, pageSize, i, menu) {
        $.get(web_path + ajax_url.articles + '/' + menu.menuId, {
            pageNumber: pageNumber,
            pageSize: pageSize,
            sortName: 'articleDateStr',
            sortOrder: 'desc',
            extraSearch: JSON.stringify({menuId: menu.menuId})
        }, function (data) {
            eval(data_id.template + i + "(" + JSON.stringify(data) + "," + i + ")");
        });
    }

    function template0(data, i) {
        if (data.rows.length > 0) {
            var article = data.rows[0];
            $(data_id.templateImage + i).html(imageTemplate(article.articleTitle, web_path + '/' + article.articleCover, 160,
                article.articleTitle, web_path + ajax_url.article + '/' + article.articleId, article.articleBrief));
            var num = 0;
            if (data.rows.length > 5) {
                num = 5;
            } else {
                num = data.rows.length;
            }
            for (var j1 = 1; j1 < num; j1++) {
                $(data_id.templateData + i + '0').append(listTemplate(web_path + ajax_url.article + '/' + data.rows[j1].articleId, data.rows[j1].articleTitle));
            }

            for (var j2 = num; j2 < data.rows.length; j2++) {
                $(data_id.templateData + i + '1').append(listTemplate(web_path + ajax_url.article + '/' + data.rows[j2].articleId, data.rows[j2].articleTitle));
            }

            // 图片懒加载
            $(data_id.lazy).lazyload();
        }
    }

    function template1(data, i) {
        if (data.rows.length > 0) {
            var article = data.rows[0];
            $(data_id.templateImage + i).html(imageTemplate(article.articleTitle, web_path + '/' + article.articleCover, 160,
                article.articleTitle, web_path + ajax_url.article + '/' + article.articleId, article.articleBrief));
            for (var j3 = 1; j3 < data.rows.length; j3++) {
                $(data_id.templateData + i + '0').append(listDateTemplate(web_path + ajax_url.article + '/' + data.rows[j3].articleId, data.rows[j3].articleTitle, data.rows[j3].articleDateStr));
            }
            // 图片懒加载
            $(data_id.lazy).lazyload();
        }
    }

    function template2(data, i) {
        if (data.rows.length > 0) {
            var article = data.rows[0];
            $(data_id.templateImage + i).html(imageTemplate(article.articleTitle, web_path + '/' + article.articleCover, 160,
                article.articleTitle, web_path + ajax_url.article + '/' + article.articleId, article.articleBrief));
            for (var j4 = 1; j4 < data.rows.length; j4++) {
                $(data_id.templateData + i + '0').append(listTemplate(web_path + ajax_url.article + '/' + data.rows[j4].articleId, data.rows[j4].articleTitle));
            }
            // 图片懒加载
            $(data_id.lazy).lazyload();
        }
    }

    function template3(data, i) {
        if (data.rows.length > 0) {
            var article = data.rows[0];
            $(data_id.templateImage + i).html(imageTemplate(article.articleTitle, web_path + '/' + article.articleCover, 160,
                article.articleTitle, web_path + ajax_url.article + '/' + article.articleId, article.articleBrief));
            for (var j5 = 1; j5 < data.rows.length; j5++) {
                $(data_id.templateData + i + '0').append(listTemplate(web_path + ajax_url.article + '/' + data.rows[j5].articleId, data.rows[j5].articleTitle));
            }
            // 图片懒加载
            $(data_id.lazy).lazyload();
        }
    }

    function template4(data, i) {
        if (data.rows.length > 0) {
            var article = data.rows[0];
            $(data_id.templateImage + i).html(imageTemplate(article.articleTitle, web_path + '/' + article.articleCover, 160,
                article.articleTitle, web_path + ajax_url.article + '/' + article.articleId, article.articleBrief));
            var num = 0;
            if (data.rows.length > 5) {
                num = 5;
            } else {
                num = data.rows.length;
            }
            for (var j6 = 1; j6 < num; j6++) {
                $(data_id.templateData + i + '0').append(listTemplate(web_path + ajax_url.article + '/' + data.rows[j6].articleId, data.rows[j6].articleTitle));
            }

            for (var j7 = num; j7 < data.rows.length; j7++) {
                $(data_id.templateData + i + '1').append(listTemplate(web_path + ajax_url.article + '/' + data.rows[j7].articleId, data.rows[j7].articleTitle));
            }
            // 图片懒加载
            $(data_id.lazy).lazyload();
        }
    }

    function template5(data, i) {
        if (data.rows.length > 0) {
            for (var j8 = 0; j8 < data.rows.length; j8++) {
                var article = data.rows[j8];
                $(data_id.templateImage + i + j8).html(imageTemplate(article.articleTitle, web_path + '/' + article.articleCover, 200,
                    article.articleTitle, web_path + ajax_url.article + '/' + article.articleId, article.articleBrief));
            }
            // 图片懒加载
            $(data_id.lazy).lazyload();
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
        return "<img class=\"lazy\" alt=\"" + altWordLimit(alt) + "\" data-original=\"" + src + "\" data-holder-rendered=\"true\" style=\"height: " + height + "px; width: 100%; display: block;\">" +
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