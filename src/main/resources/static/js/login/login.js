/**
 * Created by zbeboy 2018-04-10 .
 **/
(function ($) {
    /*
     ajax url
    */
    var ajax_url = {
        login: '/login',
        backstage: '/web/backstage'
    };

    /*
     参数id
    */
    var paramId = {
        username: '#username',
        password: '#password',
        btnLogin: '#login'
    };

    /*
     参数
     */
    var param = {
        username: $(paramId.username).val().trim(),
        password: $(paramId.password).val().trim()
    };

    /**
     * 初始化参数
     */
    function initParam() {
        param.username = $(paramId.username).val().trim();
        param.password = $(paramId.password).val().trim();
    }

    /*
     检验正则
    */
    var valid_regex = {
        password_regex: /^[a-zA-Z0-9]\w{5,17}$/
    };

    /*
    检验id
    */
    var validId = {
        username: '#valid_username',
        password: '#valid_password'
    };

    /*
     错误消息id
     */
    var errorMsgId = {
        username: '#username_error_msg',
        password: '#password_error_msg'
    };

    /*
     消息
    */
    var msg = {
        username: '账号不正确',
        password: '密码不正确'
    };

    /**
     * 检验成功
     * @param validId
     * @param errorMsgId
     */
    function validSuccessDom(validId, errorMsgId) {
        $(validId).removeClass('has-error');
        $(errorMsgId).addClass('hidden').text('');
    }

    /**
     * 检验失败
     * @param validId
     * @param errorMsgId
     * @param msg
     */
    function validErrorDom(validId, errorMsgId, msg) {
        $(validId).addClass('has-error');
        $(errorMsgId).removeClass('hidden').text(msg);
    }

    /**
     * 开始加载
     */
    function startLoading() {
        $(paramId.btnLogin).attr('disabled', true).text('登录中...');
    }

    /**
     * 结束加载
     */
    function endLoading() {
        $(paramId.btnLogin).attr('disabled', false).text('登 录');
    }

    $(paramId.password).blur(function () {
        initParam();
        var password = param.password;
        if (valid_regex.password_regex.test(password)) {
            validSuccessDom(validId.password, errorMsgId.password);
        }
    });

    $(paramId.btnLogin).click(function () {
        validUsername();
    });

    $(paramId.username).keyup(function (event) {
        if (event.keyCode === 13) {
            validUsername();
        }
    });

    $(paramId.password).keyup(function (event) {
        if (event.keyCode === 13) {
            validUsername();
        }
    });

    function validUsername() {
        initParam();
        var username = param.username;
        if (username === '') {
            validErrorDom(validId.username, errorMsgId.username, msg.username);
        } else {
            validSuccessDom(validId.username, errorMsgId.username);
            validPassword();
        }
    }

    function validPassword() {
        initParam();
        var password = param.password;
        if (!valid_regex.password_regex.test(password)) {
            validErrorDom(validId.password, errorMsgId.password, msg.password);
        } else {
            validSuccessDom(validId.password, errorMsgId.password);
            sendLoginAjax();
        }
    }

    /*
    错误码
    */
    var error_code = {
        AU_ERROR_CODE: '1', // 权限异常
        OK_CODE: '3', // 全部正确
        USERNAME_IS_NOT_EXIST_CODE: '5', // 账号不存在
        PASSWORD_IS_BLANK: '7', // 密码为空
        USERNAME_IS_BLANK: '8', // 邮箱为空
        USERNAME_IS_ENABLES: '10' //  账号已被注销
    };

    function sendLoginAjax() {
        // 显示遮罩
        startLoading();
        $.post(web_path + ajax_url.login, $('#login_form').serialize(), function (data) {
            var p_error_msg = $('#error_msg');
            switch (data) {
                case error_code.AU_ERROR_CODE:
                    p_error_msg.removeClass('hidden').text('密码错误');
                    // 去除遮罩
                    endLoading();
                    break;
                case error_code.OK_CODE:
                    window.location.href = web_path + ajax_url.backstage;
                    break;
                case error_code.USERNAME_IS_NOT_EXIST_CODE:
                    p_error_msg.removeClass('hidden').text('账号不存在');
                    // 去除遮罩
                    endLoading();
                    break;
                case error_code.PASSWORD_IS_BLANK:
                    p_error_msg.removeClass('hidden').text('请填写密码');
                    // 去除遮罩
                    endLoading();
                    break;
                case error_code.USERNAME_IS_BLANK:
                    p_error_msg.removeClass('hidden').text('请填写账号');
                    // 去除遮罩
                    endLoading();
                    break;
                case error_code.USERNAME_IS_ENABLES:
                    p_error_msg.removeClass('hidden').text('您的账号已被注销，请联系管理员');
                    // 去除遮罩
                    endLoading();
                    break;
                default:
                    p_error_msg.removeClass('hidden').text('验证异常');
                    // 去除遮罩
                    endLoading();
            }
        });
    }
})(window.jQuery);