package cn.edu.kmust.flst.web.reception

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.pojos.Article
import cn.edu.kmust.flst.domain.tables.pojos.Menus
import cn.edu.kmust.flst.service.backstage.article.ArticleEnService
import cn.edu.kmust.flst.service.backstage.article.ArticleService
import cn.edu.kmust.flst.service.backstage.menus.MenusService
import cn.edu.kmust.flst.service.reception.ReceptionService
import cn.edu.kmust.flst.service.util.DateTimeUtils
import cn.edu.kmust.flst.service.util.RequestUtils
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleBean
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleEnBean
import cn.edu.kmust.flst.web.bean.reception.SorterBean
import cn.edu.kmust.flst.web.common.MethodControllerCommon
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.LocaleResolver
import java.net.URLEncoder
import java.sql.Timestamp
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

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
    @RequestMapping(value = [Workbook.RECEPTION_LINK + "{menuId}"], method = [(RequestMethod.GET)])
    fun home(@PathVariable("menuId") menuId: String, session: HttpSession, request: HttpServletRequest, modelMap: ModelMap): String {
        val menu = menusService.findById(menuId)
        val language = localeResolver.resolveLocale(request).displayLanguage
        return if (!ObjectUtils.isEmpty(menu)) {
            if (menu.menuShow == 1.toByte()) {
                receptionService.navData(modelMap, request)
                receptionService.websiteData(modelMap, request)
                val list: ArrayList<Menus> = ArrayList()
                receptionService.getMaxPid(menu, list, request)
                receptionService.linksData(modelMap)
                receptionService.columnsData(modelMap, menu.menuPid, request)
                modelMap.addAttribute("positions", list)
                modelMap.addAttribute("menu", menu)
                // 直接关联文章
                if (menu.showArticle == 1.toByte()) {
                    var page = "reception/article_content"
                    // 中文文章
                    if (language == Workbook.LANGUAGE_ZH_CN_NAME) {
                        val data = articleService.findOneByPageOrderByArticleDate(menuId, sorter(menu.orderWay))
                        if (data.isPresent) {
                            val article = data.get().into(ArticleBean::class.java)
                            article.articleDateStr = DateTimeUtils.timestampToString(article.articleDate, "yyyy年MM月dd日")
                            modelMap.addAttribute("article", article)
                            modelMap.addAttribute("title_msg", article.articleTitle)
                            calculationArticleClicks(article.articleId, session, request)
                            // 查询上一篇和下一篇
                            queryUpAndDownArticle(article.articleDate, menuId, menu.orderWay, modelMap)
                        } else {
                            modelMap.addAttribute("status", 404)
                            modelMap.addAttribute("message", "未查询到该文章信息")
                            page = "error"
                        }
                    } else {
                        val data = articleEnService.findOneByPageOrderByArticleDate(menuId, sorter(menu.orderWay))
                        if (data.isPresent) {
                            val article = data.get().into(ArticleEnBean::class.java)
                            article.articleDateStr = DateTimeUtils.timestampToString(article.articleDate, "yyyy-MM-dd")
                            modelMap.addAttribute("article", article)
                            modelMap.addAttribute("title_msg", article.articleTitle)
                            calculationArticleEnClicks(article.articleId, session, request)
                            // 查询上一篇和下一篇
                            queryUpAndDownArticleEn(article.articleDate, menuId, menu.orderWay, modelMap)
                        } else {
                            modelMap.addAttribute("status", 404)
                            modelMap.addAttribute("message", "Article is not found")
                            page = "error"
                        }
                    }
                    modelMap.addAttribute("redirect_uri", "/")
                    page
                } else {
                    modelMap.addAttribute("title_msg", methodControllerCommon.returnMessage(menu.menuName,
                            menu.menuNameEn, request))
                    modelMap.addAttribute("redirect_uri", Workbook.RECEPTION_LINK + menuId)
                    for (i in list) {
                        if (i.menuPid == "0") {
                            receptionService.bannerData(modelMap, i.menuId)
                        }
                    }
                    "reception/article_list"
                }

            } else {
                modelMap.addAttribute("status", 500)
                modelMap.addAttribute("message", methodControllerCommon.returnMessage("该栏目已关闭显示",
                        "This menu is closed", request))
                "error"
            }
        } else {
            modelMap.addAttribute("status", 500)
            modelMap.addAttribute("message", methodControllerCommon.returnMessage("未查询到该文章信息",
                    "This article is found", request))
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
    fun article(@PathVariable("articleId") articleId: Int, session: HttpSession, request: HttpServletRequest, modelMap: ModelMap): String {
        val menuId: String?
        val menu: Menus
        val language = localeResolver.resolveLocale(request).displayLanguage
        // 中文文章
        if (language == Workbook.LANGUAGE_ZH_CN_NAME) {
            val data = articleService.findByIdAndCache(articleId)
            if (data.isPresent) {
                val article = data.get().into(ArticleBean::class.java)
                menuId = article.menuId
                article.articleDateStr = DateTimeUtils.timestampToString(article.articleDate, "yyyy年MM月dd日")
                modelMap.addAttribute("article", article)
                modelMap.addAttribute("title_msg", article.articleTitle)
                calculationArticleClicks(articleId, session, request)
                // 查询上一篇和下一篇
                menu = menusService.findById(menuId)
                queryUpAndDownArticle(article.articleDate, menuId, menu.orderWay, modelMap)
            } else {
                modelMap.addAttribute("status", 404)
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
                modelMap.addAttribute("title_msg", article.articleTitle)
                calculationArticleEnClicks(articleId, session, request)
                // 查询上一篇和下一篇
                menu = menusService.findById(menuId)
                queryUpAndDownArticleEn(article.articleDate, menuId, menu.orderWay, modelMap)
            } else {
                modelMap.addAttribute("status", 404)
                modelMap.addAttribute("message", "Article is not found")
                return "error"
            }
        }

        receptionService.navData(modelMap, request)
        modelMap.addAttribute("redirect_uri", "/")
        receptionService.websiteData(modelMap, request)
        val list: ArrayList<Menus> = ArrayList()
        receptionService.getMaxPid(menu, list, request)
        receptionService.linksData(modelMap)
        receptionService.columnsData(modelMap, menu.menuPid, request)
        modelMap.addAttribute("positions", list)
        modelMap.addAttribute("menu", menu)

        return "reception/article_content"
    }

    /**
     * 计算中文文章点击量
     */
    private fun calculationArticleClicks(articleId: Int, session: HttpSession, request: HttpServletRequest) {
        // 计算点击量
        val clickToken = "${RequestUtils.getIpAddress(request)}:$articleId"
        if (ObjectUtils.isEmpty(session.getAttribute("articleClickKey"))) {
            // 更新点击量
            articleService.updateClicks(articleId)
            session.setAttribute("articleClickKey", clickToken)
        } else {
            val articleClickKey = session.getAttribute("articleClickKey") as String
            if (StringUtils.hasLength(articleClickKey) && articleClickKey != clickToken) {
                // 更新点击量
                articleService.updateClicks(articleId)
                session.setAttribute("articleClickKey", clickToken)
            }
        }
    }

    /**
     * 计算英文文章点击量
     */
    private fun calculationArticleEnClicks(articleId: Int, session: HttpSession, request: HttpServletRequest) {
        // 计算点击量
        val clickToken = "${RequestUtils.getIpAddress(request)}:$articleId"
        if (ObjectUtils.isEmpty(session.getAttribute("articleClickKey"))) {
            // 更新点击量
            articleEnService.updateClicks(articleId)
            session.setAttribute("articleClickKey", clickToken)
        } else {
            val articleClickKey = session.getAttribute("articleClickKey") as String
            if (StringUtils.hasLength(articleClickKey) && articleClickKey != clickToken) {
                // 更新点击量
                articleEnService.updateClicks(articleId)
                session.setAttribute("articleClickKey", clickToken)
            }
        }
    }

    /**
     * 查询中文上一篇和下一篇
     */
    private fun queryUpAndDownArticle(articleDate: Timestamp, menuId: String, orderWay: Int, modelMap: ModelMap) {
        // 查询上一篇和下一篇
        val upData = articleService.findOneGTArticleDateByPage(articleDate, menuId, sorter(orderWay))
        if (upData.isPresent) {
            modelMap.addAttribute("upArticle", upData.get().into(Article::class.java))
        } else {
            modelMap.addAttribute("upArticle", Article())
        }

        val downData = articleService.findOneLTArticleDateByPage(articleDate, menuId, sorter(orderWay))
        if (downData.isPresent) {
            modelMap.addAttribute("downArticle", downData.get().into(Article::class.java))
        } else {
            modelMap.addAttribute("downArticle", Article())
        }
    }

    /**
     * 查询英文上一篇和下一篇
     */
    private fun queryUpAndDownArticleEn(articleDate: Timestamp, menuId: String, orderWay: Int, modelMap: ModelMap) {
        // 查询上一篇和下一篇
        val upData = articleEnService.findOneGTArticleDateByPage(articleDate, menuId, sorter(orderWay))
        if (upData.isPresent) {
            modelMap.addAttribute("upArticle", upData.get().into(Article::class.java))
        } else {
            modelMap.addAttribute("upArticle", Article())
        }

        val downData = articleEnService.findOneLTArticleDateByPage(articleDate, menuId, sorter(orderWay))
        if (downData.isPresent) {
            modelMap.addAttribute("downArticle", downData.get().into(Article::class.java))
        } else {
            modelMap.addAttribute("downArticle", Article())
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
            bootstrapTableUtils = if (language == Workbook.LANGUAGE_ZH_CN_NAME) {
                methodControllerCommon.articleData(request)
            } else {
                methodControllerCommon.articleEnData(request)
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

    /**
     * 获取该栏目下文章排序
     *
     * @param orderWay 排序方式
     * @return 排序对象
     */
    private fun sorter(orderWay: Int): SorterBean {
        val sorterBean = SorterBean()
        if (orderWay == 0) {
            sorterBean.sortName = "articleDateStr"
            sorterBean.sortOrder = "desc"
        } else if (orderWay == 1) {
            sorterBean.sortName = "articleSn"
            sorterBean.sortOrder = "asc"
        }
        return sorterBean
    }
}