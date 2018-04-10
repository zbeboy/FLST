package cn.edu.kmust.flst.web

import cn.edu.kmust.flst.config.Workbook
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import javax.servlet.http.HttpServletRequest

@Controller
open class MainController {

    /**
     * main page
     *
     * @return main page
     */
    @RequestMapping("/")
    fun root(modelMap: ModelMap,request: HttpServletRequest): String {
        val path = request.session.servletContext.getRealPath(Workbook.DIRECTORY_SPLIT)
        modelMap.addAttribute("path",path)
        return "index"
    }

    /**
     * Home page.
     *
     * @return home page
     */
    @RequestMapping("/index")
    fun index(modelMap: ModelMap,request: HttpServletRequest): String {
        val path = request.session.servletContext.getRealPath(Workbook.DIRECTORY_SPLIT)
        modelMap.addAttribute("path",path)
        return "index"
    }

    /**
     * 登录页
     *
     * @return 登录页.
     */
    @RequestMapping(value = ["/login"], method = [(RequestMethod.GET)])
    fun login(): String {
        return "login"
    }

}