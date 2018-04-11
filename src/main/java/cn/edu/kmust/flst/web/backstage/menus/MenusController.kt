package cn.edu.kmust.flst.web.backstage.menus

import cn.edu.kmust.flst.web.bean.backstage.menus.MenusBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest

/**
 * Created by zbeboy 2018-04-11 .
 **/
@Controller
open class MenusController {

    /**
     * 栏目管理
     *
     * @return 栏目管理
     */
    @RequestMapping(value = ["/web/backstage/menus"], method = [(RequestMethod.GET)])
    fun menu(): String {
        return "backstage/menus/menus_list"
    }

    /**
     * 列表数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/menus/data"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun menuData(request: HttpServletRequest): BootstrapTableUtils<MenusBean> {
        val bootstrapTableUtils = BootstrapTableUtils<MenusBean>(request)
        return bootstrapTableUtils
    }

}