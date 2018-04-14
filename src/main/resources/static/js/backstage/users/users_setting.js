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
        changePassword: '/web/backstage/users/setting/password'
    };

    /*
     参数id
    */
    var paramId = {
        newPassword: '#newPassword',
        okPassword: '#okPassword'
    };

    /*
    参数
    */
    var param = {
        newPassword: $(paramId.newPassword).val(),
        okPassword: $(paramId.okPassword).val()
    };

    /**
     * 初始化参数
     */
    function initParam() {
        param.newPassword = $(paramId.newPassword).val();
        param.okPassword = $(paramId.okPassword).val();
    }

    /*
   检验id
   */
    var validId = {
        newPassword: '#valid_new_password',
        okPassword: '#valid_ok_password'
    };

    /*
     错误消息id
     */
    var errorMsgId = {
        newPassword: '#new_password_error_msg',
        okPassword: '#ok_password_error_msg'
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
     * 清除检验
     * @param validId
     * @param errorMsgId
     */
    function validCleanDom(validId, errorMsgId) {
        $(validId).removeClass('has-error').removeClass('has-success');
        $(errorMsgId).removeClass('hidden').text('');
    }

    /*
    检验正则
    */
    var valid_regex = {
        password_regex: /^[a-zA-Z0-9]\w{5,17}$/
    };

    var hasError = false;
    $(paramId.newPassword).blur(function () {
        initParam();
        var newPassword = param.newPassword;
        if (valid_regex.password_regex.test(newPassword)) {
            hasError = false;
            validSuccessDom(validId.newPassword, errorMsgId.newPassword);
        } else {
            hasError = true;
            validErrorDom(validId.newPassword, errorMsgId.newPassword, "密码为大小写字母或数字6~17位")
        }
    });

    $(paramId.okPassword).blur(function () {
        if (!hasError) {
            initParam();
            var okPassword = param.okPassword;
            var newPassword = param.newPassword;
            if (okPassword === newPassword) {
                if (valid_regex.password_regex.test(okPassword)) {
                    validSuccessDom(validId.okPassword, errorMsgId.okPassword);
                } else {
                    validErrorDom(validId.okPassword, errorMsgId.okPassword, "密码为大小写字母或数字6~17位")
                }
            } else {
                validErrorDom(validId.okPassword, errorMsgId.okPassword, "密码不一致");
            }
        }
    });

    $('#passwordCancel').click(function () {
        validCleanDom(validId.newPassword, errorMsgId.newPassword);
        validCleanDom(validId.okPassword, errorMsgId.okPassword);
        $(paramId.newPassword).val('');
        $(paramId.okPassword).val('');
        $('#changePasswordModal').modal('hide');
    });

    $('#passwordSave').click(function () {
        ok();
    });

    /*
    确认询问
    */
    function ok() {
        initParam();
        var msg;
        msg = Messenger().post({
            message: "确定更改密码吗?",
            actions: {
                retry: {
                    label: '确定',
                    phrase: 'Retrying TIME',
                    action: function () {
                        msg.cancel();
                        validPassword();
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

    function validPassword() {
        var okPassword = param.okPassword;
        var newPassword = param.newPassword;
        if (valid_regex.password_regex.test(newPassword)) {
            if (okPassword === newPassword) {
                sendAjax();
            } else {
                Messenger().post({
                    message: '密码不一致',
                    type: 'error',
                    showCloseButton: true
                });
            }
        } else {
            Messenger().post({
                message: '密码为大小写字母或数字6~17位',
                type: 'error',
                showCloseButton: true
            });
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
            url: web_path + ajax_url.changePassword,
            type: 'post',
            data: param,
            success: function (data) {
                if (data.state) {
                    $('#logout').submit();
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