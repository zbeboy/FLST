package cn.edu.kmust.flst.web.backstage.banner

import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.tables.pojos.Banner
import cn.edu.kmust.flst.service.backstage.banner.BannerService
import cn.edu.kmust.flst.service.backstage.menus.MenusService
import cn.edu.kmust.flst.service.common.UploadService
import cn.edu.kmust.flst.service.system.UsersService
import cn.edu.kmust.flst.service.util.DateTimeUtils
import cn.edu.kmust.flst.service.util.RequestUtils
import cn.edu.kmust.flst.web.bean.backstage.banner.BannerBean
import cn.edu.kmust.flst.web.bean.backstage.menus.MenusBean
import cn.edu.kmust.flst.web.bean.file.FileBean
import cn.edu.kmust.flst.web.util.AjaxUtils
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.ObjectUtils
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartHttpServletRequest
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest

/**
 * Created by zbeboy 2018-04-14 .
 **/
@Controller
open class BannerController {

    private val log = LoggerFactory.getLogger(BannerController::class.java)

    @Resource
    open lateinit var usersService: UsersService

    @Resource
    open lateinit var bannerService: BannerService

    @Resource
    open lateinit var menusService: MenusService

    @Resource
    open lateinit var uploadService: UploadService

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
     * banner管理编辑
     *
     * @return banner管理编辑
     */
    @RequestMapping(value = ["/web/backstage/banner/edit/{menuId}"], method = [(RequestMethod.GET)])
    fun edit(@PathVariable("menuId") id: String, modelMap: ModelMap): String {
        val menus = menusService.findById(id)
        val banners = bannerService.findByMenuId(id)
        var bannerList: List<BannerBean> = ArrayList()
        if (banners.isNotEmpty) {
            bannerList = banners.into(BannerBean::class.java)
            bannerList.forEach { i ->
                i.bannerLinkPath = "/user/images/" + i.bannerLink
            }
        }
        modelMap.addAttribute("banners", bannerList)
        modelMap.addAttribute("menus", menus);
        return "backstage/banner/banner_edit"
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

    /**
     * 上传
     *
     * @param multipartHttpServletRequest   文件
     * @param request                       请求
     * @return true or false
     */
    @RequestMapping("/web/backstage/banner/upload")
    @ResponseBody
    fun bannerUpload(@RequestParam("menuId") menuId: String, multipartHttpServletRequest: MultipartHttpServletRequest, request: HttpServletRequest): AjaxUtils<FileBean> {
        val ajaxUtils = AjaxUtils.of<FileBean>()
        try {
            val path = Workbook.imagesPath()
            val fileBeen = uploadService.upload(multipartHttpServletRequest,
                    RequestUtils.getRealPath(request) + path, request.remoteAddr)
            if (fileBeen.isNotEmpty() && fileBeen.size > 0) {
                val banner = Banner()
                banner.bannerLink = fileBeen[0].newName
                banner.bannerDate = DateTimeUtils.getNow()
                banner.bannerShow = 1
                banner.menuId = menuId
                banner.username = usersService.getUsernameFromSession()
                bannerService.save(banner)
                ajaxUtils.success().msg("保存文件成功").listData(fileBeen).obj(1)
            } else {
                ajaxUtils.fail().msg("未发现文件")
            }
        } catch (e: Exception) {
            log.error("Upload banner error, error is {}", e)
            ajaxUtils.fail().msg("保存文件异常")
        }

        return ajaxUtils
    }
}