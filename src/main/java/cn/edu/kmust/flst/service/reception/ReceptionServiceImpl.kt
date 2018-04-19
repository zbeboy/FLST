package cn.edu.kmust.flst.service.reception

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.pojos.Menus
import cn.edu.kmust.flst.service.backstage.banner.BannerService
import cn.edu.kmust.flst.service.backstage.data.DataInfoService
import cn.edu.kmust.flst.service.backstage.links.LinksService
import cn.edu.kmust.flst.service.backstage.menus.MenusService
import cn.edu.kmust.flst.web.bean.backstage.banner.BannerBean
import cn.edu.kmust.flst.web.bean.backstage.links.LinksBean
import org.springframework.stereotype.Service
import org.springframework.ui.ModelMap
import org.springframework.util.ObjectUtils
import org.springframework.web.servlet.LocaleResolver
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

@Service("receptionService")
open class ReceptionServiceImpl : ReceptionService {

    @Resource
    open lateinit var localeResolver: LocaleResolver

    @Resource
    open lateinit var navService: NavService

    @Resource
    open lateinit var dataInfoService: DataInfoService

    @Resource
    open lateinit var linksService: LinksService

    @Resource
    open lateinit var bannerService: BannerService

    @Resource
    open lateinit var menusService: MenusService

    override fun navData(modelMap: ModelMap, request: HttpServletRequest) {
        val language = localeResolver.resolveLocale(request).displayLanguage
        if (language == Workbook.LANGUAGE_ZH_CN_NAME) {
            modelMap.addAttribute("language", Workbook.LANGUAGE_ZH_CN)
            modelMap.addAttribute("nav", navService.navHtml(Workbook.LANGUAGE_ZH_CN))
        } else {
            modelMap.addAttribute("language", Workbook.LANGUAGE_EN)
            modelMap.addAttribute("nav", navService.navHtml(Workbook.LANGUAGE_EN))
        }
    }

    override fun websiteData(modelMap: ModelMap, request: HttpServletRequest) {
        val language = localeResolver.resolveLocale(request).displayLanguage
        val websiteRecord = dataInfoService.findByPrefix(Workbook.WEBSITE_PREFIX)
        if (language == Workbook.LANGUAGE_ZH_CN_NAME) {
            if (websiteRecord.isNotEmpty) {
                websiteRecord.forEach { r ->
                    if (r.dataKey != Workbook.WEBSITE_ADDRESS_EN) {
                        if (r.dataKey == Workbook.WEBSITE_ADDRESS) {
                            modelMap.addAttribute("website_address", r.dataValue)
                        } else {
                            modelMap.addAttribute(r.dataKey, r.dataValue)
                        }
                    }
                }
            }
        } else {
            if (websiteRecord.isNotEmpty) {
                websiteRecord.forEach { r ->
                    if (r.dataKey != Workbook.WEBSITE_ADDRESS) {
                        if (r.dataKey == Workbook.WEBSITE_ADDRESS_EN) {
                            modelMap.addAttribute("website_address", r.dataValue)
                        } else {
                            modelMap.addAttribute(r.dataKey, r.dataValue)
                        }
                    }
                }
            }
        }
    }

    override fun bannerData(modelMap: ModelMap, menuId: String) {
        val bannerRecord = bannerService.findByMenuIdAndBannerShow(menuId, 1)
        var banners: List<BannerBean> = ArrayList()
        if (bannerRecord.isNotEmpty) {
            banners = bannerRecord.into(BannerBean::class.java)
            banners.forEach { i ->
                i.bannerLinkPath = Workbook.MY_IMAGES_PATH + i.bannerLink
            }
        }
        modelMap.addAttribute("banners", banners)
    }

    override fun linksData(modelMap: ModelMap) {
        val linkRecord = linksService.findAllByLinkShow(1)
        var links: List<LinksBean> = ArrayList()
        if (linkRecord.isNotEmpty) {
            links = linkRecord.into(LinksBean::class.java)
        }
        modelMap.addAttribute("friendlyLinks", links)
    }

    override fun columnsData(modelMap: ModelMap, menuId: String) {
        val records = menusService.findByPIdAndMenuShow(menuId, 1)
        var columns: List<Menus> = java.util.ArrayList()
        if (records.isNotEmpty) {
            columns = records.into(Menus::class.java)
        }
        modelMap.addAttribute("columns", columns)
    }


    override fun getMaxPid(menus:Menus,list:ArrayList<Menus>){
        if(menus.menuPid != "0"){
            val menu = menusService.findById(menus.menuPid)
            getMaxPid(menu,list)
        }
        list.add(menus)
    }


}