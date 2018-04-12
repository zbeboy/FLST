/**
 * Created by zbeboy 2018-04-12 .
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
        update: '/web/backstage/menus/update',
        validName: '/web/backstage/menus/edit/valid/name',
        validNameEn: '/web/backstage/menus/edit/valid/name_en',
        back: '/web/backstage/menus'
    };

    /*
     参数id
    */
    var paramId = {
        menuId: '#menuId',
        menuPid: '#menuPid',
        menuName: '#menuName',
        menuNameEn: '#menuNameEn',
        menuLink: '#menuLink',
        menuLinkEn: '#menuLinkEn',
        menuOrder: '#menuOrder',
        menuShow: '#menuShow'
    };

    /*
    参数
    */
    var param = {
        menuId:$(paramId.menuId).val(),
        menuPid: $(paramId.menuPid).val(),
        menuName: $(paramId.menuName).val(),
        menuNameEn: $(paramId.menuNameEn).val(),
        menuLink: $(paramId.menuLink).val(),
        menuLinkEn: $(paramId.menuLinkEn).val(),
        menuOrder: $(paramId.menuOrder).val(),
        menuShow: $('input[name="menuShow"]:checked').val()
    };

    init();

    function init() {
        $.get(web_path + ajax_url.pids, function (data) {
            pidData(data);
        });
    }

    /**
     * 初始化参数
     */
    function initParam() {
        param.menuId = $(paramId.menuId).val();
        param.menuPid = $(paramId.menuPid).val();
        param.menuName = $(paramId.menuName).val();
        param.menuNameEn = $(paramId.menuNameEn).val();
        param.menuLink = $(paramId.menuLink).val();
        param.menuLinkEn = $(paramId.menuLinkEn).val();
        param.menuOrder = $(paramId.menuOrder).val();
        param.menuShow = $('input[name="menuShow"]:checked').val();
        if (typeof(param.menuShow) === "undefined") {
            param.menuShow = 0;
        }
    }

    /*
   检验id
   */
    var validId = {
        menuName: '#valid_menu_name',
        menuNameEn: '#valid_menu_name_en',
        menuLink: '#valid_menu_link',
        menuLinkEn: '#valid_menu_link_en',
        menuOrder: '#valid_menu_order'
    };

    /*
     错误消息id
     */
    var errorMsgId = {
        menuName: '#menu_name_error_msg',
        menuNameEn: '#menu_name_en_error_msg',
        menuLink: '#menu_link_error_msg',
        menuLinkEn: '#menu_link_en_error_msg',
        menuOrder: '#menu_order_error_msg'
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
        $(paramId.menuPid).append(template(data));
        $(paramId.menuPid).val($('#menuPidX').val());
        $(paramId.menuPid).selectpicker('refresh');
    }

    $(paramId.menuName).blur(function () {
        initParam();
        var menuName = param.menuName;
        if (menuName.length <= 0 || menuName.length > 20) {
            validErrorDom(validId.menuName, errorMsgId.menuName, '栏目中文名20个字符以内');
        } else {
            // 栏目中文名是否重复
            Messenger().run({
                errorMessage: '请求失败'
            }, {
                url: web_path + ajax_url.validName,
                type: 'post',
                data: param,
                success: function (data) {
                    if (data.state) {
                        validSuccessDom(validId.menuName, errorMsgId.menuName);
                    } else {
                        validErrorDom(validId.menuName, errorMsgId.menuName, data.msg);
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

    $(paramId.menuNameEn).blur(function () {
        initParam();
        var menuNameEn = param.menuNameEn;
        if (menuNameEn.length <= 0 || menuNameEn.length > 50) {
            validErrorDom(validId.menuNameEn, errorMsgId.menuNameEn, '栏目中文名50个字符以内');
        } else {
            // 栏目中文名是否重复
            Messenger().run({
                errorMessage: '请求失败'
            }, {
                url: web_path + ajax_url.validNameEn,
                type: 'post',
                data: param,
                success: function (data) {
                    if (data.state) {
                        validSuccessDom(validId.menuNameEn, errorMsgId.menuNameEn);
                    } else {
                        validErrorDom(validId.menuNameEn, errorMsgId.menuNameEn, data.msg);
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

    $(paramId.menuLink).blur(function () {
        initParam();
        var menuLink = param.menuLink;
        if (menuLink.length <= 0 || menuLink.length > 150) {
            validErrorDom(validId.menuLink, errorMsgId.menuLink, '栏目中文链接150个字符以内');
        } else {
            validSuccessDom(validId.menuLink, errorMsgId.menuLink);
        }
    });

    $(paramId.menuLinkEn).blur(function () {
        initParam();
        var menuLinkEn = param.menuLinkEn;
        if (menuLinkEn.length <= 0 || menuLinkEn.length > 150) {
            validErrorDom(validId.menuLinkEn, errorMsgId.menuLinkEn, '栏目英文链接150个字符以内');
        } else {
            validSuccessDom(validId.menuLinkEn, errorMsgId.menuLinkEn);
        }
    });

    $(paramId.menuOrder).blur(function () {
        initParam();
        var menuOrder = param.menuOrder;
        if (menuOrder.length <= 0) {
            validErrorDom(validId.menuOrder, errorMsgId.menuOrder, '请填写序号');
        } else {
            validSuccessDom(validId.menuOrder, errorMsgId.menuOrder);
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
        var menuName = param.menuName;
        var msg;
        msg = Messenger().post({
            message: "确定更新栏目 '" + menuName + "'  吗?",
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