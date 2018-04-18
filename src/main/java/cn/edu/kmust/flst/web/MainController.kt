package cn.edu.kmust.flst.web

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.service.common.UploadService
import cn.edu.kmust.flst.service.reception.NavService
import cn.edu.kmust.flst.service.system.AuthoritiesService
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.ModelAndView
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
open class MainController {

    @Resource
    open lateinit var authoritiesService: AuthoritiesService

    @Resource
    open lateinit var uploadService: UploadService

    @Resource
    open lateinit var localeResolver: LocaleResolver

    @Resource
    open lateinit var navService: NavService

    /**
     * main page
     *
     * @return main page
     */
    @RequestMapping("/")
    fun root(modelMap: ModelMap, request: HttpServletRequest): String {
        data(modelMap, request)
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

    fun data(modelMap: ModelMap, request: HttpServletRequest) {
        val language = localeResolver.resolveLocale(request).displayLanguage
        if (language == Workbook.LANGUAGE_ZH_CN_NAME) {
            modelMap.addAttribute("language", Workbook.LANGUAGE_ZH_CN)
            modelMap.addAttribute("nav", navService.navHtml(Workbook.LANGUAGE_ZH_CN))
        } else {
            modelMap.addAttribute("language", Workbook.LANGUAGE_EN)
            modelMap.addAttribute("nav", navService.navHtml(Workbook.LANGUAGE_EN))
        }
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

    /**
     * 语言切换
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param language 语言
     * @return 重置页面
     */
    @RequestMapping("/language")
    fun language(request: HttpServletRequest, response: HttpServletResponse, language: String): ModelAndView {
        val languageLowerCase = language.toLowerCase()
        if (languageLowerCase == "") {
            return ModelAndView("redirect:/")
        } else {
            when (languageLowerCase) {
                "zh_cn" -> localeResolver.setLocale(request, response, Locale.CHINA)
                "en" -> localeResolver.setLocale(request, response, Locale.ENGLISH)
                else -> localeResolver.setLocale(request, response, Locale.CHINA)
            }
        }

        return ModelAndView("redirect:/")
    }

}