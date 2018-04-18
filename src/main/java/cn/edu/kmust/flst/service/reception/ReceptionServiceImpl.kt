package cn.edu.kmust.flst.service.reception

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.service.backstage.data.DataInfoService
import cn.edu.kmust.flst.service.backstage.links.LinksService
import cn.edu.kmust.flst.web.bean.backstage.links.LinksBean
import org.springframework.stereotype.Service
import org.springframework.ui.ModelMap
import org.springframework.web.servlet.LocaleResolver
import java.util.*
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

    override fun commonData(modelMap: ModelMap, request: HttpServletRequest) {
        val language = localeResolver.resolveLocale(request).displayLanguage
        val websiteRecord = dataInfoService.findByPrefix(Workbook.WEBSITE_PREFIX)

        if (language == Workbook.LANGUAGE_ZH_CN_NAME) {
            modelMap.addAttribute("language", Workbook.LANGUAGE_ZH_CN)
            modelMap.addAttribute("nav", navService.navHtml(Workbook.LANGUAGE_ZH_CN))
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
            modelMap.addAttribute("language", Workbook.LANGUAGE_EN)
            modelMap.addAttribute("nav", navService.navHtml(Workbook.LANGUAGE_EN))
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

        // 友情链接
        val linkRecord = linksService.findAllByLinkShow(1)
        var links: List<LinksBean> = ArrayList()
        if (linkRecord.isNotEmpty) {
            links = linkRecord.into(LinksBean::class.java)
        }
        modelMap.addAttribute("friendlyLinks", links)
    }


}