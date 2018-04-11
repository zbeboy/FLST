package cn.edu.kmust.flst.web.menu

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by zbeboy 2018-04-11 .
 **/
@Controller
open class MenuController {

    /**
     * 栏目管理
     *
     * @return 栏目管理
     */
    @RequestMapping("/web/backstage/menu")
    fun menu(): String {
        return "backstage/menu/menu_list"
    }
}