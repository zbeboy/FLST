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
        images: '/user/images',
        back: '/web/backstage/banner'
    };

    var picDataArea = $('#pic-data');

    /**
     * PIC数据
     * @param data 数据
     */
    function picData(data) {
        var template = Handlebars.compile($("#pic-template").html());
        Handlebars.registerHelper('imgSrc', function () {
            return new Handlebars.SafeString(Handlebars.escapeExpression(web_path + ajax_url.images + '/' + this.newName));
        });
        Handlebars.registerHelper('type', function () {
            return new Handlebars.SafeString(Handlebars.escapeExpression(data.objectResult === 0 ? 'warning' : 'default'));
        });

        Handlebars.registerHelper('show', function () {
            return new Handlebars.SafeString(Handlebars.escapeExpression(data.objectResult === 0 ? '显示' : '隐藏'));
        });

        Handlebars.registerHelper('css', function () {
            return new Handlebars.SafeString(Handlebars.escapeExpression(data.objectResult === 0 ? 'showImg' : 'hideImg'));
        });
        picDataArea.prepend(template(data));
    }

    // 上传组件
    $('#fileupload').fileupload({
        url: web_path + ajax_url.file_upload_url,
        dataType: 'json',
        maxFileSize: 100000000,// 100MB
        acceptFileTypes: /([.\/])(jpg|jpeg|png|gif)$/i,
        formAcceptCharset: 'utf-8',
        messages: {
            maxNumberOfFiles: '最大支持上传1个文件',
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

});