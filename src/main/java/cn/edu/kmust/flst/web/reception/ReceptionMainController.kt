package cn.edu.kmust.flst.web.reception

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.pojos.Article
import cn.edu.kmust.flst.domain.tables.pojos.ArticleEn
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
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.LocaleResolver
import java.net.URLDecoder
import java.net.URLEncoder
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
    open lateinit var articleService: ArticleService

    @Resource
    open lateinit var articleEnService: ArticleEnService

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

                val list: ArrayList<Menus> = ArrayList()
                receptionService.getMaxPid(menu, list)
                for (i in list) {
                    if (i.menuPid == "0") {
                        receptionService.bannerData(modelMap, i.menuId)
                        break
                    }
                }

                receptionService.linksData(modelMap)
                receptionService.columnsData(modelMap, menu.menuPid)

                modelMap.addAttribute("positions", list)
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
     * 搜索
     *
     * @return 搜索.
     */
    @RequestMapping(value = ["/user/search"], method = [(RequestMethod.GET)])
    fun search(searchContent: String?, request: HttpServletRequest, modelMap: ModelMap): String {
        modelMap.addAttribute("searchContent", searchContent)

        receptionService.navData(modelMap, request)
        // 因servlet会自动解码一次，因此取值会乱码，为此encode两次
        val m = URLEncoder.encode(URLEncoder.encode(searchContent, Charsets.UTF_8.displayName()), Charsets.UTF_8.displayName())
        modelMap.addAttribute("redirect_uri", "/user/search?searchContent=$m")
        receptionService.websiteData(modelMap, request)
        receptionService.linksData(modelMap)
        return "reception/article_search"
    }

    /**
     * 文章内容
     *
     * @return 内容.
     */
    @RequestMapping(value = ["/user/article/{articleId}"], method = [(RequestMethod.GET)])
    fun article(@PathVariable("articleId") articleId: Int, request: HttpServletRequest, modelMap: ModelMap): String {
        val menuId: String?
        val language = localeResolver.resolveLocale(request).displayLanguage
        // 中文文章
        if (language == Workbook.LANGUAGE_ZH_CN_NAME) {
            val data = articleService.findByIdAndCache(articleId)
            if (data.isPresent) {
                val article = data.get().into(ArticleBean::class.java)
                menuId = article.menuId
                article.articleDateStr = DateTimeUtils.timestampToString(article.articleDate, "yyyy年MM月dd日")
                modelMap.addAttribute("article", article)

                // 查询上一篇和下一篇

                val upData = articleService.findOneGTArticleDateByPage(article.articleDate, menuId)
                if (upData.isPresent) {
                    modelMap.addAttribute("upArticle", upData.get().into(Article::class.java))
                } else {
                    modelMap.addAttribute("upArticle", Article())
                }

                val downData = articleService.findOneLTArticleDateByPage(article.articleDate, menuId)
                if (downData.isPresent) {
                    modelMap.addAttribute("downArticle", downData.get().into(Article::class.java))
                } else {
                    modelMap.addAttribute("downArticle", Article())
                }

            } else {
                modelMap.addAttribute("status", 500)
                modelMap.addAttribute("message", "未查询到该文章")
                return "error"
            }
        } else {
            val data = articleEnService.findByIdAndCache(articleId)
            if (data.isPresent) {
                val article = data.get().into(ArticleEnBean::class.java)
                menuId = article.menuId
                article.articleDateStr = DateTimeUtils.timestampToString(article.articleDate, "yyyy-MM-dd")
                modelMap.addAttribute("article", article)
                // 查询上一篇和下一篇
                val upData = articleEnService.findOneGTArticleDateByPage(article.articleDate, menuId)
                if (upData.isPresent) {
                    modelMap.addAttribute("upArticle", upData.get().into(Article::class.java))
                } else {
                    modelMap.addAttribute("upArticle", Article())
                }

                val downData = articleEnService.findOneLTArticleDateByPage(article.articleDate, menuId)
                if (downData.isPresent) {
                    modelMap.addAttribute("downArticle", downData.get().into(Article::class.java))
                } else {
                    modelMap.addAttribute("downArticle", Article())
                }

            } else {
                modelMap.addAttribute("status", 500)
                modelMap.addAttribute("message", "未查询到该文章")
                return "error"
            }
        }

        receptionService.navData(modelMap, request)
        modelMap.addAttribute("redirect_uri", "/")
        receptionService.websiteData(modelMap, request)
        val menu = menusService.findById(menuId)
        val list: ArrayList<Menus> = ArrayList()
        receptionService.getMaxPid(menu, list)
        receptionService.linksData(modelMap)
        receptionService.columnsData(modelMap, menu.menuPid)

        modelMap.addAttribute("positions", list)
        modelMap.addAttribute("columnId", menu.menuId)

        return "reception/article_content"
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

    /**
     * 文章搜索数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/data/search"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun searchData(request: HttpServletRequest): BootstrapTableUtils<*>? {
        val language = localeResolver.resolveLocale(request).displayLanguage

        return if (language == Workbook.LANGUAGE_ZH_CN_NAME) {
            methodControllerCommon.articleData(request)
        } else {
            methodControllerCommon.articleEnData(request)
        }
    }
}