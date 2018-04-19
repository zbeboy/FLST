$(document).ready(function () {
    /*
    ajax url.
    */
    var ajax_url = {
        data_url: '/data/search',
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
        extraSearch: JSON.stringify({articleTitle: $('#searchContent').val()})
    };

    init();

    /**
     * 初始化数据
     */
    function init() {
        $.get(web_path + ajax_url.data_url, param, function (data) {
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
            $('#tableData').append(templateList(web_path + ajax_url.article + '/' + article.articleId, article.articleTitle, article.articleBrief));
        }
    }

    /**
     * 列表模板
     * @param url
     * @param title
     * @param brief
     * @returns {string}
     */
    function templateList(url, title, brief) {
        return " <a href=\"" + url + "\" class=\"list-group-item\">" +
            "<h4 class=\"list-group-item-heading\">" + title + "</h4>" +
            "<p class=\"list-group-item-text\">" + brief + "</p>" +
            "</a>";
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
        $.get(web_path + ajax_url.data_url, param, function (data) {
            listData(data);
        });
    }
});