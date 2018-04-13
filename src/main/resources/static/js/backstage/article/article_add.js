/**
 * Created by zbeboy 2018-04-13 .
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
        file_upload_url:'/web/backstage/article/cover/upload',
        save: '/web/backstage/article/save',
        back: '/web/backstage/article'
    };

    /*
     参数id
    */
    var paramId = {
        menuId: '#menuId',
        articleTitle: '#articleTitle',
        articleBrief: '#articleBrief',
        articleCover: '#articleCover',
        articleContent: '#articleContent',
        articleSources: '#articleSources',
        articleSourcesName: '#articleSourcesName',
        articleSourcesLink: '#articleSourcesLink'
    };

    /*
    参数
    */
    var param = {
        menuId: $(paramId.menuId).val(),
        articleTitle: $(paramId.articleTitle).val(),
        articleBrief: $(paramId.articleBrief).val(),
        articleCover: $(paramId.articleCover).val(),
        articleContent: $(paramId.articleContent).val(),
        articleSourcesName: $(paramId.articleSourcesName).val(),
        articleSourcesLink: $(paramId.articleSourcesLink).val()
    };

    init();

    function init() {
        $.get(web_path + ajax_url.pids, function (data) {
            pidData(data);
        });

        initQuill();
    }

    function initQuill() {
        var quill = new Quill('#editor-container', {
            modules: {
                formula: true,
                syntax: true,
                toolbar: '#toolbar-container'
            },
            placeholder: '内容',
            theme: 'snow'
        });
    }

    /**
     * 初始化参数
     */
    function initParam() {
        param.menuId = $(paramId.menuId).val();
        param.articleTitle = $(paramId.articleTitle).val();
        param.articleBrief = $(paramId.articleBrief).val();
        param.articleCover = $(paramId.articleCover).val();
        param.articleContent = $(paramId.articleContent).val();
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

    $(paramId.articleTitle).blur(function () {
        initParam();
        var articleTitle = param.articleTitle;
        if (articleTitle.length <= 0 || articleTitle.length > 20) {
            validErrorDom(validId.articleTitle, errorMsgId.articleTitle, '标题100个字符以内');
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
        var menuName = param.menuName;
        var msg;
        msg = Messenger().post({
            message: "确定添加栏目 '" + menuName + "'  吗?",
            actions: {
                retry: {
                    label: '确定',
                    phrase: 'Retrying TIME',
                    action: function () {
                        msg.cancel();
                        validMenuName();
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
    function validMenuName() {
        var menuName = param.menuName;
        if (menuName.length <= 0 || menuName.length > 20) {
            Messenger().post({
                message: '栏目中文名1~20个字符',
                type: 'error',
                showCloseButton: true
            });
        } else {
            Messenger().run({
                errorMessage: '请求失败'
            }, {
                url: web_path + ajax_url.validName,
                type: 'post',
                data: param,
                success: function (data) {
                    if (data.state) {
                        validMenuNameEn();
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
    }

    function validMenuNameEn() {
        var menuNameEn = param.menuNameEn;
        if (menuNameEn.length <= 0 || menuNameEn.length > 50) {
            Messenger().post({
                message: '栏目英文名1~50个字符',
                type: 'error',
                showCloseButton: true
            });
        } else {
            Messenger().run({
                errorMessage: '请求失败'
            }, {
                url: web_path + ajax_url.validNameEn,
                type: 'post',
                data: param,
                success: function (data) {
                    if (data.state) {
                        validMenuLink();
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
    }

    function validMenuLink() {
        var menuLink = param.menuLink;
        if (menuLink.length <= 0 || menuLink.length > 150) {
            Messenger().post({
                message: '栏目中文链接1~150个字符',
                type: 'error',
                showCloseButton: true
            });
        } else {
            validMenuLinkEn();
        }
    }

    function validMenuLinkEn() {
        var menuLinkEn = param.menuLinkEn;
        if (menuLinkEn.length <= 0 || menuLinkEn.length > 150) {
            Messenger().post({
                message: '栏目英文链接1~150个字符',
                type: 'error',
                showCloseButton: true
            });
        } else {
            validOrder();
        }
    }

    function validOrder() {
        var menuOrder = param.menuOrder;
        if (menuOrder.length <= 0) {
            Messenger().post({
                message: '请填写栏目序号',
                type: 'error',
                showCloseButton: true
            });
        } else {
            sendAjax();
        }
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
            url: web_path + ajax_url.save,
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