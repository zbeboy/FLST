/**
 * Created by zbeboy 2018-04-13 .
 **/

/*
 ajax url
*/
function getAjaxUrl() {
    return {
        articles: '/web/backstage/en/article/data',
        add: '/web/backstage/en/article/add',
        edit: '/web/backstage/en/article/edit',
        del: '/web/backstage/en/article/delete'
    };
}

/*
参数id
*/
function getParamId() {
    return {
        articleTitle: '#articleTitle',
        menuName: '#menuName'
    };
}

/*
参数
*/
var param = {
    articleTitle: '',
    menuName: ''
};

var dataTable = $('#dataTable');

dataTable.bootstrapTable('destroy')
    .bootstrapTable({
        method: "get",  //使用get请求到服务器获取数据
        url: web_path + getAjaxUrl().articles, //获取数据的Servlet地址
        pagination: true, //启动分页
        pageSize: 10,  //每页显示的记录数
        pageNumber: 1, //当前第几页
        sidePagination: "server", //表示服务端请求
        toolbar: "#toolbar",
        queryParamsType: "undefined",
        queryParams:function(params){
            params.extraSearch = JSON.stringify(param);
            return params;
        },
        search: false,
        onLoadError: function () {  //加载失败时执行
            Messenger().post({
                message: '加载数据失败！',
                type: 'error',
                id: 'menuFail',
                showCloseButton: true
            });
        }
    });

// 预编译模板
var template = Handlebars.compile($("#operator_button").html());

function operation(value, row, index, field) {
    var context = {
        func: [
            {
                "name": "编辑",
                "css": "edit",
                "type": "primary",
                "id": row.articleId,
                "article": row.articleTitle
            },
            {
                "name": "删除",
                "css": "del",
                "type": "danger",
                "id": row.articleId,
                "article": row.articleTitle
            }
        ]
    };
    return template(context);
}

/*
初始化参数
*/
function initParam() {
    param.articleTitle = $(getParamId().articleTitle).val();
    param.menuName = $(getParamId().menuName).val();
}

/*
清空参数
*/
function cleanParam() {
    $(getParamId().articleTitle).val('');
    $(getParamId().menuName).val('');
}

/*
刷新数据
 */
function refreshTable() {
    dataTable.bootstrapTable('refresh', {
        silent: true,
        query: {
            extraSearch: JSON.stringify(param)
        }
    });
}

function del(id, name) {
    var msg;
    msg = Messenger().post({
        message: "确定删除文章 '" + name + "'  吗?",
        actions: {
            retry: {
                label: '确定',
                phrase: 'Retrying TIME',
                action: function () {
                    msg.cancel();
                    $.post(web_path + getAjaxUrl().del, {articleId: id}, function (data) {
                        refreshTable();
                        Messenger().post({
                            message: data.msg,
                            type: data.state ? 'info' : 'error',
                            showCloseButton: true
                        });
                    });
                }
            },
            cancel: {
                label: '取消',
                action: function () {
                    return msg.cancel();
                }
            }
        }
    });
}

$(document).ready(function () {
    /*
    init message.
    */
    Messenger.options = {
        extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-right',
        theme: 'air'
    };

    $('#search').click(function () {
        initParam();
        refreshTable();
    });

    $('#reset_search').click(function () {
        cleanParam();
        initParam();
        refreshTable();
    });

    $('#add').click(function () {
        window.location.href = web_path + getAjaxUrl().add;
    });

    dataTable.delegate('.edit', "click", function () {
        window.location.href = web_path + getAjaxUrl().edit + '/' + $(this).attr('data-id');
    });

    dataTable.delegate('.del', "click", function () {
        del($(this).attr('data-id'), $(this).attr('data-article'));
    });

    $(getParamId().articleTitle).keyup(function (event) {
        if (event.keyCode === 13) {
            initParam();
            refreshTable();
        }
    });

    $(getParamId().menuName).keyup(function (event) {
        if (event.keyCode === 13) {
            initParam();
            refreshTable();
        }
    });
});