$(document).ready(function () {
    /*
    ajax url.
    */
    var ajax_url = {
        data_url: '/data/articles',
        article: '/user/article'
    };

    /*
   参数
    */
    var param = {
        pageNumber: 0,
        pageSize: 10,
        sortName: 'articleDateStr',
        sortOrder: 'desc',
        extraSearch: JSON.stringify({menuId: init_page_param.menuId})
    };

    /**
     * 重置排序字段
     */
    function ownSort() {
        if (init_page_param.orderWay === 0) {
            param.sortName = 'articleDateStr';
            param.sortOrder = 'desc';
        } else if (init_page_param.orderWay === 1) {
            param.sortName = 'articleSn';
            param.sortOrder = 'asc';
        }
    }

    init();

    /**
     * 初始化数据
     */
    function init() {
        ownSort();
        $.get(web_path + ajax_url.data_url + '/' + init_page_param.menuId, param, function (data) {
            createPage(data);
            listData(data);
        });
    }

    /**
     * 列表数据
     * @param data 数据
     */
    function listData(data) {
        $('#tableData').html('');
        for (var i = 0; i < data.rows.length; i++) {
            var article = data.rows[i];
            $('#tableData').append(templateList(web_path + ajax_url.article + '/' + article.articleId, article.articleTitle, article.articleDateStr));
        }
    }

    /**
     * 列表模板
     * @param url
     * @param title
     * @param articleDate
     * @returns {string}
     */
    function templateList(url, title, articleDate) {
        return " <li class=\"list-li\">" +
            "<div class=\"row\">" +
            "<div class=\"col-md-9\">" +
            "<span class=\"glyphicon glyphicon-play\" style=\"padding-right:5px;\"></span>" +
            "<a style=\"font-size: 14px;color: #333;\" href=\"" + url + "\">" + titleListWordLimit(title) + "</a>" +
            "</div>" +
            "<div class=\"col-md-3 text-right\">" +
            "<span style=\"font-size: 14px;color: #666;\">" + articleDate + "</span>" +
            "</div>" +
            "</div>" +
            "</li>";
    }

    /**
     * 列表标题字数限制
     * @param title
     * @returns {*}
     */
    function titleListWordLimit(title) {
        var words;
        if (init_page_param.language === 'zh_cn') {
            words = 40;
        } else {
            words = 50;
        }
        if (title.length > words) {
            title = title.substring(0, words) + "..."
        }
        return title;
    }

    /**
     * 创建分页
     * @param data 数据
     */
    function createPage(data) {
        $('#pagination').pagination({
            pages: getTotalPages(data),
            displayedPages: getDisplayedPages(data),
            hrefTextPrefix: '',
            prevText: init_page_param.language === 'zh_cn' ? '上一页' : 'Previous',
            nextText: init_page_param.language === 'zh_cn' ? '下一页' : 'Next',
            cssStyle: '',
            listStyle: 'pagination',
            onPageClick: function (pageNumber, event) {
                // Callback triggered when a page is clicked
                // Page number is given as an optional parameter
                nextPage(pageNumber);
            }
        });
    }

    /**
     * 获取显示按钮数
     * @param data
     * @returns {*|number}
     */
    function getDisplayedPages(data) {
        var displayedPages = 0;
        if (data.total > 3 || data.total === 1) {
            displayedPages = 3
        } else {
            displayedPages = data.total
        }
        return displayedPages
    }

    /**
     * 获取总页数
     * @param data
     * @returns {number}
     */
    function getTotalPages(data) {
        return data.total % data.pageSize === 0 ? data.total / data.pageSize : Math.ceil(data.total / data.pageSize);
    }

    /**
     * 下一页
     * @param pageNumber 当前页
     */
    function nextPage(pageNumber) {
        param.pageNumber = pageNumber;
        $.get(web_path + ajax_url.data_url + '/' + init_page_param.menuId, param, function (data) {
            listData(data);
        });
    }
});