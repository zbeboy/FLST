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
        pids: '/web/backstage/menus/pids',
        file_upload_url: '/web/backstage/article/cover/upload',
        images: '/user/images',
        update: '/web/backstage/en/article/update',
        back: '/web/backstage/en/article'
    };

    /*
     参数id
    */
    var paramId = {
        articleId: '#articleId',
        menuId: '#menuId',
        articleTitle: '#articleTitle',
        articleBrief: '#articleBrief',
        articleCover: '#articleCover',
        articleCoverTemp: '#articleCoverTemp',
        articleSources: '#articleSources',
        articleSourcesName: '#articleSourcesName',
        articleSourcesLink: '#articleSourcesLink'
    };

    /*
    参数
    */
    var param = {
        articleId: $(paramId.articleId).val(),
        menuId: $(paramId.menuId).val(),
        articleTitle: $(paramId.articleTitle).val(),
        articleBrief: $(paramId.articleBrief).val(),
        articleCover: $(paramId.articleCover).val(),
        articleContent: '',
        articleSources: $("input[name='articleSources']:checked").val(),
        articleSourcesName: $(paramId.articleSourcesName).val(),
        articleSourcesLink: $(paramId.articleSourcesLink).val()
    };

    var IMG = "data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMzE5IiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDMxOSAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTYyYmUyMDgyYWQgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxNnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNjJiZTIwODJhZCI+PHJlY3Qgd2lkdGg9IjMxOSIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSIxMTcuOTg0Mzc1IiB5PSIxMDcuMiI+MzE5eDIwMDwvdGV4dD48L2c+PC9nPjwvc3ZnPg==";

    init();

    function init() {
        $.get(web_path + ajax_url.pids, function (data) {
            pidData(data);
        });
        $(paramId.articleCoverTemp).attr('src', web_path + ajax_url.images + '/' + $(paramId.articleCover).val());
        initQuill();
        if (init_page_param.articleSources === 0) {
            $('#original').prop('checked', true);
        } else {
            $('#other').prop('checked', true);
            $(paramId.articleSourcesName).attr('type', 'text');
            $(paramId.articleSourcesLink).attr('type', 'text');
        }
    }

    var quill;

    function initQuill() {
        quill = new Quill('#editor-container', {
            modules: {
                formula: true,
                syntax: true,
                toolbar: '#toolbar-container'
            },
            placeholder: '内容',
            theme: 'snow'
        });
        quill.setContents(JSON.parse(init_page_param.articleContent));
    }

    /**
     * 初始化参数
     */
    function initParam() {
        param.articleId = $(paramId.articleId).val();
        param.menuId = $(paramId.menuId).val();
        param.articleTitle = $(paramId.articleTitle).val();
        param.articleBrief = $(paramId.articleBrief).val();
        param.articleCover = $(paramId.articleCover).val();
        param.articleContent = JSON.stringify(quill.getContents());
        param.articleSources = $("input[name='articleSources']:checked").val();
        param.articleSourcesName = $(paramId.articleSourcesName).val();
        param.articleSourcesLink = $(paramId.articleSourcesLink).val();
    }

    /*
   检验id
   */
    var validId = {
        articleTitle: '#valid_article_title'
    };

    /*
     错误消息id
     */
    var errorMsgId = {
        articleTitle: '#article_title_error_msg'
    };

    /**
     * 检验成功
     * @param validId
     * @param errorMsgId
     */
    function validSuccessDom(validId, errorMsgId) {
        $(validId).addClass('has-success').removeClass('has-error');
        $(errorMsgId).addClass('hidden').text('');
    }

    /**
     * 检验失败
     * @param validId
     * @param errorMsgId
     * @param msg
     */
    function validErrorDom(validId, errorMsgId, msg) {
        $(validId).addClass('has-error').removeClass('has-success');
        $(errorMsgId).removeClass('hidden').text(msg);
    }

    /**
     * PID数据
     * @param data 数据
     */
    function pidData(data) {
        var template = Handlebars.compile($("#pid-template").html());
        $(paramId.menuId).append(template(data));
        $(paramId.menuId).val($('#menuIdX').val());
        $(paramId.menuId).selectpicker('refresh');
    }

    // 上传组件
    $('#fileupload').fileupload({
        url: web_path + ajax_url.file_upload_url,
        dataType: 'json',
        maxFileSize: 100000000,// 100MB
        acceptFileTypes: /([.\/])(jpg|jpeg|png|gif)$/i,
        formAcceptCharset: 'utf-8',
        maxNumberOfFiles: 1,
        messages: {
            maxNumberOfFiles: '最大支持上传1个文件',
            acceptFileTypes: '仅支持上传jpg,png,gif等类型文件',
            maxFileSize: '单文件上传仅允许100MB大小'
        },
        done: function (e, data) {
            if (data.result.listResult.length > 0) {
                $(paramId.articleCoverTemp).attr('src', web_path + ajax_url.images + '/' + data.result.listResult[0].newName);
                $(paramId.articleCover).val(data.result.listResult[0].newName);
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

    $('#clearImg').click(function () {
        $(paramId.articleCoverTemp).attr('src', IMG);
        $(paramId.articleCover).val('');
    });

    $(paramId.articleTitle).blur(function () {
        initParam();
        var articleTitle = param.articleTitle;
        if (articleTitle.length <= 0 || articleTitle.length > 200) {
            validErrorDom(validId.articleTitle, errorMsgId.articleTitle, '标题200个字符以内');
        } else {
            validSuccessDom(validId.articleTitle, errorMsgId.articleTitle);
        }
    });

    $('#original').click(function () {
        $(paramId.articleSourcesName).attr('type', 'hidden');
        $(paramId.articleSourcesLink).attr('type', 'hidden');
        $(paramId.articleSourcesName).val('');
        $(paramId.articleSourcesLink).val('');
    });

    $('#other').click(function () {
        $(paramId.articleSourcesName).attr('type', 'text');
        $(paramId.articleSourcesLink).attr('type', 'text');
    });

    /*
    返回
    */
    $('#page_back').click(function () {
        window.location.href = web_path + ajax_url.back;
    });

    /*
     保存数据
     */
    $('#save').click(function () {
        add();
    });

    /*
     添加询问
     */
    function add() {
        initParam();
        var articleTitle = param.articleTitle;
        var msg;
        msg = Messenger().post({
            message: "确定更新文章 '" + articleTitle + "'  吗?",
            actions: {
                retry: {
                    label: '确定',
                    phrase: 'Retrying TIME',
                    action: function () {
                        msg.cancel();
                        validArticleTitle();
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

    /**
     * 添加时检验并提交数据
     */
    function validArticleTitle() {
        var articleTitle = param.articleTitle;
        if (articleTitle.length <= 0 || articleTitle.length > 200) {
            Messenger().post({
                message: '栏目中文名1~200个字符',
                type: 'error',
                showCloseButton: true
            });
        } else {
            validArticleCover();
        }
    }

    function validArticleCover() {
        var articleCover = param.articleCover;
        if (articleCover.length <= 0) {
            Messenger().post({
                message: '请上传封面',
                type: 'error',
                showCloseButton: true
            });
        } else {
            validArticleContent();
        }
    }

    function validArticleContent() {
        var articleContent = quill.getText(0, quill.getLength());
        if (articleContent.length <= 1) {
            Messenger().post({
                message: '请填写内容',
                type: 'error',
                showCloseButton: true
            });
        } else {
            validArticleSource();
        }
    }

    function validArticleSource() {
        var articleSources = param.articleSources;
        if (Number(articleSources) === 1) {
            var articleSourcesName = param.articleSourcesName;
            if (articleSourcesName.length <= 0) {
                Messenger().post({
                    message: '请填写来源',
                    type: 'error',
                    showCloseButton: true
                });
                return;
            }
        }
        sendAjax();
    }

    /**
     * 发送数据到后台
     */
    function sendAjax() {
        Messenger().run({
            successMessage: '保存数据成功',
            errorMessage: '保存数据失败',
            progressMessage: '正在保存数据....'
        }, {
            url: web_path + ajax_url.update,
            type: 'post',
            data: param,
            success: function (data) {
                if (data.state) {
                    window.location.href = web_path + ajax_url.back;
                } else {
                    Messenger().post({
                        message: data.msg,
                        type: 'error',
                        showCloseButton: true
                    });
                }
            },
            error: function (xhr) {
                if ((xhr != null ? xhr.status : void 0) === 404) {
                    return "请求失败";
                }
                return true;
            }
        });
    }
});