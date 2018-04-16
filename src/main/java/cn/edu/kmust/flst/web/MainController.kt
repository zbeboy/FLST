package cn.edu.kmust.flst.web

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.service.common.UploadService
import cn.edu.kmust.flst.service.system.AuthoritiesService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
open class MainController {

    @Resource
    open lateinit var authoritiesService: AuthoritiesService

    @Resource
    open lateinit var uploadService: UploadService

    /**
     * main page
     *
     * @return main page
     */
    @RequestMapping("/")
    fun root(): String {
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

    /**
     * 图片展示
     *
     * @param request 请求
     */
    @RequestMapping(value = [Workbook.MY_IMAGES_PATH + "{name}"], method = [(RequestMethod.GET)])
    fun reviewAvatar(@PathVariable("name") name: String, request: HttpServletRequest, response: HttpServletResponse) {
        uploadService.reviewPic(Workbook.imagesPath() + name, request, response)
    }

}