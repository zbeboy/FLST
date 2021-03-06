package cn.edu.kmust.flst.web.backstage.article

import cn.edu.kmust.flst.domain.flst.tables.pojos.ArticleEn
import cn.edu.kmust.flst.domain.flst.tables.pojos.ArticleEnContent
import cn.edu.kmust.flst.service.backstage.article.ArticleEnContentService
import cn.edu.kmust.flst.service.backstage.article.ArticleEnService
import cn.edu.kmust.flst.service.system.UsersService
import cn.edu.kmust.flst.service.util.DateTimeUtils
import cn.edu.kmust.flst.service.util.FilesUtils
import cn.edu.kmust.flst.service.util.RequestUtils
import cn.edu.kmust.flst.web.bean.backstage.article.ArticleEnBean
import cn.edu.kmust.flst.web.common.MethodControllerCommon
import cn.edu.kmust.flst.web.util.AjaxUtils
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import cn.edu.kmust.flst.web.vo.backstage.article.ArticleEnAddVo
import cn.edu.kmust.flst.web.vo.backstage.article.ArticleEnEditVo
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.StringUtils
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

/**
 * Created by zbeboy 2018-04-14 .
 **/
@Controller
open class ArticleEnController {

    @Resource
    open lateinit var articleEnContentService: ArticleEnContentService
    @Resource
    open lateinit var usersService: UsersService

    @Resource
    open lateinit var articleEnService: ArticleEnService

    @Resource
    open lateinit var methodControllerCommon: MethodControllerCommon

    /**
     * 英文文章管理
     *
     * @return 英文文章管理
     */
    @RequestMapping(value = ["/web/backstage/en/article"], method = [(RequestMethod.GET)])
    fun article(): String {
        return "backstage/en/article/article_list"
    }

    /**
     * 英文文章添加
     *
     * @return 英文文章添加
     */
    @RequestMapping(value = ["/web/backstage/en/article/add"], method = [(RequestMethod.GET)])
    fun add(): String {
        return "backstage/en/article/article_add"
    }

    /**
     * 英文文章编辑
     *
     * @return 英文文章编辑
     */
    @RequestMapping(value = ["/web/backstage/en/article/edit/{articleId}"], method = [(RequestMethod.GET)])
    fun edit(@PathVariable("articleId") articleId: Int, modelMap: ModelMap): String {
        val articleEnRecord = articleEnService.findByIdRelation(articleId)
        return if (articleEnRecord.isPresent) {
            val articleEn = articleEnRecord.get().into(ArticleEnBean::class.java)
            modelMap.addAttribute("article", articleEn)
            "backstage/en/article/article_edit"
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
    @RequestMapping(value = ["/web/backstage/en/article/data"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun articleData(request: HttpServletRequest): BootstrapTableUtils<ArticleEnBean> {
        return methodControllerCommon.articleEnData(request)
    }

    /**
     * 保存
     *
     * @param articleEnAddVo 数据
     * @param bindingResult 检验
     * @return 保存结果
     */
    @RequestMapping(value = ["/web/backstage/en/article/save"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun save(@Valid articleEnAddVo: ArticleEnAddVo, bindingResult: BindingResult): AjaxUtils<*> {
        if (!bindingResult.hasErrors()) {
            val articleEn = ArticleEn()
            articleEn.articleTitle = articleEnAddVo.articleTitle
            articleEn.articleBrief = if (StringUtils.hasLength(articleEnAddVo.articleBrief)) {
                articleEnAddVo.articleBrief
            } else {
                articleEnAddVo.articleTitle
            }
            articleEn.articleCover = articleEnAddVo.articleCover
            articleEn.articleDate = DateTimeUtils.getNow()
            articleEn.articleClicks = 0
            articleEn.articleAuthor = usersService.getUsernameFromSession()
            articleEn.articleSources = articleEnAddVo.articleSources
            articleEn.articleSourcesName = articleEnAddVo.articleSourcesName
            articleEn.articleSourcesLink = articleEnAddVo.articleSourcesLink
            articleEn.articleSn = articleEnAddVo.articleSn
            articleEn.menuId = articleEnAddVo.menuId
            val id = articleEnService.saveAndReturnId(articleEn)
            val articleEnContent = ArticleEnContent()
            articleEnContent.id = id
            articleEnContent.articleContent = articleEnAddVo.articleContent
            articleEnContentService.save(articleEnContent)
            return AjaxUtils.of<Any>().success().msg("保存成功")
        }
        return AjaxUtils.of<Any>().fail().msg("保存失败")
    }

    /**
     * 更新
     *
     * @param articleEnEditVo 数据
     * @param bindingResult 检验
     * @return 保存结果
     */
    @RequestMapping(value = ["/web/backstage/en/article/update"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun update(@Valid articleEnEditVo: ArticleEnEditVo, bindingResult: BindingResult, request: HttpServletRequest): AjaxUtils<*> {
        if (!bindingResult.hasErrors()) {
            val articleEn = articleEnService.findById(articleEnEditVo.articleId!!)
            articleEn.articleTitle = articleEnEditVo.articleTitle
            articleEn.articleBrief = if (StringUtils.hasLength(articleEnEditVo.articleBrief)) {
                articleEnEditVo.articleBrief
            } else {
                articleEnEditVo.articleTitle
            }

            if (articleEn.articleCover != articleEnEditVo.articleCover) {
                FilesUtils.deleteFile(RequestUtils.getRealPath(request) + articleEn.articleCover)
            }
            articleEn.articleCover = articleEnEditVo.articleCover
            articleEn.articleDate = DateTimeUtils.getNow()
            articleEn.articleSources = articleEnEditVo.articleSources
            articleEn.articleSourcesName = articleEnEditVo.articleSourcesName
            articleEn.articleSourcesLink = articleEnEditVo.articleSourcesLink
            articleEn.articleSn = articleEnEditVo.articleSn
            articleEn.menuId = articleEnEditVo.menuId
            articleEnService.update(articleEn)
            val articleEnContent = ArticleEnContent()
            articleEnContent.id = articleEn.articleId
            articleEnContent.articleContent = articleEnEditVo.articleContent
            articleEnContentService.update(articleEnContent)
            return AjaxUtils.of<Any>().success().msg("更新成功")
        }
        return AjaxUtils.of<Any>().fail().msg("更新失败")
    }

    /**
     * 删除
     *
     * @return 删除结果
     */
    @RequestMapping(value = ["/web/backstage/en/article/delete"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun delete(@RequestParam("articleId") id: Int, request: HttpServletRequest): AjaxUtils<*> {
        val articleEn = articleEnService.findById(id)
        FilesUtils.deleteFile(RequestUtils.getRealPath(request) + articleEn.articleCover)
        articleEnContentService.deleteById(id)
        articleEnService.deleteById(id)
        return AjaxUtils.of<Any>().success().msg("删除成功")
    }

    /**
     * 更新序号
     *
     * @return 删除结果
     */
    @RequestMapping(value = ["/web/backstage/en/article/update/sno"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun updateSno(@RequestParam("articleId") id: Int, @RequestParam("articleSn") articleSn: Int): AjaxUtils<*> {
        val article = articleEnService.findById(id)
        article.articleSn = articleSn
        articleEnService.update(article)
        return AjaxUtils.of<Any>().success().msg("更新成功")
    }
}