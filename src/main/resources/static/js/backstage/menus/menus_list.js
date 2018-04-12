/**
 * Created by zbeboy 2018-04-11 .
 **/

/*
 ajax url
*/
function getAjaxUrl() {
    return {
        menus: '/web/backstage/menus/data'
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
        search: false,
        onLoadSuccess: function () {  //加载成功时执行
            console.log("加载成功");
        },
        onLoadError: function () {  //加载失败时执行
            console.log("加载数据失败");
        }
    });

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

// 预编译模板
var template = Handlebars.compile($("#operator_button").html());

function operation(value, row, index, field) {
    var context = {
        func: [
            {
                "name": "编辑",
                "css": "edit",
                "type": "primary",
                "id": row.menuId
            },
            {
                "name": row.menuShow === 1 ? "隐藏" : "显示",
                "css": "show",
                "type": "default",
                "id": row.menuId
            },
            {
                "name": "删除",
                "css": "del",
                "type": "danger",
                "id": row.menuId
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
function refreshTable(){
    dataTable.bootstrapTable('refresh', {
        silent: true,
        query: {
            extraSearch:JSON.stringify(param)
        }
    });
}

$(document).ready(function () {
    $('#search').click(function () {
        initParam();
        refreshTable();
    });
    
    $('#reset_search').click(function () {
        cleanParam();
        initParam();
        refreshTable();
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