package cn.edu.kmust.flst.web

import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.ClassUtils
import org.springframework.web.bind.annotation.RequestMapping

@Controller
open class MainController {

    /**
     * main page
     *
     * @return main page
     */
    @RequestMapping("/")
    fun root(modelMap: ModelMap): String {
        val path = ClassUtils.getDefaultClassLoader().getResource("").path
        modelMap.addAttribute("path",path)
        return "index"
    }

    /**
     * Home page.
     *
     * @return home page
     */
    @RequestMapping("/index")
    fun index(): String {
        return "index"
    }

}