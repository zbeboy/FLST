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
        templateImageData: '#templateImageData',
        templateData: '#templateData',
        templateBrief: '#templateBrief',
        lazy: 'img.lazy'
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
            sendAjax(1, 3, i, menu);
        }

        if (i === 1) {
            sendAjax(1, 9, i, menu);
        }

        if (i === 2) {
            sendAjax(1, 1, i, menu);
        }

        if (i === 3) {
            sendAjax(1, 1, i, menu);
        }

        if (i === 4) {
            sendAjax(1, 2, i, menu);
        }

        if (i === 5) {
            sendAjax(1, 3, i, menu);
        }

    }

    /**
     * 重置排序字段
     */
    function ownSort(menu) {
        var param = {
            sortName: 'articleDateStr',
            sortOrder: 'desc'
        };
        if (menu.orderWay === 0) {
            param.sortName = 'articleDateStr';
            param.sortOrder = 'desc';
        } else if (menu.orderWay === 1) {
            param.sortName = 'articleSn';
            param.sortOrder = 'asc';
        }
        return param;
    }

    function sendAjax(pageNumber, pageSize, i, menu) {
        var sortParam = ownSort(menu);
        $.get(web_path + ajax_url.articles + '/' + menu.menuId, {
            pageNumber: pageNumber,
            pageSize: pageSize,
            sortName: sortParam.sortName,
            sortOrder: sortParam.sortOrder,
            extraSearch: JSON.stringify({menuId: menu.menuId})
        }, function (data) {
            eval(data_id.template + i + "(" + JSON.stringify(data) + "," + i + ")");
        });
    }

    function template0(data, i) {
        if (data.rows.length > 0) {
            for (var j1 = data.rows.length - 1; j1 >= 0; j1--) {
                var article = data.rows[j1];
                $(data_id.templateImageData + i).prepend(templateData0(article.articleTitle, web_path + '/' + article.articleCover, 160,
                    article.articleTitle, web_path + ajax_url.article + '/' + article.articleId, article.articleBrief));
            }
            // 图片懒加载
            $(data_id.lazy).lazyload({
                threshold: 180
            });
        }
    }

    function template1(data, i) {
        if (data.rows.length > 0) {
            for (var j2 = 0; j2 < data.rows.length; j2++) {
                var article = data.rows[j2];
                $(data_id.templateData + i + '0').append(templateData1(web_path + ajax_url.article + '/' + article.articleId, article.articleTitle, article.articleDateStr));
            }
        }
    }

    function template2(data, i) {
        if (data.rows.length > 0) {
            for (var j3 = 0; j3 < data.rows.length; j3++) {
                var article = data.rows[j3];
                $(data_id.templateImage + i).append(imageDataTemplate(article.articleTitle, web_path + '/' + article.articleCover,
                    article.articleTitle, web_path + ajax_url.article + '/' + article.articleId));
                $(data_id.templateBrief + i).text(article.articleBrief);
            }
            // 图片懒加载
            $(data_id.lazy).lazyload({
                threshold: 180
            });
        }
    }

    function template3(data, i) {
        if (data.rows.length > 0) {
            for (var j4 = 0; j4 < data.rows.length; j4++) {
                var article = data.rows[j4];
                $(data_id.templateImage + i).append(imageDataTemplate(article.articleTitle, web_path + '/' + article.articleCover,
                    article.articleTitle, web_path + ajax_url.article + '/' + article.articleId));
                $(data_id.templateBrief + i).text(article.articleBrief);
            }
            // 图片懒加载
            $(data_id.lazy).lazyload({
                threshold: 180
            });
        }
    }

    function template4(data, i) {
        if (data.rows.length > 0) {
            for (var j5 = 0; j5 < data.rows.length; j5++) {
                var article = data.rows[j5];
                $(data_id.templateImageData + i).append(templateData4(article.articleTitle, web_path + '/' + article.articleCover,
                    web_path + ajax_url.article + '/' + article.articleId, article.articleTitle, article.articleBrief, article.articleDateStr));
            }
            // 图片懒加载
            $(data_id.lazy).lazyload({
                threshold: 180
            });
        }
    }

    function template5(data, i) {
        if (data.rows.length > 0) {
            for (var j6 = 0; j6 < data.rows.length; j6++) {
                var article = data.rows[j6];
                $(data_id.templateImage + i + j6).html(templateData5(article.articleTitle, web_path + '/' + article.articleCover, 200,
                    article.articleTitle, web_path + ajax_url.article + '/' + article.articleId, article.articleBrief));
            }
            // 图片懒加载
            $(data_id.lazy).lazyload({
                threshold: 180
            });
        }
    }

    /**
     * 一层列表数据模板
     * @param alt
     * @param src
     * @param height
     * @param title
     * @param url
     * @param brief
     * @returns {string}
     */
    function templateData0(alt, src, height, title, url, brief) {
        return " <div class=\"col-sm-4\">" +
            "<div class=\"item\">" +
            "<div class=\"item-top\">" +
            "<a href=\"" + url + "\">" +
            "<img class=\"lazy\" alt=\"" + altWordLimit(alt) + "\" data-original=\"" + src + "\" data-holder-rendered=\"true\" style=\"height: " + height + "px; width: 100%; display: block;\">" +
            "</a>" +
            "<a href=\"" + url + "\"><h4 class=\"sub-title\" style=\"word-wrap:break-word;word-break:break-all;\">" + titleImageWordLimit(title) + "</h4></a>" +
            "</div>" +
            "<p class=\"item-description\">" + briefWordLimit(brief) + "</p>" +
            "</div>" +
            "</div>";
    }

    /**
     * 二层列表数据模板
     * @param url
     * @param title
     * @param articleDate
     */
    function templateData1(url, title, articleDate) {
        return "<div class=\"panel panel-default\">" +
            "<div class=\"panel-heading\">" +
            "<h4 class=\"panel-title\">" +
            "<a href=\"" + url + "\">" + titleListWordLimit(title) + "</a>" +
            "<span class=\"pull-right\">" + articleDate + "</span>" +
            "</h4>" +
            "</div>" +
            "</div>";
    }

    /**
     * 三四层列表数据模板
     * @param alt
     * @param src
     * @param title
     * @param url
     * @returns {string}
     */
    function imageDataTemplate(alt, src, title, url) {
        return "<a href=\"" + url + "\">" +
            "<img class=\"lazy\" alt=\"" + altWordLimit(alt) + "\" data-original=\"" + src + "\" data-holder-rendered=\"true\" style=\"height: 130px; width: 100%; display: block;\">" +
            "</a>" +
            "<a href=\"" + url + "\"><span class=\"sub-title\" style=\"word-wrap:break-word;word-break:break-all;\">" + titleImageWordLimit(title) + "</span></a>";
    }

    /**
     * 五层列表数据模板
     * @param alt
     * @param src
     * @param url
     * @param title
     * @param brief
     * @param articleDate
     * @returns {string}
     */
    function templateData4(alt, src, url, title, brief, articleDate) {
        return "<div class=\"col-sm-6\">" +
            "<div class=\"item\">" +
            "<article class=\"post type-post\">" +
            "<div class=\"post-top\">" +
            "<div class=\"post-thumbnail\">" +
            "<a href=\"" + url + "\">" +
            "<img class=\"lazy\" alt=\"" + altWordLimit(alt) + "\" data-original=\"" + src + "\" data-holder-rendered=\"true\" >" +
            "</a>" +
            "</div>" +
            "<div class=\"post-meta\">" +
            "<div class=\"entry-meta\">" +
            "<span class=\"entry-date\">" +
            "<time>" + articleDate + "</time>" +
            "</span>" +
            "</div>" +
            "</div>" +
            "</div>" +
            "<div class=\"post-content\">" +
            "<h2 class=\"entry-title\">" +
            "<a href=\"" + url + "\">" + titleListWordLimit(title) + "</a>" +
            "</h2>" +
            "<p class=\"entry-text\">" + briefWordLimit(brief) + "</p>" +
            "</div>" +
            "</article>" +
            "</div>" +
            "</div>";
    }

    /**
     * 六层列表数据模板
     * @param alt
     * @param src
     * @param height
     * @param title
     * @param url
     * @param brief
     * @returns {string}
     */
    function templateData5(alt, src, height, title, url, brief) {
        return "<a href=\"" + url + "\">" +
            "<img class=\"lazy\" alt=\"" + altWordLimit(alt) + "\" data-original=\"" + src + "\" data-holder-rendered=\"true\" style=\"height: " + height + "px; width: 100%; display: block;\">" +
            "</a>" +
            "<a href=\"" + url + "\"><h4 style=\"word-wrap:break-word;word-break:break-all;color:#3498db;\">" + titleImageWordLimit(title) + "</h4></a>" +
            "<p style=\"word-wrap:break-word;word-break:break-all;color:#869093\">" + briefWordLimit(brief) + "</p>";
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