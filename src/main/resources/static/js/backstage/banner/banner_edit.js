/**
 * Created by zbeboy 2018-04-14 .
 **/
$(document).ready(function () {

    /*
   init message.
   */
    Messenger.options = {
        extraClasses: 'messenger-fixed messenger-on-bottom messenger-on-right',
        theme: 'air'
    };

    /*
     ajax url
    */
    var ajax_url = {
        file_upload_url: '/web/backstage/banner/upload',
        show: '/web/backstage/banner/show',
        del: '/web/backstage/banner/delete',
        update: '/web/backstage/banner/update',
        back: '/web/backstage/banner'
    };

    var picDataArea = $('#pic-data');

    initEditable();

    /**
     * 初始化 editable.
     */
    function initEditable() {
        $('.bannerTitle').editable({
            success: function (response, newValue) {
                if (response.status === 'error') return response.msg; //msg will be shown in editable form
            }
        });
        $('.bannerTitleEn').editable({
            success: function (response, newValue) {
                if (response.status === 'error') return response.msg; //msg will be shown in editable form
            }
        });
        $('.bannerBrief').editable({
            success: function (response, newValue) {
                if (response.status === 'error') return response.msg; //msg will be shown in editable form
            }
        });
        $('.bannerBriefEn').editable({
            success: function (response, newValue) {
                if (response.status === 'error') return response.msg; //msg will be shown in editable form
            }
        });
    }

    /**
     * PIC数据
     * @param data 数据
     */
    function picData(data) {
        var template = Handlebars.compile($("#pic-template").html());
        Handlebars.registerHelper('imgSrc', function () {
            return new Handlebars.SafeString(Handlebars.escapeExpression(web_path + '/' + this.newName));
        });

        Handlebars.registerHelper('bannerId', function () {
            return new Handlebars.SafeString(Handlebars.escapeExpression(data.objectResult));
        });

        Handlebars.registerHelper('updateUrl', function () {
            return new Handlebars.SafeString(Handlebars.escapeExpression(web_path + ajax_url.update));
        });

        picDataArea.prepend(template(data));

        initEditable();
    }

    // 上传组件
    $('#fileupload').fileupload({
        url: web_path + ajax_url.file_upload_url,
        dataType: 'json',
        maxFileSize: 100000000,// 100MB
        acceptFileTypes: /([.\/])(jpg|jpeg|png|gif)$/i,
        formAcceptCharset: 'utf-8',
        messages: {
            acceptFileTypes: '仅支持上传jpg,png,gif等类型文件',
            maxFileSize: '单文件上传仅允许100MB大小'
        },
        submit: function (e, data) {
            data.formData = {menuId: init_page_param.menuId};
        },
        done: function (e, data) {
            picData(data.result);
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

    /*
    返回
    */
    $('#page_back').click(function () {
        window.location.href = web_path + ajax_url.back;
    });

    picDataArea.delegate('.showImg', "click", function () {
        var id = $(this).prev().val();
        show(id, 1, '显示');
    });

    picDataArea.delegate('.hideImg', "click", function () {
        var id = $(this).prev().val();
        show(id, 0, '隐藏');
    });

    picDataArea.delegate('.deleteImg', "click", function () {
        var id = $(this).prev().prev().val();
        del(id);
    });

    function show(id, s, meg) {
        var msg;
        msg = Messenger().post({
            message: "确定" + meg + "banner吗?",
            actions: {
                retry: {
                    label: '确定',
                    phrase: 'Retrying TIME',
                    action: function () {
                        msg.cancel();
                        $.post(web_path + ajax_url.show, {bannerId: id, bannerShow: s}, function (data) {
                            window.location.reload(true);
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

    function del(id) {
        var msg;
        msg = Messenger().post({
            message: "确定删除banner吗?",
            actions: {
                retry: {
                    label: '确定',
                    phrase: 'Retrying TIME',
                    action: function () {
                        msg.cancel();
                        $.post(web_path + ajax_url.del, {bannerId: id}, function (data) {
                            window.location.reload(true);
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

});