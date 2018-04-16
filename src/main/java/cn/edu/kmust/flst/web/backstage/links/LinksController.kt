package cn.edu.kmust.flst.web.backstage.links

import cn.edu.kmust.flst.service.backstage.links.LinksService
import cn.edu.kmust.flst.web.bean.backstage.links.LinksBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.springframework.stereotype.Controller
import org.springframework.util.ObjectUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

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
}