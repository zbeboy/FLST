package cn.edu.kmust.flst.service.reception

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.pojos.Menus
import cn.edu.kmust.flst.domain.tables.records.MenusRecord
import cn.edu.kmust.flst.service.backstage.menus.MenusService
import cn.edu.kmust.flst.service.util.RequestUtils
import org.jooq.Result
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.util.ObjectUtils
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

/**
 * Created by zbeboy 2018-04-15 .
 **/
@Service("navService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
open class NavServiceImpl : NavService {

    @Resource
    open lateinit var menusService: MenusService

    override fun navHtml(request: HttpServletRequest, language: String): String {
        var ul = "<ul class=\"nav navbar-nav nav-menu\">"
        if (language == Workbook.LANGUAGE_ZH_CN) {
            var li = "<li><a href=\"${RequestUtils.getBaseUrl(request)}\">网站首页</a></li>"
            val list1 = menusService.findByPIdAndMenuShowAndMenuFixed("0", 1, 0)
            if (!ObjectUtils.isEmpty(list1)) {
                for (menu1 in list1) {
                    li += "<li"
                    val list2 = menusService.findByPIdAndMenuShowAndMenuFixed(menu1.menuId, 1, 0)
                    if (!ObjectUtils.isEmpty(list2)) {
                        li += " class=\"dropdown\">"
                        li += "<a href=\"${getUrl(menu1.menuLink, menu1.menuId, request)}\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">${menu1.menuName} <span class=\"caret\"></span></a>"
                        li += "<ul class=\"dropdown-menu\">"
                        // 开始次级递归生成
                        li = generateHtml(list2, li, request, language)
                    } else {
                        li += "><a href=\"${getUrl(menu1.menuLink, menu1.menuId, request)}\">${menu1.menuName}</a></li>"
                    }
                }
                ul = ul + li + "</ul>"
            } else {
                ul += "</ul>"
            }
        } else {
            var li = "<li><a href=\"${RequestUtils.getBaseUrl(request)}\">Home</a></li>"
            val list1 = menusService.findByPIdAndMenuShowAndMenuFixed("0", 1, 0)
            if (!ObjectUtils.isEmpty(list1)) {
                for (menu1 in list1) {
                    li += "<li"
                    val list2 = menusService.findByPIdAndMenuShowAndMenuFixed(menu1.menuId, 1, 0)
                    if (!ObjectUtils.isEmpty(list2)) {
                        li += " class=\"dropdown\">"
                        li += "<a href=\"${getUrl(menu1.menuLinkEn, menu1.menuId, request)}\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">${menu1.menuNameEn} <span class=\"caret\"></span></a>"
                        li += "<ul class=\"dropdown-menu\">"
                        // 开始次级递归生成
                        li = generateHtml(list2, li, request, language)
                    } else {
                        li += "><a href=\"${getUrl(menu1.menuLinkEn, menu1.menuId, request)}\">${menu1.menuNameEn}</a></li>"
                    }
                }
                ul = ul + li + "</ul>"
            } else {
                ul += "</ul>"
            }
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
    fun generateHtml(menus: Result<MenusRecord>, next: String, request: HttpServletRequest, language: String): String {
        var li = next
        if (language == Workbook.LANGUAGE_ZH_CN) {
            for (menu in menus) {
                val list = menusService.findByPIdAndMenuShowAndMenuFixed(menu.menuId, 1, 0)
                if (!ObjectUtils.isEmpty(list)) {
                    li += "<li class=\"dropdown-submenu\"> "
                    li += "<a href=\"${getUrl(menu.menuLink, menu.menuId, request)}\">${menu.menuName}</a>"
                    li += "<ul class=\"dropdown-menu\"> "
                    li = generateHtml(list, li, request, language)
                } else {
                    li += "<li><a href=\"${getUrl(menu.menuLink, menu.menuId, request)}\">${menu.menuName}</a></li>"
                }
            }
        } else {
            for (menu in menus) {
                val list = menusService.findByPIdAndMenuShowAndMenuFixed(menu.menuId, 1, 0)
                if (!ObjectUtils.isEmpty(list)) {
                    li += "<li class=\"dropdown-submenu\"> "
                    li += "<a href=\"${getUrl(menu.menuLinkEn, menu.menuId, request)}\">${menu.menuNameEn}</a>"
                    li += "<ul class=\"dropdown-menu\"> "
                    li = generateHtml(list, li, request, language)
                } else {
                    li += "<li><a href=\"${getUrl(menu.menuLinkEn, menu.menuId, request)}\">${menu.menuNameEn}</a></li>"
                }
            }
        }
        li += "</ul></li>"
        return li
    }

    /**
     * 处理Url
     */
    fun getUrl(link: String, id: String, request: HttpServletRequest): String {
        return if (link == "#") {
            "#"
        } else {
            if (link.startsWith(Workbook.HTTP_PREFIX) || link.startsWith(Workbook.HTTPS_PREFIX)) {
                link
            } else {
                if (link.contains("?") && link.contains("&")) {
                    RequestUtils.getBaseUrl(request) + link + "&menuId=$id"
                } else if (link.contains("?") && !link.contains("&")) {
                    RequestUtils.getBaseUrl(request) + link + "menuId=$id"
                } else {
                    RequestUtils.getBaseUrl(request) + link + "?menuId=$id"
                }
            }
        }
    }
}