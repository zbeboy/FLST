package cn.edu.kmust.flst.service.reception

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.records.MenusRecord
import cn.edu.kmust.flst.service.backstage.menus.MenusService
import org.jooq.Result
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils
import javax.annotation.Resource

/**
 * Created by zbeboy 2018-04-15 .
 **/
@Service("navService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class NavServiceImpl : NavService {

    @Resource
    open lateinit var menusService: MenusService

    override fun navHtml(language: String): String {
        var ul = "<ul class=\"nav navbar-nav nav-menu\">"
        var li = if (language == Workbook.LANGUAGE_ZH_CN) {
            "<li><a href=\"/\">网站首页</a></li>"
        } else {
            "<li><a href=\"/\">Home</a></li>"
        }
        val list1 = menusService.findByPIdAndMenuShowAndMenuFixed("0", 1, 0)
        if (!ObjectUtils.isEmpty(list1)) {
            for (menu1 in list1) {
                li += "<li"
                val list2 = menusService.findByPIdAndMenuShowAndMenuFixed(menu1.menuId, 1, 0)
                if (!ObjectUtils.isEmpty(list2)) {
                    li += " class=\"dropdown\">"
                    li += "<a href=\"${menu1.menuLink}\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">${menu1.menuName} <span class=\"caret\"></span></a>"
                    li += "<ul class=\"dropdown-menu\">"
                    // 开始次级递归生成
                    li = generateHtml(list2, li, language)
                } else {
                    li += "><a href=\"${menu1.menuLink}\">${menu1.menuName}</a></li>"
                }
            }
            ul = ul + li + "</ul>"
        } else {
            ul += "</ul>"
        }
        return ul
    }

    /**
     * 递归
     *
     * @param menus 栏目
     * @param next 文本
     * @return 生成
     */
    fun generateHtml(menus: Result<MenusRecord>, next: String, language: String): String {
        var li = next
        for (menu in menus) {
            val list = menusService.findByPIdAndMenuShowAndMenuFixed(menu.menuId, 1, 0)
            if (!ObjectUtils.isEmpty(list)) {
                li += "<li class=\"dropdown-submenu\"> "
                li += "<a href=\"${menu.menuLink}\">${menu.menuName}</a>"
                li += "<ul class=\"dropdown-menu\"> "
                li = generateHtml(list, li, language)
            } else {
                li += "<li><a href=\"${menu.menuLink}\">${menu.menuName}</a></li>"
            }
        }
        li += "</ul></li>"
        return li
    }
}