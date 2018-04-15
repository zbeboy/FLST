package cn.edu.kmust.flst.web.backstage.links

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

/**
 * Created by zbeboy 2018-04-15 .
 **/
@Controller
open class LinksController {

    /**
     * 链接管理
     *
     * @return 链接管理
     */
    @RequestMapping(value = ["/web/backstage/links"], method = [(RequestMethod.GET)])
    fun links(): String {
        return "backstage/links/links_list"
    }
}