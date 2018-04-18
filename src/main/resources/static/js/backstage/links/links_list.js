/**
 * Created by zbeboy 2018-04-15 .
 **/
/*
 ajax url
*/
function getAjaxUrl() {
    return {
        links: '/web/backstage/links/data',
        add: '/web/backstage/links/add',
        edit: '/web/backstage/links/edit',
        del: '/web/backstage/links/delete',
        show: '/web/backstage/links/show'
    };
}

/*
参数id
*/
function getParamId() {
    return {
        linkName: '#linkName',
        linkNameEn: '#linkNameEn'
    };
}

/*
参数
*/
var param = {
    linkName: '',
    linkNameEn: ''
};

var dataTable = $('#dataTable');

dataTable.bootstrapTable('destroy')
    .bootstrapTable({
        method: "get",  //使用get请求到服务器获取数据
        url: web_path + getAjaxUrl().links, //获取数据的Servlet地址
        pagination: true, //启动分页
        pageSize: 10,  //每页显示的记录数
        pageNumber: 1, //当前第几页
        sidePagination: "server", //表示服务端请求
        toolbar: "#toolbar",
        queryParamsType: "undefined",
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

function formatterShow(value, row, index, field) {
    if (value === 1) {
        return "是";
    }
    return "否";
}

// 预编译模板
var template = Handlebars.compile($("#operator_button").html());

function operation(value, row, index, field) {
    var context = {
        func: [
            {
                "name": "编辑",
                "css": "edit",
                "type": "primary",
                "id": row.linkId,
                "show": row.linkShow === 1 ? 0 : 1,
                "link": row.linkName
            },
            {
                "name": "删除",
                "css": "del",
                "type": "danger",
                "id": row.linkId,
                "show": row.linkShow === 1 ? 0 : 1,
                "link": row.linkName
            },
            {
                "name": row.linkShow === 1 ? "隐藏" : "显示",
                "css": "show",
                "type": row.linkShow === 1 ? "default" : "warning",
                "id": row.linkId,
                "show": row.linkShow === 1 ? 0 : 1,
                "link": row.linkName
            }
        ]
    };
    return template(context);
}

/*
初始化参数
*/
function initParam() {
    param.linkName = $(getParamId().linkName).val();
    param.linkNameEn = $(getParamId().linkNameEn).val();
}

/*
清空参数
*/
function cleanParam() {
    $(getParamId().linkName).val('');
    $(getParamId().linkNameEn).val('');
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
        message: "确定删除链接 '" + name + "'  吗?",
        actions: {
            retry: {
                label: '确定',
                phrase: 'Retrying TIME',
                action: function () {
                    msg.cancel();
                    $.post(web_path + getAjaxUrl().del, {linkId: id}, function (data) {
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

function show(id, name, s, meg) {
    var msg;
    msg = Messenger().post({
        message: "确定" + meg + "链接 '" + name + "'  吗?",
        actions: {
            retry: {
                label: '确定',
                phrase: 'Retrying TIME',
                action: function () {
                    msg.cancel();
                    $.post(web_path + getAjaxUrl().show, {linkId: id, linkShow: s}, function (data) {
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
        del($(this).attr('data-id'), $(this).attr('data-link'));
    });

    dataTable.delegate('.show', "click", function () {
        show($(this).attr('data-id'), $(this).attr('data-link'), $(this).attr('data-show'),
            Number($(this).attr('data-show')) === 1 ? '显示' : '隐藏');
    });

    $(getParamId().linkName).keyup(function (event) {
        if (event.keyCode === 13) {
            initParam();
            refreshTable();
        }
    });

    $(getParamId().linkNameEn).keyup(function (event) {
        if (event.keyCode === 13) {
            initParam();
            refreshTable();
        }
    });
});