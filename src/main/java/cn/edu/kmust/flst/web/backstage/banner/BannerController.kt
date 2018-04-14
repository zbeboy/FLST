package cn.edu.kmust.flst.web.backstage.banner

import cn.edu.kmust.flst.service.backstage.banner.BannerService
import cn.edu.kmust.flst.web.bean.backstage.menus.MenusBean
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.springframework.stereotype.Controller
import org.springframework.util.ObjectUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import java.util.ArrayList
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

/**
 * Created by zbeboy 2018-04-14 .
 **/
@Controller
open class BannerController {

    @Resource
    open lateinit var bannerService: BannerService

    /**
     * banner管理
     *
     * @return banner管理
     */
    @RequestMapping(value = ["/web/backstage/banner"], method = [(RequestMethod.GET)])
    fun banner(): String {
        return "backstage/banner/banner_list"
    }

    /**
     * 列表数据
     *
     * @return 数据
     */
    @RequestMapping(value = ["/web/backstage/banner/data"], method = [(RequestMethod.GET)])
    @ResponseBody
    fun bannerData(request: HttpServletRequest): BootstrapTableUtils<MenusBean> {
        val bootstrapTableUtils = BootstrapTableUtils<MenusBean>(request)
        val records = bannerService.findAllByPage(bootstrapTableUtils)
        var menus: List<MenusBean> = ArrayList()
        if (!ObjectUtils.isEmpty(records) && records.isNotEmpty) {
            menus = records.into(MenusBean::class.java)
        }
        bootstrapTableUtils.total = bannerService.countByCondition(bootstrapTableUtils)
        bootstrapTableUtils.rows = menus
        return bootstrapTableUtils
    }
}