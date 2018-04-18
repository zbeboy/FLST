package cn.edu.kmust.flst.web.reception

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.service.backstage.article.ArticleEnService
import cn.edu.kmust.flst.service.backstage.article.ArticleService
import cn.edu.kmust.flst.service.backstage.menus.MenusService
import cn.edu.kmust.flst.service.reception.NavService
import cn.edu.kmust.flst.service.util.DateTimeUtils
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleBean
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleEnBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.springframework.stereotype.Controller
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
    open lateinit var articleService: ArticleService

    @Resource
    open lateinit var articleEnService: ArticleEnService

    @Resource
    open lateinit var menusService: MenusService

    @Resource
    open lateinit var localeResolver: LocaleResolver

    /**
     * 文章列表数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/user/menu/{menuId}"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun articleData(@PathVariable("menuId") menuId: String, request: HttpServletRequest): BootstrapTableUtils<*>? {
        val language = localeResolver.resolveLocale(request).displayLanguage
        var bootstrapTableUtils: BootstrapTableUtils<*>? = null
        val menu = menusService.findById(menuId)
        // 该栏目是否正常显示
        if (menu.menuShow == 1.toByte()) {
            // 该栏目链接是否需要直接显示文章
            if (menu.showArticle == 1.toByte()) {
                // TODO:显示文章内容
            } else {
                // 显示列表
                // 中文文章
                if (language == Workbook.LANGUAGE_ZH_CN_NAME) {
                    bootstrapTableUtils = BootstrapTableUtils<ArticleBean>(request)
                    val records = articleService.findAllByPage(bootstrapTableUtils)
                    var articles: List<ArticleBean> = ArrayList()
                    if (!ObjectUtils.isEmpty(records) && records.isNotEmpty) {
                        articles = records.into(ArticleBean::class.java)
                        articles.forEach { i ->
                            i.articleDateStr = DateTimeUtils.timestampToString(i.articleDate, "yyyy-MM-dd")
                        }
                    }
                    bootstrapTableUtils.total = articleService.countByCondition(bootstrapTableUtils)
                    bootstrapTableUtils.rows = articles
                } else {
                    bootstrapTableUtils = BootstrapTableUtils<ArticleEnBean>(request)
                    val records = articleEnService.findAllByPage(bootstrapTableUtils)
                    var articles: List<ArticleEnBean> = ArrayList()
                    if (!ObjectUtils.isEmpty(records) && records.isNotEmpty) {
                        articles = records.into(ArticleEnBean::class.java)
                        articles.forEach { i ->
                            i.articleDateStr = DateTimeUtils.timestampToString(i.articleDate, "yyyy-MM-dd")
                        }
                    }
                    bootstrapTableUtils.total = articleEnService.countByCondition(bootstrapTableUtils)
                    bootstrapTableUtils.rows = articles
                }
            }
        } else {
            bootstrapTableUtils = BootstrapTableUtils<Any>()
        }

        return bootstrapTableUtils
    }
}