/**
 * Created by zbeboy 2018-04-16 .
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
        update: '/web/backstage/links/update',
        back: '/web/backstage/links'
    };

    /*
     参数id
    */
    var paramId = {
        linkId:'#linkId',
        linkName: '#linkName',
        linkNameEn: '#linkNameEn',
        linkUrl: '#linkUrl',
        linkShow: '#linkShow'
    };

    /*
    参数
    */
    var param = {
        linkId:$(paramId.linkId).val(),
        linkName: $(paramId.linkName).val(),
        linkNameEn: $(paramId.linkNameEn).val(),
        linkUrl: $(paramId.linkUrl).val(),
        linkShow: $('input[name="linkShow"]:checked').val()
    };

    /**
     * 初始化参数
     */
    function initParam() {
        param.linkId = $(paramId.linkId).val();
        param.linkName = $(paramId.linkName).val();
        param.linkNameEn = $(paramId.linkNameEn).val();
        param.linkUrl = $(paramId.linkUrl).val();
        param.linkShow = $('input[name="linkShow"]:checked').val();
        if (typeof(param.linkShow) === "undefined") {
            param.linkShow = 0;
        }
    }

    /*
   检验id
   */
    var validId = {
        linkName: '#valid_link_name',
        linkNameEn: '#valid_link_name_en',
        linkUrl: '#valid_link_url'
    };

    /*
     错误消息id
     */
    var errorMsgId = {
        linkName: '#link_name_error_msg',
        linkNameEn: '#link_name_en_error_msg',
        linkUrl: '#link_url_error_msg'
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

    $(paramId.linkName).blur(function () {
        initParam();
        var linkName = param.linkName;
        if (linkName.length <= 0 || linkName.length > 100) {
            validErrorDom(validId.linkName, errorMsgId.linkName, '链接中文名100个字符以内');
        } else {
            validSuccessDom(validId.linkName, errorMsgId.linkName);
        }
    });

    $(paramId.linkNameEn).blur(function () {
        initParam();
        var linkNameEn = param.linkNameEn;
        if (linkNameEn.length <= 0 || linkNameEn.length > 200) {
            validErrorDom(validId.linkNameEn, errorMsgId.linkNameEn, '链接英文名200个字符以内');
        } else {
            validSuccessDom(validId.linkNameEn, errorMsgId.linkNameEn);
        }
    });

    $(paramId.linkUrl).blur(function () {
        initParam();
        var linkUrl = param.linkUrl;
        if (linkUrl.length <= 0 || linkUrl.length > 200) {
            validErrorDom(validId.linkUrl, errorMsgId.linkUrl, '链接200个字符以内');
        } else {
            validSuccessDom(validId.linkUrl, errorMsgId.linkUrl);
        }
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
        var linkName = param.linkName;
        var msg;
        msg = Messenger().post({
            message: "确定更新链接 '" + linkName + "'  吗?",
            actions: {
                retry: {
                    label: '确定',
                    phrase: 'Retrying TIME',
                    action: function () {
                        msg.cancel();
                        validLinkName();
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
    function validLinkName() {
        var linkName = param.linkName;
        if (linkName.length <= 0 || linkName.length > 100) {
            Messenger().post({
                message: '链接中文名1~100个字符',
                type: 'error',
                showCloseButton: true
            });
        } else {
            validLinkNameEn();
        }
    }

    function validLinkNameEn() {
        var linkNameEn = param.linkNameEn;
        if (linkNameEn.length <= 0 || linkNameEn.length > 200) {
            Messenger().post({
                message: '链接英文名1~200个字符',
                type: 'error',
                showCloseButton: true
            });
        } else {
            validLinkUrl();
        }
    }

    function validLinkUrl() {
        var linkUrl = param.linkUrl;
        if (linkUrl.length <= 0 || linkUrl.length > 200) {
            Messenger().post({
                message: '链接1~200个字符',
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