package cn.edu.kmust.flst.web.backstage.banner

import cn.edu.kmust.flst.config.FLSTProperties
import cn.edu.kmust.flst.config.Workbook
import cn.edu.kmust.flst.domain.flst.tables.pojos.Banner
import cn.edu.kmust.flst.service.backstage.banner.BannerService
import cn.edu.kmust.flst.service.backstage.menus.MenusService
import cn.edu.kmust.flst.service.common.UploadService
import cn.edu.kmust.flst.service.system.UsersService
import cn.edu.kmust.flst.service.util.DateTimeUtils
import cn.edu.kmust.flst.service.util.RequestUtils
import cn.edu.kmust.flst.web.bean.backstage.banner.BannerBean
import cn.edu.kmust.flst.web.bean.backstage.menus.MenusBean
import cn.edu.kmust.flst.web.bean.file.FileBean
import cn.edu.kmust.flst.web.common.MethodControllerCommon
import cn.edu.kmust.flst.web.util.AjaxUtils
import cn.edu.kmust.flst.web.util.BootstrapTableUtils
import cn.edu.kmust.flst.web.util.ImageUtils
import cn.edu.kmust.flst.web.vo.backstage.banner.BannerEditVo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.util.ObjectUtils
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartHttpServletRequest
import java.util.*
import javax.annotation.Resource
import javax.servlet.http.HttpServletRequest
import javax.validation.Valid
import kotlin.collections.HashMap

/**
 * Created by zbeboy 2018-04-14 .
 **/
@Controller
open class BannerController {

    private val log = LoggerFactory.getLogger(BannerController::class.java)

    @Autowired
    open lateinit var flstProperties: FLSTProperties

    @Resource
    open lateinit var usersService: UsersService

    @Resource
    open lateinit var bannerService: BannerService

    @Resource
    open lateinit var menusService: MenusService

    @Resource
    open lateinit var uploadService: UploadService

    @Resource
    open lateinit var methodControllerCommon: MethodControllerCommon

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
        }
        modelMap.addAttribute("banners", bannerList)
        modelMap.addAttribute("menus", menus)
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
            val path = flstProperties.getConstants().staticImages + Workbook.DIRECTORY_SPLIT
            val fileBeen = uploadService.upload(multipartHttpServletRequest,
                    RequestUtils.getRealPath(request) + path, request.remoteAddr)
            if (fileBeen.isNotEmpty() && fileBeen.size > 0) {
                fileBeen.forEach { i ->
                    // 不压缩动态图
                    if (!org.apache.commons.lang3.StringUtils.equalsIgnoreCase(i.ext, "gif")) {
                        val filePath = RequestUtils.getRealPath(request) + flstProperties.getConstants().staticImages
                        val fileName = if (i.newName!!.lastIndexOf('.') > 0) i.newName!!.substring(0, i.newName!!.lastIndexOf('.')) + "_compress." + i.ext else i.newName + "_compress"
                        // 压缩图片
                        ImageUtils.optimize(filePath + "/" + i.newName, "$filePath/$fileName", 0.5f)
                        i.newName = flstProperties.getConstants().staticImages + "/" + fileName
                    } else {
                        i.newName = flstProperties.getConstants().staticImages + "/" + i.newName
                    }
                }
                val banner = Banner()
                banner.bannerLink = fileBeen[0].newName
                banner.bannerDate = DateTimeUtils.getNow()
                banner.bannerShow = true
                banner.menuId = menuId
                banner.bannerCreator = usersService.getUsernameFromSession()
                val bannerId = bannerService.saveAndReturnId(banner)
                ajaxUtils.success().msg("保存文件成功").listData(fileBeen).obj(bannerId)
            } else {
                ajaxUtils.fail().msg("未发现文件")
            }
        } catch (e: Exception) {
            log.error("Upload banner error, error is {}", e)
            ajaxUtils.fail().msg("保存文件异常")
        }

        return ajaxUtils
    }

    /**
     * 更新
     *
     * @param bannerEditVo 数据
     * @param bindingResult 检验
     * @return 保存结果
     */
    @RequestMapping(value = ["/web/backstage/banner/update"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun update(@Valid bannerEditVo: BannerEditVo, bindingResult: BindingResult): HashMap<String, String> {
        val map = HashMap<String, String>()
        if (!bindingResult.hasErrors()) {
            val banner = bannerService.findById(bannerEditVo.pk!!)
            if (bannerEditVo.name == "bannerTitle") {
                banner.bannerTitle = bannerEditVo.value
            }

            if (bannerEditVo.name == "bannerTitleEn") {
                banner.bannerTitleEn = bannerEditVo.value
            }

            if (bannerEditVo.name == "bannerBrief") {
                banner.bannerBrief = bannerEditVo.value
            }

            if (bannerEditVo.name == "bannerBriefEn") {
                banner.bannerBriefEn = bannerEditVo.value
            }

            bannerService.update(banner)
            map["status"] = "ok"
            map["msg"] = "更新成功"
            return map
        }
        map["status"] = "error"
        map["msg"] = "更新失败"
        return map
    }

    /**
     * 显示
     *
     * @param bannerId id
     * @param bannerShow 显示
     * @return 结果
     */
    @RequestMapping(value = ["/web/backstage/banner/show"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun show(@RequestParam("bannerId") bannerId: Int, @RequestParam("bannerShow") bannerShow: Boolean): AjaxUtils<*> {
        val banner = bannerService.findById(bannerId)
        banner.bannerShow = bannerShow
        bannerService.update(banner)
        return AjaxUtils.of<Any>().success().msg("更新成功")
    }

    /**
     * 删除
     *
     * @param bannerId id
     * @return 结果
     */
    @RequestMapping(value = ["/web/backstage/banner/delete"], method = [(RequestMethod.POST)])
    @ResponseBody
    fun delete(@RequestParam("bannerId") bannerId: Int, request: HttpServletRequest): AjaxUtils<*> {
        val banner = bannerService.findById(bannerId)
        methodControllerCommon.deletePicFile(request, banner.bannerLink)
        bannerService.deleteById(bannerId)
        return AjaxUtils.of<Any>().success().msg("删除成功")
    }
}