/*
 ajax url
*/
function getAjaxUrl() {
    return {
        menus: '/web/backstage/files/data',
        del: '/web/backstage/files/delete',
        file_upload_url: '/web/backstage/files/upload'
    };
}

/*
参数id
*/
function getParamId() {
    return {
        originalFileName: '#originalFileName'
    };
}

/*
参数
*/
var param = {
    originalFileName: ''
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

// 预编译模板
var template = Handlebars.compile($("#operator_button").html());

function operation(value, row, index, field) {
    var context = {
        func: [
            {
                "name": "复制链接",
                "css": "copy",
                "type": "default",
                "id": row.fileId,
                "file": row.originalFileName,
                "path": row.downloadPath
            },
            {
                "name": "删除",
                "css": "del",
                "type": "danger",
                "id": row.fileId,
                "file": row.originalFileName,
                "path": row.downloadPath
            }
        ]
    };

    return template(context);
}

/*
初始化参数
*/
function initParam() {
    param.originalFileName = $(getParamId().originalFileName).val();
}

/*
清空参数
*/
function cleanParam() {
    $(getParamId().originalFileName).val('');
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
        message: "确定删除文件 '" + name + "'  吗?",
        actions: {
            retry: {
                label: '确定',
                phrase: 'Retrying TIME',
                action: function () {
                    msg.cancel();
                    $.post(web_path + getAjaxUrl().del, {fileId: id}, function (data) {
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

    $(getParamId().originalFileName).keyup(function (event) {
        if (event.keyCode === 13) {
            initParam();
            refreshTable();
        }
    });

    // 计算次数，以免刷新太快
    var addCount = 0;
    var doneCount = 0;
    // 上传组件
    $('#fileupload').fileupload({
        url: web_path + getAjaxUrl().file_upload_url,
        dataType: 'json',
        maxFileSize: 100000000,// 100MB
        formAcceptCharset: 'utf-8',
        messages: {
            maxFileSize: '单文件上传仅允许100MB大小'
        },
        add: function (e, data) {
            addCount++;
            if (data.autoUpload || (data.autoUpload !== false &&
                $(this).fileupload('option', 'autoUpload'))) {
                data.process().done(function () {
                    data.submit();
                });
            }
        },
        done: function (e, data) {
            doneCount++;
            if (doneCount === addCount) {
                refreshTable();
                addCount = 0;
                doneCount = 0;
            }

            Messenger().post({
                message: data.result.msg,
                type: data.result.state ? 'success' : 'error',
                showCloseButton: true
            });
        }
    }).on('fileuploadadd', function (evt, data) {
        var isOk = true;
        var $this = $(this);
        var validation = data.process(function () {
            return $this.fileupload('process', data);
        });
        validation.fail(function (data) {
            isOk = false;
            Messenger().post({
                message: '上传失败: ' + data.files[0].error,
                type: 'error',
                showCloseButton: true
            });
        });
        return isOk;
    });


    var clipboard = new ClipboardJS('.copy');

    clipboard.on('success', function (e) {
        Messenger().post({
            message: '已复制到剪贴板',
            type: 'success',
            showCloseButton: true
        });
    });

    clipboard.on('error', function (e) {
        Messenger().post({
            message: '复制失败',
            type: 'error',
            showCloseButton: true
        });
    });

    dataTable.delegate('.del', "click", function () {
        del($(this).attr('data-id'), $(this).attr('data-file'));
    });
});