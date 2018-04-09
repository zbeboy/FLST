package cn.edu.kmust.flst.web

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.ClassUtils
import org.springframework.web.bind.annotation.RequestMapping

@Controller
open class MainController {

    /**
     * Home page.
     *
     * @return home page
     */
    @RequestMapping("/index")
    fun index(modelMap: ModelMap): String {
        val path = ClassUtils.getDefaultClassLoader().getResource("").path
        modelMap.addAttribute("path",path)
        return "index"
    }

}