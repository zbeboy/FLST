package cn.edu.kmust.flst.web.backstage.links

import cn.edu.kmust.flst.domain.tables.pojos.FriendlyLink
import cn.edu.kmust.flst.service.backstage.links.LinksService
import cn.edu.kmust.flst.service.util.UUIDUtils
import cn.edu.kmust.flst.web.bean.backstage.links.LinksBean
import cn.edu.kmust.flst.web.util.AjaxUtils
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import cn.edu.kmust.flst.web.vo.backstage.links.LinksAddVo
import cn.edu.kmust.flst.web.vo.backstage.links.LinksEditVo
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.ObjectUtils
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

/**
 * Created by zbeboy 2018-04-15 .
 **/
@Controller
open class LinksController {

    @Resource
    open lateinit var linksService: LinksService

    /**
     * 链接管理
     *
     * @return 链接管理
     */
    @RequestMapping(value = ["/web/backstage/links"], method = [(RequestMethod.GET)])
    fun links(): String {
        return "backstage/links/links_list"
    }

    /**
     * 链接管理添加
     *
     * @return 链接管理添加
     */
    @RequestMapping(value = ["/web/backstage/links/add"], method = [(RequestMethod.GET)])
    fun add(): String {
        return "backstage/links/links_add"
    }

    /**
     * 链接管理编辑
     *
     * @return 链接管理编辑
     */
    @RequestMapping(value = ["/web/backstage/links/edit/{linkId}"], method = [(RequestMethod.GET)])
    fun edit(@PathVariable("linkId") id: String, modelMap: ModelMap): String {
        val links = linksService.findById(id)
        return if (!ObjectUtils.isEmpty(links)) {
            modelMap.addAttribute("links", links)
            "backstage/links/links_edit"
        } else {
            modelMap.addAttribute("status", 500)
            modelMap.addAttribute("message", "未查询到该链接信息")
            "error"
        }
    }

    /**
     * 列表数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/links/data"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun linksData(request: HttpServletRequest): BootstrapTableUtils<LinksBean> {
        val bootstrapTableUtils = BootstrapTableUtils<LinksBean>(request)
        val records = linksService.findAllByPage(bootstrapTableUtils)
        var links: List<LinksBean> = ArrayList()
        if (!ObjectUtils.isEmpty(records) && records.isNotEmpty) {
            links = records.into(LinksBean::class.java)
        }
        bootstrapTableUtils.total = linksService.countByCondition(bootstrapTableUtils)
        bootstrapTableUtils.rows = links
        return bootstrapTableUtils
    }

    /**
     * 保存
     *
     * @param linksAddVo 数据
     * @param bindingResult 检验
     * @return 保存结果
     */
    @RequestMapping(value = ["/web/backstage/links/save"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun save(@Valid linksAddVo: LinksAddVo, bindingResult: BindingResult): AjaxUtils<*> {
        if (!bindingResult.hasErrors()) {
            val links = FriendlyLink()
            links.linkId = UUIDUtils.getUUID()
            links.linkName = linksAddVo.linkName
            links.linkNameEn = linksAddVo.linkNameEn
            links.linkUrl = linksAddVo.linkUrl
            links.linkShow = linksAddVo.linkShow
            linksService.save(links)
            return AjaxUtils.of<Any>().success().msg("保存成功")
        }
        return AjaxUtils.of<Any>().fail().msg("保存失败")
    }

    /**
     * 更新
     *
     * @param linksEditVo 数据
     * @param bindingResult 检验
     * @return 保存结果
     */
    @RequestMapping(value = ["/web/backstage/links/update"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun update(@Valid linksEditVo: LinksEditVo, bindingResult: BindingResult, request: HttpServletRequest): AjaxUtils<*> {
        if (!bindingResult.hasErrors()) {
            val links = linksService.findById(linksEditVo.linkId!!)
            links.linkName = linksEditVo.linkName
            links.linkNameEn = linksEditVo.linkNameEn
            links.linkUrl = linksEditVo.linkUrl
            links.linkShow = linksEditVo.linkShow
            linksService.update(links)
            return AjaxUtils.of<Any>().success().msg("更新成功")
        }
        return AjaxUtils.of<Any>().fail().msg("更新失败")
    }
}