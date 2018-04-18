/**
 * Created by zbeboy 2018-04-14 .
 **/
/*
 ajax url
*/
function getAjaxUrl() {
    return {
        banners: '/web/backstage/banner/data',
        edit: '/web/backstage/banner/edit'
    };
}

/*
参数id
*/
function getParamId() {
    return {
        menuName: '#menuName',
        menuNameEn: '#menuNameEn'
    };
}

/*
参数
*/
var param = {
    menuName: '',
    menuNameEn: ''
};

var dataTable = $('#dataTable');

dataTable.bootstrapTable('destroy')
    .bootstrapTable({
        method: "get",  //使用get请求到服务器获取数据
        url: web_path + getAjaxUrl().banners, //获取数据的Servlet地址
        pagination: true, //启动分页
        pageSize: 10,  //每页显示的记录数
        pageNumber: 1, //当前第几页
        sidePagination: "server", //表示服务端请求
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
                "id": row.menuId,
                "menu": row.menuName
            }
        ]
    };
    return template(context);
}

/*
初始化参数
*/
function initParam() {
    param.menuName = $(getParamId().menuName).val();
    param.menuNameEn = $(getParamId().menuNameEn).val();
}

/*
清空参数
*/
function cleanParam() {
    $(getParamId().menuName).val('');
    $(getParamId().menuNameEn).val('');
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

    dataTable.delegate('.edit', "click", function () {
        window.location.href = web_path + getAjaxUrl().edit + '/' + $(this).attr('data-id');
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
});