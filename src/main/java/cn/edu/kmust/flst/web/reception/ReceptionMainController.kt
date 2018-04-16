package cn.edu.kmust.flst.web.reception

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.service.reception.NavService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.annotation.Resource

/**
 * Created by zbeboy 2018-04-15 .
 **/
@Controller
open class ReceptionMainController {

    @Resource
    open lateinit var navService: NavService

    @RequestMapping("/user/zh")
    @ResponseBody
    fun zh(): String {
        return navService.navHtml(Workbook.LANGUAGE_ZH_CN)
    }

    @RequestMapping("/user/en")
    @ResponseBody
    fun en(): String {
        return navService.navHtml(Workbook.LANGUAGE_EN)
    }
}