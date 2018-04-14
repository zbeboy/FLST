package cn.edu.kmust.flst.web.backstage.article

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.pojos.Article
import cn.edu.kmust.flst.domain.tables.pojos.Menus
import cn.edu.kmust.flst.service.backstage.article.ArticleService
import cn.edu.kmust.flst.service.common.UploadService
import cn.edu.kmust.flst.service.system.UsersService
import cn.edu.kmust.flst.service.util.DateTimeUtils
import cn.edu.kmust.flst.service.util.RequestUtils
import cn.edu.kmust.flst.service.util.UUIDUtils
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleBean
import cn.edu.kmust.flst.web.bean.file.FileBean
import cn.edu.kmust.flst.web.util.AjaxUtils
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import cn.edu.kmust.flst.web.vo.backstage.article.ArticleAddVo
import cn.edu.kmust.flst.web.vo.backstage.article.ArticleEditVo
import cn.edu.kmust.flst.web.vo.backstage.menus.MenusAddVo
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.multipart.MultipartHttpServletRequest
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

/**
 * Created by zbeboy 2018-04-13 .
 **/
@Controller
open class ArticleController {

    private val log = LoggerFactory.getLogger(ArticleController::class.java)

    @Resource
    open lateinit var usersService: UsersService

    @Resource
    open lateinit var articleService: ArticleService

    @Resource
    open lateinit var uploadService: UploadService

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
     * 中文文章添加
     *
     * @return 中文文章添加
     */
    @RequestMapping(value = ["/web/backstage/article/add"], method = [(RequestMethod.GET)])
    fun add(): String {
        return "backstage/article/article_add"
    }

    /**
     * 中文文章编辑
     *
     * @return 中文文章编辑
     */
    @RequestMapping(value = ["/web/backstage/article/edit/{articleId}"], method = [(RequestMethod.GET)])
    fun edit(@PathVariable("articleId") articleId: Int, modelMap: ModelMap): String {
        val article = articleService.findById(articleId)
        return if (!ObjectUtils.isEmpty(article)) {
            modelMap.addAttribute("article", article)
            "backstage/article/article_edit"
        } else {
            modelMap.addAttribute("status", 500)
            modelMap.addAttribute("message", "未查询到该文章信息")
            "error"
        }
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

    /**
     * 文章封面上传
     *
     * @param multipartHttpServletRequest   文件
     * @param request                       请求
     * @return true or false
     */
    @RequestMapping("/web/backstage/article/cover/upload")
    @ResponseBody
    fun coverUpload(multipartHttpServletRequest: MultipartHttpServletRequest, request: HttpServletRequest): AjaxUtils<FileBean> {
        val ajaxUtils = AjaxUtils.of<FileBean>()
        try {
            val path = Workbook.imagesPath()
            val fileBeen = uploadService.upload(multipartHttpServletRequest,
                    RequestUtils.getRealPath(request) + path, request.remoteAddr)
            ajaxUtils.success().msg("保存文件成功").listData(fileBeen)
        } catch (e: Exception) {
            log.error("Upload graduation design proposal error, error is {}", e)
            ajaxUtils.fail().msg("保存文件异常")
        }

        return ajaxUtils
    }

    /**
     * 保存
     *
     * @param menusAddVo 数据
     * @param bindingResult 检验
     * @return 保存结果
     */
    @RequestMapping(value = ["/web/backstage/article/save"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun save(@Valid articleAddVo: ArticleAddVo, bindingResult: BindingResult): AjaxUtils<*> {
        if (!bindingResult.hasErrors()) {
            val article = Article()
            article.articleTitle = articleAddVo.articleTitle
            article.articleBrief = if (StringUtils.hasLength(articleAddVo.articleBrief)) {
                articleAddVo.articleBrief
            } else {
                articleAddVo.articleTitle
            }
            article.articleCover = articleAddVo.articleCover
            article.articleContent = articleAddVo.articleContent
            article.articleDate = DateTimeUtils.getNow()
            article.articleClicks = 0
            article.username = usersService.getUsernameFromSession()
            article.articleSources = articleAddVo.articleSources
            article.articleSourcesName = articleAddVo.articleSourcesName
            article.articleSourcesLink = articleAddVo.articleSourcesLink
            article.menuId = articleAddVo.menuId
            articleService.save(article)
            return AjaxUtils.of<Any>().success().msg("保存成功")
        }
        return AjaxUtils.of<Any>().fail().msg("保存失败")
    }

    /**
     * 更新
     *
     * @param articleEditVo 数据
     * @param bindingResult 检验
     * @return 保存结果
     */
    @RequestMapping(value = ["/web/backstage/article/update"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun update(@Valid articleEditVo: ArticleEditVo, bindingResult: BindingResult): AjaxUtils<*> {
        if (!bindingResult.hasErrors()) {
            val article = articleService.findById(articleEditVo.articleId!!)
            article.articleTitle = articleEditVo.articleTitle
            article.articleBrief = if (StringUtils.hasLength(articleEditVo.articleBrief)) {
                articleEditVo.articleBrief
            } else {
                articleEditVo.articleTitle
            }
            article.articleCover = articleEditVo.articleCover
            article.articleContent = articleEditVo.articleContent
            article.articleDate = DateTimeUtils.getNow()
            article.articleSources = articleEditVo.articleSources
            article.articleSourcesName = articleEditVo.articleSourcesName
            article.articleSourcesLink = articleEditVo.articleSourcesLink
            article.menuId = articleEditVo.menuId
            articleService.update(article)
            return AjaxUtils.of<Any>().success().msg("更新成功")
        }
        return AjaxUtils.of<Any>().fail().msg("更新失败")
    }
}