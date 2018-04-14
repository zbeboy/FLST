package cn.edu.kmust.flst.web.backstage.users

import cn.edu.kmust.flst.service.system.UsersService
import cn.edu.kmust.flst.service.util.BCryptUtils
import cn.edu.kmust.flst.web.util.AjaxUtils
import cn.edu.kmust.flst.web.vo.backstage.users.UsersPasswordVo
import org.springframework.stereotype.Controller
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.annotation.Resource
import javax.validation.Valid

/**
 * Created by zbeboy 2018-04-14 .
 **/
@Controller
open class UsersController {

    @Resource
    open lateinit var usersService: UsersService

    /**
     * 用户设置
     *
     * @return 用户设置
     */
    @RequestMapping(value = ["/web/backstage/users/setting"], method = [(RequestMethod.GET)])
    fun setting(): String {
        return "backstage/users/users_setting"
    }

    /**
     * 更改密码
     *
     * @param usersPasswordVo 数据
     * @param bindingResult 检验
     * @return true or false
     */
    @RequestMapping(value = ["/web/backstage/users/setting/password"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun settingPassword(@Valid usersPasswordVo: UsersPasswordVo, bindingResult: BindingResult): AjaxUtils<*> {
        val ajaxUtils = AjaxUtils.of<Any>()
        if (!bindingResult.hasErrors()) {
            val newPassword = StringUtils.trimWhitespace(usersPasswordVo.newPassword!!)
            val okPassword = StringUtils.trimWhitespace(usersPasswordVo.okPassword!!)
            if (newPassword == okPassword) {
                val username = usersService.getUsernameFromSession()
                val users = usersService.findByUsername(username!!)
                if (!ObjectUtils.isEmpty(users)) {
                    users!!.password = BCryptUtils.bCryptPassword(okPassword)
                    usersService.update(users)
                    ajaxUtils.success().msg("更新成功")
                } else {
                    ajaxUtils.fail().msg("未发现用户信息")
                }
            } else {
                ajaxUtils.fail().msg("密码不一致")
            }
        } else {
            ajaxUtils.fail().msg("密码为空或格式错误")
        }
        return ajaxUtils
    }
}