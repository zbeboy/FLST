package cn.edu.kmust.flst.web

import cn.edu.kmust.flst.config.FLSTProperties
import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.pojos.Menus
import cn.edu.kmust.flst.service.backstage.files.FilesService
import cn.edu.kmust.flst.service.backstage.menus.MenusService
import cn.edu.kmust.flst.service.common.UploadService
import cn.edu.kmust.flst.service.reception.ReceptionService
import cn.edu.kmust.flst.service.system.AuthoritiesService
import cn.edu.kmust.flst.service.util.RequestUtils
import cn.edu.kmust.flst.web.util.AjaxUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.ObjectUtils
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.ModelAndView
import java.io.File
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
    open lateinit var receptionService: ReceptionService

    @Resource
    open lateinit var menusService: MenusService

    @Resource
    open lateinit var filesService: FilesService

    @Autowired
    open lateinit var flstProperties: FLSTProperties

    /**
     * main page
     *
     * @return main page
     */
    @RequestMapping("/")
    fun root(modelMap: ModelMap, request: HttpServletRequest): String {
        receptionService.navData(modelMap, request)
        modelMap.addAttribute("redirect_uri", "/")
        receptionService.websiteData(modelMap, request)
        receptionService.bannerData(modelMap, Workbook.WEB_FIXED_HOME_ID)
        receptionService.linksData(modelMap)
        return "index"
    }

    /**
     * Home page.
     *
     * @return home page
     */
    @RequestMapping("/index")
    fun index(modelMap: ModelMap, request: HttpServletRequest): String {
        receptionService.navData(modelMap, request)
        modelMap.addAttribute("redirect_uri", "/")
        receptionService.websiteData(modelMap, request)
        receptionService.bannerData(modelMap, Workbook.WEB_FIXED_HOME_ID)
        receptionService.linksData(modelMap)
        return "index"
    }

    /**
     * 模块数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/data/home/template"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun templateData(request: HttpServletRequest): AjaxUtils<Menus> {
        val ajaxUtils = AjaxUtils.of<Menus>();
        val records = menusService.findByPIdAndMenuShowAndMenuFixed(Workbook.WEB_FIXED_HOME_ID, 1, 1)
        var menus: List<Menus> = ArrayList()
        if (!ObjectUtils.isEmpty(records) && records.isNotEmpty) {
            menus = records.into(Menus::class.java)
            menus.forEach { i ->
                i.menuLink = if (i.outLink != 1.toByte()) RequestUtils.getBaseUrl(request) + i.menuLink else i.menuLink
            }
        }
        return ajaxUtils.success().msg("获取数据成功").listData(menus)
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
     * 文件下载
     *
     * @param request 请求
     */
    @RequestMapping(value = [Workbook.MY_FILES_PATH + "{fileId}"], method = [(RequestMethod.GET)])
    fun fileDownload(@PathVariable("fileId") fileId: String, request: HttpServletRequest, response: HttpServletResponse) {
        val files = filesService.findById(fileId)
        if (!ObjectUtils.isEmpty(files)) {
            uploadService.download(files!!.originalFileName, files.relativePath, response, request)
        } else {
            response.writer.print("未找到该文件")
        }
    }

    /**
     * 语言切换
     *
     * @param request  请求对象
     * @param response 响应对象
     * @param language 语言
     * @param redirect_uri 重定向url
     * @return 重置页面
     */
    @RequestMapping("/language")
    fun language(request: HttpServletRequest, response: HttpServletResponse, language: String, redirect_uri: String): ModelAndView {
        val languageLowerCase = language.toLowerCase()
        if (languageLowerCase == "") {
            return ModelAndView("redirect:$redirect_uri")
        } else {
            when (languageLowerCase) {
                "zh_cn" -> localeResolver.setLocale(request, response, Locale.CHINA)
                "en" -> localeResolver.setLocale(request, response, Locale.ENGLISH)
                else -> localeResolver.setLocale(request, response, Locale.CHINA)
            }
        }

        return ModelAndView("redirect:$redirect_uri")
    }

    /**
     * let's encrypt certificate check.
     *
     * @param request 请求
     * @param response 响应
     */
    @RequestMapping(value = ["/.well-known/acme-challenge/*"], method = [(RequestMethod.GET)])
    fun letUsEncryptCertificateCheck(request: HttpServletRequest, response: HttpServletResponse) {
        val uri = request.requestURI.replace("/", "\\")
        //文件路径自行替换一下就行,就是上图中生成验证文件的路径,因为URI中已经包含了/.well-known/acme-challenge/,所以这里不需要
        val file = File(flstProperties.getCertificate().place + uri)
        uploadService.download("验证文件", file, response, request)
    }

}