package cn.edu.kmust.flst.web.backstage.article

import cn.edu.kmust.flst.config.FLSTProperties
import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.public_.tables.pojos.Article
import cn.edu.kmust.flst.domain.public_.tables.pojos.ArticleContent
import cn.edu.kmust.flst.domain.public_.tables.pojos.Menus
import cn.edu.kmust.flst.service.backstage.article.ArticleContentService
import cn.edu.kmust.flst.service.backstage.article.ArticleService
import cn.edu.kmust.flst.service.backstage.menus.MenusService
import cn.edu.kmust.flst.service.common.UploadService
import cn.edu.kmust.flst.service.system.UsersService
import cn.edu.kmust.flst.service.util.DateTimeUtils
import cn.edu.kmust.flst.service.util.RequestUtils
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleBean
import cn.edu.kmust.flst.web.bean.file.FileBean
import cn.edu.kmust.flst.web.common.MethodControllerCommon
import cn.edu.kmust.flst.web.util.AjaxUtils
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import cn.edu.kmust.flst.web.util.ImageUtils
import cn.edu.kmust.flst.web.vo.backstage.article.ArticleAddVo
import cn.edu.kmust.flst.web.vo.backstage.article.ArticleEditVo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartHttpServletRequest
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

/**
 * Created by zbeboy 2018-04-13 .
 **/
@Controller
open class ArticleController {

    private val log = LoggerFactory.getLogger(ArticleController::class.java)

    @Autowired
    open lateinit var flstProperties: FLSTProperties

    @Resource
    open lateinit var usersService: UsersService

    @Resource
    open lateinit var articleService: ArticleService

    @Resource
    open lateinit var articleContentService: ArticleContentService

    @Resource
    open lateinit var menusService: MenusService

    @Resource
    open lateinit var uploadService: UploadService

    @Resource
    open lateinit var methodControllerCommon: MethodControllerCommon

    /**
     * 中文文章管理
     *
     * @return 中文文章管理
     */
    @RequestMapping(value = ["/web/backstage/article"], method = [(RequestMethod.GET)])
    fun article(): String {
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
        val articleRecord = articleService.findByIdRelation(articleId)
        return if (articleRecord.isPresent) {
            val article = articleRecord.get().into(ArticleBean::class.java)
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
        return methodControllerCommon.articleData(request)
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
            val path = flstProperties.getConstants().staticImages + Workbook.DIRECTORY_SPLIT
            val fileBeen = uploadService.upload(multipartHttpServletRequest,
                    RequestUtils.getRealPath(request) + path, request.remoteAddr)
            if (fileBeen.isNotEmpty()) {
                fileBeen.forEach { i ->
                    // 不压缩动态图
                    if (!org.apache.commons.lang3.StringUtils.equalsIgnoreCase(i.ext, "gif")) {
                        val filePath = RequestUtils.getRealPath(request) + flstProperties.getConstants().staticImages
                        val fileName = if (i.newName!!.lastIndexOf('.') > 0) i.newName!!.substring(0, i.newName!!.lastIndexOf('.')) + "_compress." + i.ext else i.newName + "_compress"
                        // 压缩图片
                        ImageUtils.optimize(filePath + "/" + i.newName, "$filePath/$fileName", 0.5f)
                        i.newName = flstProperties.getConstants().staticImages + "/" + fileName
                    } else {
                        i.newName = flstProperties.getConstants().staticImages + "/" + i.newName
                    }
                }
            }
            ajaxUtils.success().msg("保存文件成功").listData(fileBeen)
        } catch (e: Exception) {
            log.error("Upload cover error, error is {}", e)
            ajaxUtils.fail().msg("保存文件异常")
        }

        return ajaxUtils
    }

    /**
     * 获取栏目数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/article/menus"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun pids(menuFixed: Boolean?): AjaxUtils<Menus> {
        val ajaxUtils = AjaxUtils.of<Menus>()
        if (!ObjectUtils.isEmpty(menuFixed)) {
            ajaxUtils.success().msg("获取数据成功").listData(menusService.findByMenuFixed(menuFixed!!))
        } else {
            ajaxUtils.success().msg("获取数据成功").listData(menusService.findAll())
        }
        return ajaxUtils
    }

    /**
     * 文章封面删除
     *
     * @param request                       请求
     * @return true or false
     */
    @RequestMapping("/web/backstage/article/cover/delete")
    @ResponseBody
    fun coverDelete(@RequestParam("articleCover") articleCover: String, request: HttpServletRequest): AjaxUtils<*> {
        methodControllerCommon.deletePicFile(request, articleCover)
        return AjaxUtils.of<Any>().success().msg("删除成功")
    }

    /**
     * 保存
     *
     * @param articleAddVo 数据
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
            article.articleDate = DateTimeUtils.getNow()
            article.articleClicks = 0
            article.articleAuthor = usersService.getUsernameFromSession()
            article.articleSources = articleAddVo.articleSources
            article.articleSourcesName = articleAddVo.articleSourcesName
            article.articleSourcesLink = articleAddVo.articleSourcesLink
            article.articleSn = articleAddVo.articleSn
            article.menuId = articleAddVo.menuId
            val id = articleService.saveAndReturnId(article)
            val articleContent = ArticleContent()
            articleContent.id = id
            articleContent.articleContent = articleAddVo.articleContent
            articleContentService.save(articleContent)
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
    fun update(@Valid articleEditVo: ArticleEditVo, bindingResult: BindingResult, request: HttpServletRequest): AjaxUtils<*> {
        if (!bindingResult.hasErrors()) {
            val article = articleService.findById(articleEditVo.articleId!!)
            article.articleTitle = articleEditVo.articleTitle
            article.articleBrief = if (StringUtils.hasLength(articleEditVo.articleBrief)) {
                articleEditVo.articleBrief
            } else {
                articleEditVo.articleTitle
            }

            if (article.articleCover != articleEditVo.articleCover) {
                methodControllerCommon.deletePicFile(request, article.articleCover)
            }
            article.articleCover = articleEditVo.articleCover
            article.articleDate = DateTimeUtils.getNow()
            article.articleSources = articleEditVo.articleSources
            article.articleSourcesName = articleEditVo.articleSourcesName
            article.articleSourcesLink = articleEditVo.articleSourcesLink
            article.articleSn = articleEditVo.articleSn
            article.menuId = articleEditVo.menuId
            articleService.update(article)
            val articleContent = ArticleContent()
            articleContent.id = article.articleId
            articleContent.articleContent = articleEditVo.articleContent
            articleContentService.update(articleContent)
            return AjaxUtils.of<Any>().success().msg("更新成功")
        }
        return AjaxUtils.of<Any>().fail().msg("更新失败")
    }

    /**
     * 删除
     *
     * @return 删除结果
     */
    @RequestMapping(value = ["/web/backstage/article/delete"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun delete(@RequestParam("articleId") id: Int, request: HttpServletRequest): AjaxUtils<*> {
        val article = articleService.findById(id)
        methodControllerCommon.deletePicFile(request, article.articleCover)
        articleContentService.deleteById(id)
        articleService.deleteById(id)
        return AjaxUtils.of<Any>().success().msg("删除成功")
    }

    /**
     * 更新序号
     *
     * @return 删除结果
     */
    @RequestMapping(value = ["/web/backstage/article/update/sno"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun updateSno(@RequestParam("articleId") id: Int, @RequestParam("articleSn") articleSn: Int): AjaxUtils<*> {
        val article = articleService.findById(id)
        article.articleSn = articleSn
        articleService.update(article)
        return AjaxUtils.of<Any>().success().msg("更新成功")
    }
}