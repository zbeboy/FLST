package cn.edu.kmust.flst.web.vo.backstage.menus

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * Created by zbeboy 2018-04-12 .
 **/
open class MenusEditVo {
    @NotNull
    @Size(max = 64)
    var menuId: String? = null
    @NotNull
    @Size(max = 64)
    var menuPid: String? = null
    @NotNull
    @Size(max = 20)
    var menuName: String? = null
    @NotNull
    @Size(max = 100)
    var menuNameEn: String? = null
    @NotNull
    var outLink: Boolean? = null
    @Size(max = 150)
    var menuLink: String? = null
    @NotNull
    var menuOrder: Int? = null
    var menuShow: Boolean? = null
    var showArticle: Boolean? = null
    @NotNull
    var orderWay: Int? = null
}