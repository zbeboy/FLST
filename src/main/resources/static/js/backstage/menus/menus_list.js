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

$('#dataTable').bootstrapTable('destroy')
    .bootstrapTable({
        method: "get",  //使用get请求到服务器获取数据
        url: web_path + getAjaxUrl().menus, //获取数据的Servlet地址
        pagination: true, //启动分页
        pageSize: 10,  //每页显示的记录数
        pageNumber: 1, //当前第几页
        sidePagination: "server", //表示服务端请求
        queryParamsType: "undefined",
        queryParams: function queryParams(params) {   //设置查询参数
            params.orderNum = "测试";
            return params;
        },
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
