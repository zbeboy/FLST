package cn.edu.kmust.flst.web.reception

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.pojos.Menus
import cn.edu.kmust.flst.service.backstage.article.ArticleEnService
import cn.edu.kmust.flst.service.backstage.article.ArticleService
import cn.edu.kmust.flst.service.backstage.menus.MenusService
import cn.edu.kmust.flst.service.reception.NavService
import cn.edu.kmust.flst.service.reception.ReceptionService
import cn.edu.kmust.flst.service.util.DateTimeUtils
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleBean
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleEnBean
import cn.edu.kmust.flst.web.common.MethodControllerCommon
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.ObjectUtils
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.LocaleResolver
import java.util.ArrayList
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

/**
 * Created by zbeboy 2018-04-15 .
 **/
@Controller
open class ReceptionMainController {


    @Resource
    open lateinit var menusService: MenusService

    @Resource
    open lateinit var localeResolver: LocaleResolver

    @Resource
    open lateinit var receptionService: ReceptionService

    @Resource
    open lateinit var methodControllerCommon: MethodControllerCommon

    /**
     * 文章主页
     *
     * @return 文章主页.
     */
    @RequestMapping(value = ["/user/menu/{menuId}"], method = [(RequestMethod.GET)])
    fun home(@PathVariable("menuId") menuId: String, request: HttpServletRequest, modelMap: ModelMap): String {
        val menu = menusService.findById(menuId)
        return if (!ObjectUtils.isEmpty(menu)) {
            if (menu.menuShow == 1.toByte()) {
                receptionService.navData(modelMap, request)
                modelMap.addAttribute("redirect_uri", "/user/menu/$menuId")
                receptionService.websiteData(modelMap, request)
                receptionService.bannerData(modelMap, Workbook.WEB_FIXED_HOME_ID)
                receptionService.linksData(modelMap)
                receptionService.columnsData(modelMap, menu.menuPid)

                modelMap.addAttribute("columnId", menu.menuId)
                "reception/article_list"
            } else {
                modelMap.addAttribute("status", 500)
                modelMap.addAttribute("message", "该栏目已关闭显示")
                "error"
            }
        } else {
            modelMap.addAttribute("status", 500)
            modelMap.addAttribute("message", "未查询到该文章信息")
            "error"
        }
    }

    /**
     * 文章列表数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/data/articles/{menuId}"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun articleData(@PathVariable("menuId") menuId: String, request: HttpServletRequest): BootstrapTableUtils<*>? {
        val language = localeResolver.resolveLocale(request).displayLanguage
        var bootstrapTableUtils: BootstrapTableUtils<*>? = BootstrapTableUtils<Any>()
        val menu = menusService.findById(menuId)
        // 该栏目是否正常显示
        if (menu.menuShow == 1.toByte()) {
            // 显示列表
            // 中文文章
            if (language == Workbook.LANGUAGE_ZH_CN_NAME) {
                bootstrapTableUtils = methodControllerCommon.articleData(request)
            } else {
                bootstrapTableUtils = methodControllerCommon.articleEnData(request)
            }
        }

        return bootstrapTableUtils
    }
}