package cn.edu.kmust.flst.web.backstage.article

import cn.edu.kmust.flst.service.backstage.article.ArticleService
import cn.edu.kmust.flst.service.util.DateTimeUtils
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.springframework.stereotype.Controller
import org.springframework.util.ObjectUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

/**
 * Created by zbeboy 2018-04-13 .
 **/
@Controller
open class ArticleController {

    @Resource
    open lateinit var articleService: ArticleService

    /**
     * 中文文章管理
     *
     * @return 中文文章管理
     */
    @RequestMapping(value = ["/web/backstage/article"], method = [(RequestMethod.GET)])
    fun menu(): String {
        return "backstage/article/article_list"
    }

    /**
     * 列表数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/article/data"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun articleData(request: HttpServletRequest): BootstrapTableUtils<ArticleBean> {
        val bootstrapTableUtils = BootstrapTableUtils<ArticleBean>(request)
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
        return bootstrapTableUtils
    }
}