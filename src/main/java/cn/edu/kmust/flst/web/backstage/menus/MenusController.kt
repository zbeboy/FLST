package cn.edu.kmust.flst.web.backstage.menus

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.pojos.Menus
import cn.edu.kmust.flst.service.backstage.menus.MenusService
import cn.edu.kmust.flst.service.util.UUIDUtils
import cn.edu.kmust.flst.web.bean.backstage.menus.MenusBean
import cn.edu.kmust.flst.web.util.AjaxUtils
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import cn.edu.kmust.flst.web.vo.backstage.menus.MenusAddVo
import cn.edu.kmust.flst.web.vo.backstage.menus.MenusEditVo
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.ObjectUtils
import org.springframework.util.StringUtils
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid

/**
 * Created by zbeboy 2018-04-11 .
 **/
@Controller
open class MenusController {

    @Resource
    open lateinit var menusService: MenusService

    /**
     * 栏目管理
     *
     * @return 栏目管理
     */
    @RequestMapping(value = ["/web/backstage/menus"], method = [(RequestMethod.GET)])
    fun menu(): String {
        return "backstage/menus/menus_list"
    }

    /**
     * 栏目管理添加
     *
     * @return 栏目管理添加
     */
    @RequestMapping(value = ["/web/backstage/menus/add"], method = [(RequestMethod.GET)])
    fun add(modelMap: ModelMap): String {
        modelMap.addAttribute("linkZhPrefix", Workbook.LINK_ZH_PREFIX)
        modelMap.addAttribute("linkEnPrefix", Workbook.LINK_EN_PREFIX)
        return "backstage/menus/menus_add"
    }

    /**
     * 栏目管理编辑
     *
     * @return 栏目管理添加
     */
    @RequestMapping(value = ["/web/backstage/menus/edit/{menuId}"], method = [(RequestMethod.GET)])
    fun edit(@PathVariable("menuId") id: String, modelMap: ModelMap): String {
        modelMap.addAttribute("linkZhPrefix", Workbook.LINK_ZH_PREFIX)
        modelMap.addAttribute("linkEnPrefix", Workbook.LINK_EN_PREFIX)
        val menus = menusService.findById(id)
        return if (!ObjectUtils.isEmpty(menus)) {
            menus.menuLink = dealEditLink(menus.menuLink, Workbook.LINK_ZH_PREFIX)
            menus.menuLinkEn = dealEditLink(menus.menuLinkEn, Workbook.LINK_EN_PREFIX)
            modelMap.addAttribute("menus", menus)
            "backstage/menus/menus_edit"
        } else {
            modelMap.addAttribute("status", 500)
            modelMap.addAttribute("message", "未查询到该栏目信息")
            "error"
        }
    }

    /**
     * 列表数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/menus/data"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun menuData(request: HttpServletRequest): BootstrapTableUtils<MenusBean> {
        val bootstrapTableUtils = BootstrapTableUtils<MenusBean>(request)
        val records = menusService.findAllByPage(bootstrapTableUtils)
        var menus: List<MenusBean> = ArrayList()
        if (!ObjectUtils.isEmpty(records) && records.isNotEmpty) {
            menus = records.into(MenusBean::class.java)
        }
        bootstrapTableUtils.total = menusService.countByCondition(bootstrapTableUtils)
        bootstrapTableUtils.rows = menus
        return bootstrapTableUtils
    }

    /**
     * 获取栏目父id数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/menus/pids"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun pids(): AjaxUtils<Menus> {
        return AjaxUtils.of<Menus>().success().msg("获取数据成功").listData(menusService.findByMenuFixed(0))
    }

    /**
     * 栏目中文名检验
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/menus/add/valid/name"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun addValidName(@RequestParam("menuName") name: String): AjaxUtils<*> {
        val menuName = StringUtils.trimAllWhitespace(name)
        if (StringUtils.hasLength(menuName)) {
            val menus = menusService.findByMenuName(menuName)
            return if (ObjectUtils.isEmpty(menus)) {
                AjaxUtils.of<Any>().success().msg("栏目中文名不存在")
            } else {
                AjaxUtils.of<Any>().fail().msg("栏目中文名已存在")
            }
        }
        return AjaxUtils.of<Any>().fail().msg("栏目中文名不能为空")
    }

    /**
     * 栏目英文名检验
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/menus/add/valid/name_en"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun addValidNameEn(@RequestParam("menuNameEn") name: String): AjaxUtils<*> {
        val menuNameEn = StringUtils.trimAllWhitespace(name)
        if (StringUtils.hasLength(menuNameEn)) {
            val menus = menusService.findByMenuNameEn(menuNameEn)
            return if (ObjectUtils.isEmpty(menus)) {
                AjaxUtils.of<Any>().success().msg("栏目英文名不存在")
            } else {
                AjaxUtils.of<Any>().fail().msg("栏目英文名已存在")
            }
        }
        return AjaxUtils.of<Any>().fail().msg("栏目英文名不能为空")
    }

    /**
     * 栏目中文名检验
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/menus/edit/valid/name"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun editValidName(@RequestParam("menuId") menuId: String, @RequestParam("menuName") name: String): AjaxUtils<*> {
        val menuName = StringUtils.trimAllWhitespace(name)
        if (StringUtils.hasLength(menuName)) {
            val menus = menusService.findByMenuNameNeMenuId(menuName, menuId)
            return if (ObjectUtils.isEmpty(menus)) {
                AjaxUtils.of<Any>().success().msg("栏目中文名不存在")
            } else {
                AjaxUtils.of<Any>().fail().msg("栏目中文名已存在")
            }
        }
        return AjaxUtils.of<Any>().fail().msg("栏目中文名不能为空")
    }

    /**
     * 栏目英文名检验
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/menus/edit/valid/name_en"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun editValidNameEn(@RequestParam("menuId") menuId: String, @RequestParam("menuNameEn") name: String): AjaxUtils<*> {
        val menuNameEn = StringUtils.trimAllWhitespace(name)
        if (StringUtils.hasLength(menuNameEn)) {
            val menus = menusService.findByMenuNameEnNeMenuId(menuNameEn, menuId)
            return if (ObjectUtils.isEmpty(menus)) {
                AjaxUtils.of<Any>().success().msg("栏目英文名不存在")
            } else {
                AjaxUtils.of<Any>().fail().msg("栏目英文名已存在")
            }
        }
        return AjaxUtils.of<Any>().fail().msg("栏目英文名不能为空")
    }

    /**
     * 保存
     *
     * @param menusAddVo 数据
     * @param bindingResult 检验
     * @return 保存结果
     */
    @RequestMapping(value = ["/web/backstage/menus/save"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun save(@Valid menusAddVo: MenusAddVo, bindingResult: BindingResult): AjaxUtils<*> {
        if (!bindingResult.hasErrors()) {
            val menus = Menus()
            menus.menuId = UUIDUtils.getUUID()
            menus.menuName = menusAddVo.menuName
            menus.menuNameEn = menusAddVo.menuNameEn
            menus.menuLink = dealAddLink(menusAddVo.menuLink!!, Workbook.LINK_ZH_PREFIX)
            menus.menuLinkEn = dealAddLink(menusAddVo.menuLinkEn!!, Workbook.LINK_EN_PREFIX)
            menus.menuPid = menusAddVo.menuPid
            menus.menuOrder = menusAddVo.menuOrder
            menus.menuShow = menusAddVo.menuShow
            menus.menuFixed = 0
            menusService.save(menus)
            return AjaxUtils.of<Any>().success().msg("保存成功")
        }
        return AjaxUtils.of<Any>().fail().msg("保存失败")
    }

    /**
     * 更新
     *
     * @param menusEditVo 数据
     * @param bindingResult 检验
     * @return 保存结果
     */
    @RequestMapping(value = ["/web/backstage/menus/update"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun update(@Valid menusEditVo: MenusEditVo, bindingResult: BindingResult): AjaxUtils<*> {
        if (!bindingResult.hasErrors()) {
            val menus = menusService.findById(menusEditVo.menuId!!)
            menus.menuName = menusEditVo.menuName
            menus.menuNameEn = menusEditVo.menuNameEn
            menus.menuLink = dealAddLink(menusEditVo.menuLink!!, Workbook.LINK_ZH_PREFIX)
            menus.menuLinkEn = dealAddLink(menusEditVo.menuLinkEn!!, Workbook.LINK_EN_PREFIX)
            menus.menuPid = menusEditVo.menuPid
            menus.menuOrder = menusEditVo.menuOrder
            menus.menuShow = menusEditVo.menuShow
            menusService.update(menus)
            return AjaxUtils.of<Any>().success().msg("更新成功")
        }
        return AjaxUtils.of<Any>().fail().msg("更新失败")
    }

    /**
     * 处理链接特殊字符
     *
     * @param link 待处理链接
     * @param prefix 链接前缀
     * @return 处理后链接
     */
    private fun dealAddLink(link: String, prefix: String): String {
        var lk = StringUtils.trimAllWhitespace(link)

        if (lk.startsWith(Workbook.HTTP_PREFIX) || lk.startsWith(Workbook.HTTPS_PREFIX)) {
            return lk
        }

        if (lk.startsWith('/')) {
            lk = lk.substring(1)
        }

        if (lk.contains('\\')) {
            lk = lk.replace('\\', '/')
        }
        return if (lk == "#") {
            "#"
        } else {
            prefix + lk
        }
    }

    /**
     * 处理链接特殊字符
     *
     * @param link 待处理链接
     * @param prefix 链接前缀
     * @return 处理后链接
     */
    private fun dealEditLink(link: String, prefix: String): String {
        if (link.startsWith(Workbook.HTTP_PREFIX) || link.startsWith(Workbook.HTTPS_PREFIX)) {
            return link
        }
        return link.replace(prefix, "")
    }

}