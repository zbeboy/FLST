/**
 * Created by zbeboy 2018-04-11 .
 **/

/*
 ajax url
*/
function getAjaxUrl() {
    return {
        menus: '/web/backstage/menus/data',
        add: '/web/backstage/menus/add',
        edit: '/web/backstage/menus/edit',
        show: '/web/backstage/menus/show'
    };
}

/*
参数id
*/
function getParamId() {
    return {
        menuName: '#menuName',
        menuNameEn: '#menuNameEn',
        menuPidName: '#menuPidName'
    };
}

/*
参数
*/
var param = {
    menuName: '',
    menuNameEn: '',
    menuPidName: ''
};

var dataTable = $('#dataTable');

dataTable.bootstrapTable('destroy')
    .bootstrapTable({
        method: "get",  //使用get请求到服务器获取数据
        url: web_path + getAjaxUrl().menus, //获取数据的Servlet地址
        pagination: true, //启动分页
        pageSize: 10,  //每页显示的记录数
        pageNumber: 1, //当前第几页
        sidePagination: "server", //表示服务端请求
        toolbar: "#toolbar",
        queryParamsType: "undefined",
        queryParams: function (params) {
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

function formatterOutLink(value, row, index, field) {
    if (value === 1) {
        return "是";
    }
    return "否";
}

function formatterShow(value, row, index, field) {
    if (value === 1) {
        return "是";
    }
    return "否";
}

function formatterPidName(value, row, index, field) {
    if (!value) {
        return "无";
    }
    return value;
}

function formatterShowArticle(value, row, index, field) {
    if (value === 1) {
        return "是";
    }
    return "否";
}

// 预编译模板
var template = Handlebars.compile($("#operator_button").html());

function operation(value, row, index, field) {
    var context;

    if (row.menuPid === init_page_param.homeId || row.menuId === init_page_param.homeId) {
        context = {
            func: [
                {
                    "name": row.menuShow === 1 ? "隐藏" : "显示",
                    "css": "show",
                    "type": row.menuShow === 1 ? "default" : "warning",
                    "id": row.menuId,
                    "show": row.menuShow === 1 ? 0 : 1,
                    "menu": row.menuName
                }
            ]
        };
    } else {
        context = {
            func: [
                {
                    "name": "编辑",
                    "css": "edit",
                    "type": "primary",
                    "id": row.menuId,
                    "show": row.menuShow === 1 ? 0 : 1,
                    "menu": row.menuName
                },
                {
                    "name": row.menuShow === 1 ? "隐藏" : "显示",
                    "css": "show",
                    "type": row.menuShow === 1 ? "default" : "warning",
                    "id": row.menuId,
                    "show": row.menuShow === 1 ? 0 : 1,
                    "menu": row.menuName
                }
            ]
        };
    }

    return template(context);
}

/*
初始化参数
*/
function initParam() {
    param.menuName = $(getParamId().menuName).val();
    param.menuNameEn = $(getParamId().menuNameEn).val();
    param.menuPidName = $(getParamId().menuPidName).val();
}

/*
清空参数
*/
function cleanParam() {
    $(getParamId().menuName).val('');
    $(getParamId().menuNameEn).val('');
    $(getParamId().menuPidName).val('');
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

function show(id, name, s, meg) {
    var msg;
    msg = Messenger().post({
        message: "确定" + meg + "栏目 '" + name + "'  吗?",
        actions: {
            retry: {
                label: '确定',
                phrase: 'Retrying TIME',
                action: function () {
                    msg.cancel();
                    $.post(web_path + getAjaxUrl().show, {menuId: id, menuShow: s}, function (data) {
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

    dataTable.delegate('.show', "click", function () {
        show($(this).attr('data-id'), $(this).attr('data-menu'), $(this).attr('data-show'),
            Number($(this).attr('data-show')) === 1 ? '显示' : '隐藏');
    });

    $(getParamId().menuName).keyup(function (event) {
        if (event.keyCode === 13) {
            initParam();
            refreshTable();
        }
    });

    $(getParamId().menuNameEn).keyup(function (event) {
        if (event.keyCode === 13) {
            initParam();
            refreshTable();
        }
    });

    $(getParamId().menuPidName).keyup(function (event) {
        if (event.keyCode === 13) {
            initParam();
            refreshTable();
        }
    });
});