package cn.edu.kmust.flst.web.vo.backstage.users

import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

/**
 * Created by zbeboy 2018-04-14 .
 **/
open class UsersPasswordVo {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]\\w{5,17}$")
    var newPassword: String? = null

    @NotNull
    var okPassword: String? = null
}