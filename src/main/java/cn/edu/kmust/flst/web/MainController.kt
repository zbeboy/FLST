package cn.edu.kmust.flst.web

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.service.system.AuthoritiesService
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

@Controller
open class MainController {

    @Resource
    open lateinit var authoritiesService: AuthoritiesService

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
        return if (authoritiesService.isRememberMeAuthenticated()) {
            "redirect:/web/backstage"
        } else {
            "login"
        }
    }

    /**
     * 后台欢迎页
     *
     * @return 后台欢迎页
     */
    @RequestMapping(value = ["/web/backstage"], method = [(RequestMethod.GET)])
    open fun backstage(request: HttpServletRequest): String {
        return "backstage"
    }

}