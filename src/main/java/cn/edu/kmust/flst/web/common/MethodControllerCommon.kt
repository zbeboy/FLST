package cn.edu.kmust.flst.web.common

import cn.edu.kmust.flst.service.backstage.article.ArticleEnService
import cn.edu.kmust.flst.service.backstage.article.ArticleService
import cn.edu.kmust.flst.service.util.DateTimeUtils
import cn.edu.kmust.flst.service.util.FilesUtils
import cn.edu.kmust.flst.service.util.RequestUtils
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleBean
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleEnBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.springframework.stereotype.Component
import org.springframework.util.ObjectUtils
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

@Component
open class MethodControllerCommon {

    @Resource
    open lateinit var articleService: ArticleService

    @Resource
    open lateinit var articleEnService: ArticleEnService

    /**
     * 中文文章数据
     */
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

    /**
     * 英文文章数据
     */
    fun articleEnData(request: HttpServletRequest): BootstrapTableUtils<ArticleEnBean> {
        val bootstrapTableUtils = BootstrapTableUtils<ArticleEnBean>(request)
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
        return bootstrapTableUtils
    }

    /**
     * 删除带压缩图片的文件
     */
    fun deletePicFile(request: HttpServletRequest, path: String) {
        val ext = if (path.lastIndexOf('.') > 0) path.substring(path.lastIndexOf('.') + 1) else ""
        if (!org.apache.commons.lang3.StringUtils.equalsIgnoreCase(ext, "gif") && path.lastIndexOf("_compress") > 0) {
            val originalPath = if (path.lastIndexOf('.') > 0) path.substring(0, path.lastIndexOf("_compress")) + "." + ext else path.substring(0, path.lastIndexOf("_compress"))
            FilesUtils.deleteFile(RequestUtils.getRealPath(request) + originalPath)
        }
        FilesUtils.deleteFile(RequestUtils.getRealPath(request) + path)
    }
}